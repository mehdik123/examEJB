// GestionCDBean.java
package com.example.demowildfly;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class GestionCDBean implements CDServiceRemote{

    @PersistenceContext
    private EntityManager em;

    // Lister les CDs disponibles
    public List<CD> listerCDsDisponibles() {
        return em.createQuery("SELECT c FROM CD c WHERE c.disponible = true", CD.class)
                .getResultList();
    }

    // Emprunter un CD
    public void emprunterCD(Long cdId, String utilisateur) throws Exception {
        CD cd = em.find(CD.class, cdId);
        if (cd != null && cd.isDisponible()) {
            cd.setDisponible(false);
            Emprunt emprunt = new Emprunt();
            emprunt.setCd(cd);
            emprunt.setUtilisateur(utilisateur);
            emprunt.setDateEmprunt(LocalDate.now());
            em.persist(emprunt);
            em.merge(cd);
        } else {
            throw new Exception("CD non disponible.");
        }
    }

    // Voir les emprunts d'un utilisateur
    public List<Emprunt> voirEmprunts(String utilisateur) {
        return em.createQuery("SELECT e FROM Emprunt e WHERE e.utilisateur = :user", Emprunt.class)
                .setParameter("user", utilisateur)
                .getResultList();
    }

    // Retourner un CD
    public void retournerCD(Long empruntId) {
        Emprunt emprunt = em.find(Emprunt.class, empruntId);
        if (emprunt != null) {
            CD cd = emprunt.getCd();
            cd.setDisponible(true);
            em.merge(cd);
            em.remove(emprunt);
        }
    }
    @Override
    public List<CD> listerTousLesCDs() {
        return em.createQuery("SELECT c FROM CD c", CD.class).getResultList();
    }

    @Override
    public void ajouterCD(CD cd) {
        em.persist(cd);
    }

    @Override
    public void modifierCD(CD cd) {
        em.merge(cd);
    }

    @Override
    public void supprimerCD(Long cdId) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null) {
            em.remove(cd);
        }
    }
}
