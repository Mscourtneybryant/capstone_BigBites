package com.capstone.Capstone_backend.model;

import com.capstone.Capstone_backend.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity //map java class with the database table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) //automatically generate id number
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private USER_ROLE role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer") //tells spring not to create separate
    //table for this mapping
    private List<Order> orders = new ArrayList<>();
    @ElementCollection
    private List<RestaurantDto>favorites=new ArrayList();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //cascade so if any user is deleted,
    // all the addresses connected to them will be deleted too
    private List<Address> addresses = new ArrayList<>();



}
