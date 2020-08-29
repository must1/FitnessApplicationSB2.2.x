package main.validator.uservalidator.availabilityvalidators;

import javassist.NotFoundException;
import main.entity.User;
import main.user.UserRepository;

public class UserPhoneValidator implements IUserAvailabilityValidator {

    @Override
    public String validate(User user, UserRepository userRepository) {
        try{
            userRepository.findByPhoneNumber(user.getPhoneNumber())
                    .orElseThrow(() -> new NotFoundException("User not found"));
        }
        catch (NotFoundException ex){
            return null;
        }
        return "User with given phone number already exists";
    }
}
