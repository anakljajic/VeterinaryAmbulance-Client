/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModels;

import domain.Radnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anakl
 */
public class TableModelRadnik extends AbstractTableModel {

    private List<Radnik> radnici;
    String[] columnNames = new String[]{"Ime", "Prezime", "Datum rodjenja", "Adresa", "Telefon", "Korisnicko ime", "Lozinka", "Admin"};

    public TableModelRadnik(List<Radnik> radnici) {
        this.radnici = radnici;
    }

    @Override
    public int getRowCount() {
        return radnici.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Radnik r = radnici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIme();
            case 1:
                return r.getPrezime();
            case 2:
                return r.getDatumRodjenja();
            case 3:
                return r.getAdresa();
            case 4:
                return r.getTelefon();
            case 5:
                return r.getKorisnikoIme();
            case 6:
                return r.getLozinka();
            case 7:
                return r.isAdministrator();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void azuriraj(List<Radnik> radnici) {
        this.radnici = radnici;
        fireTableDataChanged();
    }

    public Radnik getWorker(int index) {
        return radnici.get(index);
    }
}
