package net.briandupreez.client;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import net.briandupreez.provider.User;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.junit.Assert.assertThat;

public class TestProvider {
    @Rule
    public PactProviderRule provider = new PactProviderRule("test_provider", "localhost", 8081, this);

    @Pact(state = "default", provider = "test_provider", consumer = "test_consumer")
    public PactFragment createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");

        return builder
                .given("default")
                .uponReceiving("Test User Service")
                .path("/user/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("{" +
                        "  \"userName\": \"Bob\",\n" +
                        "  \"userId\": \"1\",\n" +
                        "  \"firstName\": null,\n" +
                        "  \"lastName\": null,\n" +
                        "  \"email\": null,\n" +
                        "  \"groups\": null\n" +
                        "}")
                .toFragment();
    }

    @Pact(state = "extra", provider = "test_provider", consumer = "test_consumer")
    public PactFragment createExtraFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");

        return builder
                .given("extra")
                .uponReceiving("Test User Service")
                .path("/user/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("{" +
                        "  \"userName\": \"Bob\",\n" +
                        "  \"userId\": \"1\",\n" +
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
        expectedResponse.setUserId("1");
        final User forEntity = call.getForObject(provider.getConfig().url() + "/user/1", User.class);
        assertThat(forEntity, sameBeanAs(expectedResponse));

    }
}
