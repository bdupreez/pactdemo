package net.briandupreez.provider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserService {

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}", produces = "application/json")
    public ResponseEntity<User> retrieveUser(@PathVariable String userId) {
        final User user = new User();
        if(userId.equals("3")){
            user.setUserName("John");
            user.setFirstName("John");
            user.setUserId("3");
        }else {
            user.setUserName("Bob");
            user.setUserId("1");
        }
        System.out.println("Called...");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
