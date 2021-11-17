package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vet") // Optional
@NamedQueries({
        @NamedQuery(name = "Vet.findByUsername",
                query = "SELECT a FROM Vet a WHERE a.username = :username")
})
public class Vet {

    @Id
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String vet_id;


    public Vet() {}

    public Vet(String username, String name, String address, String neighborhood, String vet_id) {
        this.username = username;
        this.name=name;
        this.address=address;
        this.neighborhood=neighborhood;
        this.vet_id=vet_id;

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

