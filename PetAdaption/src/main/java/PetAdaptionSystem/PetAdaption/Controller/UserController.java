package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.User;
import PetAdaptionSystem.PetAdaption.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        Optional<User> user = userService.updateUser(id, updatedUser);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.ok(user.get()); // Returning deleted user data
        }
        return ResponseEntity.notFound().build();
    }
}
