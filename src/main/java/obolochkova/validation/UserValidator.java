package obolochkova.validation;

import obolochkova.model.User;
import obolochkova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;
@Component
@Qualifier("userValidator")
public class UserValidator implements Validator {

    @Autowired
     private UserRepository userRepository;

    //which objects can be validated by this validator
    @Override
    public boolean supports(Class<?> paramClass) {
        return User.class.equals(paramClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        User user = (User) obj;

        if(userRepository.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "already exists", new Object[]{"'email'"}, "is already used");
        }


    }

}
