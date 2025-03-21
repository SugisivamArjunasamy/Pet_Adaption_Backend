package PetAdaptionSystem.PetAdaption.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(nullable = false,length = 100)
    private String paymentDeatails;

    @Column(nullable = false,length = 100)
    private String status;
}
