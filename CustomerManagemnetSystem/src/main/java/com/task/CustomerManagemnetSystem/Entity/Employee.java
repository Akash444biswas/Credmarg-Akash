package com.task.CustomerManagemnetSystem.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {00
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true, nullable = false)
    private  String  email;
    private  String name;
    private  double  ctc ;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;
}
