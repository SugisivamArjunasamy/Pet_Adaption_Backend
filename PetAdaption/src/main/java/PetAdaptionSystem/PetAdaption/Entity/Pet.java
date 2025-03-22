package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Pet_Table")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petId;

    @Column(nullable = false, length = 100)
    private String petName;

    @Column(nullable = false)
    private int petAge;

    @Column(nullable = false, length = 100)
    private String category;  // ✅ Fixed Typo

    @Column(nullable = false, length = 100)
    private String breed;  // ✅ Fixed Typo

    @Column(nullable = false, length = 200)
    private String description;  // ✅ Fixed Typo

    @Column(nullable = false, length = 100)
    private String status;

    @Column(nullable = false)
    private int amount;

    // Getters and Setters
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getCategory() {  // ✅ Fixed Typo
        return category;
    }

    public void setCategory(String category) {  // ✅ Fixed Typo
        this.category = category;
    }

    public String getBreed() {  // ✅ Fixed Typo
        return breed;
    }

    public void setBreed(String breed) {  // ✅ Fixed Typo
        this.breed = breed;
    }

    public String getDescription() {  // ✅ Fixed Typo
        return description;
    }

    public void setDescription(String description) {  // ✅ Fixed Typo
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
