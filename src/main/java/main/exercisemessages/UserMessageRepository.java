package main.exercisemessages;

import main.model.user.UserMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMessageRepository extends CrudRepository<UserMessage, Long> {

    List<UserMessage> getAllByUserId(Long userID);
}
