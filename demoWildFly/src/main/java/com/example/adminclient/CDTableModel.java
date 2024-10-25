package com.example.adminclient;

import com.example.demowildfly.CD;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CDTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Titre", "Disponible"};
    private final List<CD> cds;

    public CDTableModel(List<CD> cds) {
        this.cds = cds;
    }

    @Override
    public int getRowCount() {
        return cds.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public CD getCDAt(int rowIndex) {
        return cds.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CD cd = cds.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cd.getId();
            case 1:
                return cd.getTitre();
            case 2:
                return cd.isDisponible() ? "Oui" : "Non";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
