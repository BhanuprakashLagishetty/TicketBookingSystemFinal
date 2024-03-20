package com.example.BookTicket.validator;

import com.example.BookTicket.Models.TrainModel;
import com.example.BookTicket.Models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TrainValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TrainModel.class.equals(clazz);
    }
    public void validate(Object target, Errors errors) {
        TrainModel trainModel = (TrainModel) target;
        if (trainModel.getName().isBlank()) {
            errors.rejectValue("name", "Trainname","name should not be null");
        }
        if(trainModel.getArrivalStation().isBlank())
        {
            errors.rejectValue("name", "Trainname","Arrival Status ");
        }
    }

}
