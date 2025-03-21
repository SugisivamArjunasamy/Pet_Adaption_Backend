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
    private String catogori;

    @Column(nullable = false, length = 100)
    private String bread;

    @Column(nullable = false, length = 200)
    private String discription;

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

    public String getCatogori() {
        return catogori;
    }

    public void setCatogori(String catogori) {
        this.catogori = catogori;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
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
