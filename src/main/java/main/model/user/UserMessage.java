package main.model.user;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_message_entity")
public class UserMessage {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "message")
    private String message;
    @Column(name = "is_acknowledged")
    private boolean isAcknowledged;
    @Column(name = "creation_time")
    private LocalDate creationTime;
}