package com.mikeshaggy.hms.model;

import com.mikeshaggy.hms.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Guest extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String idCardNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="address_id")
    private Address address;

    public Guest() {
    }

    public Guest(String firstName, String lastName, String email, String phoneNumber, String idCardNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idCardNumber = idCardNumber;
        this.address = address;
    }

    public Guest(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
}
