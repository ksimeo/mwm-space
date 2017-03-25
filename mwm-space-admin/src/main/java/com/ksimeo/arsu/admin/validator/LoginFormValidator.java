package com.ksimeo.arsu.admin.validator;

import com.ksimeo.arsu.entities.DTO.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Ksimeo. Created on 18.12.2016 at 14:07 for "mwm-space" project.
 * @version 1.0
 * @since 1.0
 */

@Component
public class LoginFormValidator implements Validator {

//    @Autowired
//    UserService usrServ;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserDTO usrDto = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.loginForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginForm.email");
    }
}
