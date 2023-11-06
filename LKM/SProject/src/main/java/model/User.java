package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ... other attributes ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ... other methods ...
}