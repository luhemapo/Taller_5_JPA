package edu.unbosque.JPATutorial.servlets.pojos;

public class VisitPOJO {

    private Integer visit_id;
    private String created_at;
    private String type;
    private String description;
    private String pet_id;
    private String vet_id;

    public VisitPOJO() {
    }

    public VisitPOJO(Integer visit_id, String created_at, String type, String description, String pet_id, String vet_id) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
        this.vet_id = vet_id;

    }

    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }

    public String getVet_id() {
        return vet_id;
    }

    public void setVet_id(String vet_id) {
        this.vet_id = vet_id;
    }
}

