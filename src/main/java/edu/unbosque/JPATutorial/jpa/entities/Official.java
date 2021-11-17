package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Official") // Optional
@NamedQueries({
        @NamedQuery(name = "Official.findByUsername",
                query = "SELECT a FROM Official a WHERE a.username = :username")
})
public class Official {

    @Id
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(nullable = false)
    private String name;


    public Official() {}

    public Official(String username, String name) {
        this.username = username;
        this.name=name;

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

}

