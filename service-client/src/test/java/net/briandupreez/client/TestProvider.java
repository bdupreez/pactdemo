package net.briandupreez.client;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import net.briandupreez.provider.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestProvider {
    @Rule
    public PactProviderRule provider = new PactProviderRule("test_provider", "localhost", 8080, this);

    @Pact(provider = "test_provider", consumer = "test_consumer")
    public PactFragment createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("testreqheader", "testreqheadervalue");

        return builder
                .uponReceiving("ExampleJavaConsumerPactRuleTest test interaction")
                .path("/user")
                .method("GET")
                //.headers(headers)
                .willRespondWith()
                .status(200)
                .body("{" +
                        "  \"userName\": \"Bob\",\n" +
                        "  \"userId\": null,\n" +
                        "  \"firstName\": null,\n" +
                        "  \"lastName\": null,\n" +
                        "  \"email\": null,\n" +
                        "  \"groups\": null\n" +
                        "}")
                .toFragment();
    }

    @Test
    @PactVerification("test_provider")
    public void runTest() throws IOException {
        final RestTemplate call = new RestTemplate();


        final User expectedResponse = new User();
        expectedResponse.setUserName("Bob");
        final ResponseEntity<User> forEntity = call.getForEntity("http://localhost:8080/user", User.class);
        Assert.assertEquals(forEntity.getBody(), expectedResponse);

    }
}
