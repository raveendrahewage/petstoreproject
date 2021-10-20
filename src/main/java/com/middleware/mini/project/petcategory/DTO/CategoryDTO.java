package com.middleware.mini.project.petcategory.DTO;

public class CategoryDTO {
    private long typeId;
    private String name;
    private String dynasty;
    private String region;
    private String scientificName;

    public CategoryDTO(long typeId, String name, String dynasty, String region, String scientificName) {
        this.typeId = typeId;
        this.name = name;
        this.dynasty = dynasty;
        this.region = region;
        this.scientificName = scientificName;
    }

    public CategoryDTO() {
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
}
