package com.example.adminclient;

import com.example.demowildfly.Emprunt;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface EmpruntServiceRemote {
    List<Emprunt> listerEmpruntsEnCours();
}
