/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModels;

import domain.Klijent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anakl
 */
public class TableModelKlijent extends AbstractTableModel {

    private List<Klijent> klijenti;
    String[] columnNames = new String[]{"Ime", "Prezime", "Datum rođenja", "Adresa", "Mesto", "Telefon"};

    public TableModelKlijent(List<Klijent> klijenti) {
        this.klijenti = klijenti;
    }

    @Override
    public int getRowCount() {
        return klijenti.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = klijenti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIme();
            case 1:
                return k.getPrezime();
            case 2:
                return new SimpleDateFormat("dd.MM.yyyy").format(k.getDatumRodjenja().getTime());
            case 3:
                return k.getAdresa();
            case 4:
                return k.getMesto();
            case 5:
                return k.getTelefon();
            default:
                return "n/a";
        }
    }

    public void azuriraj(List<Klijent> klijenti) {
        this.klijenti = klijenti;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Klijent getClient(int index) {
        return klijenti.get(index);
    }

}
