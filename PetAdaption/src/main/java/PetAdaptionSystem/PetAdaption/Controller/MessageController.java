package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.Message;
import PetAdaptionSystem.PetAdaption.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Send a new message
    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    // Reply to a message
    @PostMapping("/reply")
    public Message replyToMessage(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam String content,
            @RequestParam Long replyToId) {
        return messageService.replyToMessage(senderId, receiverId, content, replyToId);
    }

    // Get chat history between two users
    @GetMapping("/{user1}/{user2}")
    public List<Message> getChatMessages(@PathVariable Long user1, @PathVariable Long user2) {
        return messageService.getChatMessages(user1, user2);
    }
}
