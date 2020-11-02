package main.exercisemessages;

import main.model.user.UserMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserMessageRepository extends CrudRepository<UserMessage, UUID> {

    List<UserMessage> getAllByUserId(UUID userID);
}
