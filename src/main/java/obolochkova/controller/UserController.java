package obolochkova.controller;

import obolochkova.model.User;
import obolochkova.service.UserService;

import obolochkova.validation.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);


    @Autowired
    private UserService userService;


    @Autowired
    @Qualifier("userValidator")
    public  UserValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("/hello")
    public String home() {
        return "User Management is working!";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        Collection<User> list = userService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable("email") String email) {
        User user = userService.getByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/", headers = "Accept=application/json",
            method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createUser(@Validated @RequestBody User user) {
        try{
            userService.save(user);
        }catch (Exception e){
            String message = e.getMessage();
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll() {
        userService.removeAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("email") String email) {
        userService.removeByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
