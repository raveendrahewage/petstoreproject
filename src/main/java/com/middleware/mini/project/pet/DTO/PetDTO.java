package com.middleware.mini.project.pet.DTO;

import com.middleware.mini.project.petcategory.Entity.Category;

import java.time.LocalDate;

public class PetDTO {
    private  long petId;
    private long typeId;
    private String petName;
    private LocalDate birthday;
    private String gender;
    private String owner;
    private double weight;

    public PetDTO() {
    }

    public PetDTO(long petId, long typeId, String petName, LocalDate birthday, String gender, String owner, double weight) {
        this.petId = petId;
        this.typeId=typeId;
        this.petName = petName;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = owner;
        this.weight = weight;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
