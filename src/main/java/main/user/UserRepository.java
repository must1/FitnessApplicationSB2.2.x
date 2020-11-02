package main.user;

import main.exercise.BodyPartType;
import main.model.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT CASE WHEN COUNT(user) > 0 THEN true ELSE false END FROM User user WHERE user.id =:userID")
    boolean doesAccountExistsWithID(@Param("userID") UUID accountID);

    Optional<User> findByUsername(String name);

    Optional<User> findByEmail(String email);

    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> findUsersByFavouriteBodyPartType(BodyPartType bodyPartType);
}
