// Emprunt.java
package com.example.demowildfly;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CD cd;

    private String utilisateur;

    private LocalDate dateEmprunt;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public CD getCd() {
        return cd;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
}
