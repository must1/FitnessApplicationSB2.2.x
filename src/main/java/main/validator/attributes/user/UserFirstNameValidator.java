package main.validator.attributes.user;

import main.model.user.User;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_FIRST_NAME_MESSAGE;

@Component
public class UserFirstNameValidator implements Validator<User> {

    @Override
    public String validate(User user) {
        String attribute = user.getFirstName();
        return attribute.isEmpty() ? EMPTY_FIRST_NAME_MESSAGE : null;
    }
}
