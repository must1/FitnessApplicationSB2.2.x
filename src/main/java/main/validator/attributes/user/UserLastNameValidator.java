package main.validator.attributes.user;

import main.model.user.User;
import main.validator.attributes.Validator;
import org.springframework.stereotype.Component;

import static main.validator.ErrorConstants.EMPTY_LAST_NAME_MESSAGE;

@Component
public class UserLastNameValidator implements Validator<User> {

    @Override
    public String validate(User user) {
        String attribute = user.getLastName();
        return attribute.isEmpty() ? EMPTY_LAST_NAME_MESSAGE : null;
    }
}
