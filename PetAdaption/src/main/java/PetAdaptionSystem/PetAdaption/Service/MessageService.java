package PetAdaptionSystem.PetAdaption.Service;

import PetAdaptionSystem.PetAdaption.Entity.Message;
import PetAdaptionSystem.PetAdaption.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message replyToMessage(Long senderId, Long receiverId, String content, Long replyToId) {
        Optional<Message> parentMessage = messageRepository.findById(replyToId);
        if (parentMessage.isEmpty()) {
            throw new RuntimeException("Original message not found!");
        }

        Message replyMessage = new Message();
        replyMessage.setSenderId(senderId);
        replyMessage.setReceiverId(receiverId);
        replyMessage.setContent(content);
        replyMessage.setReplyTo(parentMessage.get());

        return messageRepository.save(replyMessage);
    }

    public List<Message> getChatMessages(Long user1, Long user2) {
        return messageRepository.findMessagesBetweenUsers(user1, user2);
    }
}
