package main.exercisemessages;

import main.model.user.UserMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserMessageRepository extends CrudRepository<UserMessage, UUID> {

    List<UserMessage> getAllByUserId(UUID userID);

    @Query("SELECT u FROM UserMessage u join User user on u.userId=user.id where user.username=:username")
    UserMessage findByUsername(@Param("username") String username);
}
