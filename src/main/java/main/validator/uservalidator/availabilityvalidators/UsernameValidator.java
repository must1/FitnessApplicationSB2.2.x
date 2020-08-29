package main.validator.uservalidator.availabilityvalidators;

import javassist.NotFoundException;
import main.entity.User;
import main.user.UserRepository;

public class UsernameValidator implements IUserAvailabilityValidator {

    @Override
    public String validate(User user, UserRepository userRepository) {
        try{
            userRepository.findByUsername(user.getUsername())
                    .orElseThrow(() -> new NotFoundException("User not found"));
        }
        catch (NotFoundException ex){
            return null;
        }
        return "User with given username already exists";
    }
}
