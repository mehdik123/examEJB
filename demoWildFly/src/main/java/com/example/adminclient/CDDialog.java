package com.example.adminclient;

import com.example.demowildfly.CD;

import javax.swing.*;
import java.awt.*;

public class CDDialog extends JDialog {

    private JTextField txtTitre;
    private JCheckBox chkDisponible;
    private boolean okPressed = false;

    public CDDialog(Frame owner, CD cd) {
        super(owner, "Édition du CD", true);

        txtTitre = new JTextField(cd.getTitre(), 20);
        chkDisponible = new JCheckBox("Disponible", cd.isDisponible());

        JButton btnOk = new JButton("OK");
        JButton btnAnnuler = new JButton("Annuler");

        btnOk.addActionListener(e -> {
            cd.setTitre(txtTitre.getText());
            cd.setDisponible(chkDisponible.isSelected());
            okPressed = true;
            dispose();
        });

        btnAnnuler.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Titre :"));
        panel.add(txtTitre);
        panel.add(new JLabel("Disponible :"));
        panel.add(chkDisponible);

        JPanel panelBoutons = new JPanel();
        panelBoutons.add(btnOk);
        panelBoutons.add(btnAnnuler);

        add(panel, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
        setVisible(true);
    }

    public boolean isOkPressed() {
        return okPressed;
    }
}
