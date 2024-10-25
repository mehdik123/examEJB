package com.example.adminclient;

import com.example.demowildfly.Emprunt;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmpruntTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Titre CD", "Utilisateur", "Date d'emprunt"};
    private final List<Emprunt> emprunts;

    public EmpruntTableModel(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public int getRowCount() {
        return emprunts.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public Emprunt getEmpruntAt(int rowIndex) {
        return emprunts.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emprunt emprunt = emprunts.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return emprunt.getId();
            case 1:
                return emprunt.getCd().getTitre();
            case 2:
                return emprunt.getUtilisateur();
            case 3:
                return emprunt.getDateEmprunt();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
