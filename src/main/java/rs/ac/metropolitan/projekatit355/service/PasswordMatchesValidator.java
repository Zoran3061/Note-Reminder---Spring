package rs.ac.metropolitan.projekatit355.service;

import rs.ac.metropolitan.projekatit355.annotations.PasswordMatches;
import rs.ac.metropolitan.projekatit355.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator  implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        User user = (User) obj;
        return user.getPassword().equals(user.getPasswordConfirmation());
    }
}
