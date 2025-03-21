package PetAdaptionSystem.PetAdaption.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Message_table")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    @Column(nullable = false,length = 200)
    private String messaegDetails;
}
