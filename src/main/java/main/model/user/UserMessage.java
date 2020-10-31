package main.model.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String message;
    private boolean isAcknowledged;
    private LocalDate creationTime;
}
