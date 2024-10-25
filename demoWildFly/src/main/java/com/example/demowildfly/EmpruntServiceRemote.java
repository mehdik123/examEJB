package com.example.demowildfly;

import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface EmpruntServiceRemote {
    List<Emprunt> listerEmpruntsEnCours();
}
