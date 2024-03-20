package com.example.BookTicket.validator;

import com.example.BookTicket.Models.SearchTrainModel;
import com.example.BookTicket.Models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class SearchTrainValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SearchTrainModel.class.equals(clazz);
    }
    public void validate(Object target, Errors errors) {
        SearchTrainModel searchTrainModel = (SearchTrainModel) target;
        System.out.println("THis is bhanuprakash");

        if (searchTrainModel.getArrivalStation().isBlank()) {

            errors.rejectValue("arrivalStation", "arrivalStation","arrival station should not be null");

        }
        if(searchTrainModel.getDepartureStation().isBlank()){
            System.out.println("This is the bhanuprakash form siddipet");
            errors.rejectValue("departureStation", "departureStation","departure Station is not null");

        }
        if(searchTrainModel.getBookingDate().isBefore(LocalDate.now()))
        {
            errors.rejectValue("bookingDate", "bookingDate","booking date should not be past");

        }



    }

}
