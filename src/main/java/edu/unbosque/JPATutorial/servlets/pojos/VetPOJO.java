package edu.unbosque.JPATutorial.servlets.pojos;

public class VetPOJO {

    private String username;

    private String name;
    private String address;
    private String neighborhood;
    private String vet_id;

    public VetPOJO() {
    }

    public VetPOJO(String username, String name, String address, String neighborhood, String vet_id) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.vet_id = vet_id;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getVet_id() {
        return vet_id;
    }

    public void setVet_id(String vet_id) {
        this.vet_id = vet_id;
    }
}

