package com.middleware.mini.project.pet.Entity;
import com.middleware.mini.project.petcategory.Entity.Category;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long petId;
    private String petName;
    private LocalDate birthday;
    private String gender;
    private String owner;
    private double weight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "typeId")
    private Category category;

    public Pets() {
    }

    public Pets(String petName, LocalDate birthday, String gender, String owner, double weight,Category category) {
        this.petName = petName;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = owner;
        this.weight = weight;
        this.category=category;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
