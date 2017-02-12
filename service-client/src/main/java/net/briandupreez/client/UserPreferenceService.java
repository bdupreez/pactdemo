package net.briandupreez.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import net.briandupreez.provider.User;

@RestController
public class UserPreferenceService {


    @RequestMapping(method = RequestMethod.GET, value = "/user/preference")
    public UserPreferences retrieveUserPreference() {
        final UserPreferences userPreferences = new UserPreferences();

        RestTemplate restTemplate = new RestTemplate();
        final User user = restTemplate.getForObject("http://localhost:8080/user", User.class);


        userPreferences.setUserName(user.getUserName());
        userPreferences.setUserId("1");
        userPreferences.setPreferences(Collections.singletonList("Stuff"));

        return userPreferences;
    }
}
