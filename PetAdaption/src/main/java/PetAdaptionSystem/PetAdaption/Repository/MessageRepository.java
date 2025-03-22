package PetAdaptionSystem.PetAdaption.Repository;

import PetAdaptionSystem.PetAdaption.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE (m.senderId = :user1 AND m.receiverId = :user2) OR (m.senderId = :user2 AND m.receiverId = :user1) ORDER BY m.timestamp")
    List<Message> findMessagesBetweenUsers(Long user1, Long user2);
}
