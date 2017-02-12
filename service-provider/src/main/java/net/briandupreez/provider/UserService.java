package net.briandupreez.provider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserService {

    @RequestMapping(method = RequestMethod.GET, value = "/user", produces = "application/json")
    @ResponseBody public ResponseEntity<User> retrieveUser(){
        final User user = new User();
        user.setUserName("Bob");
        user.setUserId("1");
        System.out.println("Called...");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
