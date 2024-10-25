package com.example.demowildfly;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GestionEmpruntBean implements EmpruntServiceRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Emprunt> listerEmpruntsEnCours() {
        return em.createQuery("SELECT e FROM Emprunt e", Emprunt.class).getResultList();
    }
}
