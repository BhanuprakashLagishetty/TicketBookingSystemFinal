package com.example.BookTicket.validator;

import com.example.BookTicket.Models.PaymentModel;
import com.example.BookTicket.Models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }
    public void validate(Object target, Errors errors) {
        UserModel userModel = (UserModel) target;

        if (userModel.getUserName().isBlank()) {
            System.out.println("This is bhanuprakash");

                errors.rejectValue("userName", "userName","username should not be null");

        }
        if(userModel.getAge()<18)
        {
            errors.rejectValue("age", "age","age should be greater than 18");

        }

    }

}
