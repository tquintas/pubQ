package tquintas.pubq.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<AgeRange, Date> {
    private int minAge;
    private int maxAge;
    @Override
    public void initialize(AgeRange constraintValidator) {
        this.minAge = constraintValidator.min();
        this.maxAge = constraintValidator.max();
    }
    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null) return false;
        LocalDate birthday = date.toLocalDate();
        LocalDate now = LocalDate.now();
        int age = Period.between(birthday, now).getYears();
        return minAge <= age && age <= maxAge;
    }
}
