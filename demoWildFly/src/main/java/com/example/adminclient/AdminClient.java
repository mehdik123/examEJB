package com.example.adminclient;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdminClient extends JFrame {

    private CDServiceRemote cdService;
    private EmpruntServiceRemote empruntService;

    private JTable tableCDs;
    private JTable tableEmprunts;

    public AdminClient() {
        // Initialisation de l'interface graphique
        // ...
    }

    private void initServices() throws NamingException {
        Context context = JNDIUtils.getInitialContext();

        // Le nom JNDI dépend de la configuration du serveur
        // Voici un exemple pour WildFly
        String cdServiceJNDI = "ejb:/demoWildFly//GestionCDBean!" + CDServiceRemote.class.getName();
        String empruntServiceJNDI = "ejb:/demoWildFly//GestionEmpruntBean!" + EmpruntServiceRemote.class.getName();

        cdService = (CDServiceRemote) context.lookup(cdServiceJNDI);
        empruntService = (EmpruntServiceRemote) context.lookup(empruntServiceJNDI);
    }

    // Autres méthodes (rafraichirTableCDs, ajouterCD, modifierCD, supprimerCD)
    // ...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminClient::new);
    }
}
