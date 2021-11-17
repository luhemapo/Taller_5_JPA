package edu.unbosque.JPATutorial.servlets.pojos;

public class OwnerPOJO {

    private String username;
    private String name;
    private String address;
    private String neighborhood;
    private String person_id;

    public OwnerPOJO() {
    }

    public OwnerPOJO(String username, String name, String address, String neighborhood, String person_id) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.person_id = person_id;

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

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }
}

