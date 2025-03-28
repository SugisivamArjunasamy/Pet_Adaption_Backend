package PetAdaptionSystem.PetAdaption.Controller;

import PetAdaptionSystem.PetAdaption.Entity.User;
import PetAdaptionSystem.PetAdaption.Entity.Pet;
import PetAdaptionSystem.PetAdaption.Service.UserService;
import PetAdaptionSystem.PetAdaption.Repository.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PetRepository petRepository;

    public UserController(UserService userService, PetRepository petRepository) {
        this.userService = userService;
        this.petRepository = petRepository;
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
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/auth/{email}")
    public ResponseEntity<Map<String, Object>> login(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isPresent()) {
            User foundUser = user.get();
            Map<String, Object> response = new HashMap<>();
            response.put("userId", foundUser.getUserId());
            response.put("username", foundUser.getUserName());
            response.put("email", foundUser.getEmail());
            response.put("role", foundUser.getRole());
            response.put("password",foundUser.getPassword());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "User not found"));
        }
    }

    @GetMapping("{userId}/adopted-pets") // Ensure "adopted-pets" (plural)
    public ResponseEntity<?> getAdoptedPets(@PathVariable Long userId) {
        List<Pet> adoptedPets = petRepository.findByAdoptedBy_UserId(userId);

        if (adoptedPets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "No adopted pets found"));
        }

        return ResponseEntity.ok(adoptedPets);
    }

}
