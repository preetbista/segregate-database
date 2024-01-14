package com.segregateDB.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.segregateDB.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "customer_detail")
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonAlias("first_name")
    private String firstName;
    @JsonAlias("last_name")
    private String lastName;
    @JsonAlias("phone_number")
    private String phoneNumber;
    private String address;
    private String gender;
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;
}
