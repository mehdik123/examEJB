package com.example.adminclient;

import com.example.demowildfly.CD;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface CDServiceRemote {
    List<CD> listerTousLesCDs();
    void ajouterCD(CD cd);
    void modifierCD(CD cd);
    void supprimerCD(Long cdId);
}
