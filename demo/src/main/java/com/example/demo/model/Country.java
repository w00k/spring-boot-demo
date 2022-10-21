package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@SequenceGenerator(name = "id", initialValue = 6)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "capital")
    private String capital;
}
