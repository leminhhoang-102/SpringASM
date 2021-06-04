package com.example.springasm.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "district",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Street> streets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Street> getStreets() {
        return  streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }

    public void addStreet(Street street) {
        if (this.streets == null){
            this.streets =new HashSet<>();
        }
        this.streets.add(street);
    }
}
