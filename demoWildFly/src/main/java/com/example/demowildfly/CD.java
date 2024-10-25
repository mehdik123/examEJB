// CD.java
package com.example.demowildfly;

import jakarta.persistence.*;



@Entity
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private boolean disponible = true;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
