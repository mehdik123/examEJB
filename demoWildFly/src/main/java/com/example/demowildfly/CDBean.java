// CDBean.java
package com.example.demowildfly;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("cdBean")
@SessionScoped
public class CDBean implements Serializable {

    @EJB
    private GestionCDBean gestionCDBean;

    private List<CD> cdsDisponibles;
    private List<Emprunt> mesEmprunts;
    private String utilisateur;

    @PostConstruct
    public void init() {
        // Récupérer l'utilisateur connecté (à implémenter selon votre mécanisme d'authentification)
        utilisateur = "utilisateur_exemple"; // Remplacez par le nom de l'utilisateur réel
        rafraichirCDsDisponibles();
        rafraichirMesEmprunts();
    }

    public void rafraichirCDsDisponibles() {
        cdsDisponibles = gestionCDBean.listerCDsDisponibles();
    }

    public void rafraichirMesEmprunts() {
        mesEmprunts = gestionCDBean.voirEmprunts(utilisateur);
    }

    public String emprunterCD(Long cdId) {
        try {
            gestionCDBean.emprunterCD(cdId, utilisateur);
            rafraichirCDsDisponibles();
            rafraichirMesEmprunts();
            return "mesEmprunts.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }

    public String retournerCD(Long empruntId) {
        gestionCDBean.retournerCD(empruntId);
        rafraichirCDsDisponibles();
        rafraichirMesEmprunts();
        return "cdsDisponibles.xhtml?faces-redirect=true";
    }

    // Getters et Setters

    public List<CD> getCdsDisponibles() {
        return cdsDisponibles;
    }

    public void setCdsDisponibles(List<CD> cdsDisponibles) {
        this.cdsDisponibles = cdsDisponibles;
    }

    public List<Emprunt> getMesEmprunts() {
        return mesEmprunts;
    }

    public void setMesEmprunts(List<Emprunt> mesEmprunts) {
        this.mesEmprunts = mesEmprunts;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
}
