package main.validator.uservalidator.availabilityvalidators;

import javassist.NotFoundException;
import main.entity.User;
import main.user.UserRepository;

public class UserEmailValidator implements IUserAvailabilityValidator {

    @Override
    public String validate(User user, UserRepository userRepository) {
        try{
            userRepository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new NotFoundException("User not found"));
        }
        catch (NotFoundException ex){
            return null;
        }
        return "User with given email already exists";
    }
}
