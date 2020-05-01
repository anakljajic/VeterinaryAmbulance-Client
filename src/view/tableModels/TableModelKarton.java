/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModels;

import domain.Karton;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anakl
 */
public class TableModelKarton extends AbstractTableModel {

    private List<Karton> kartoni;
    String[] columnNames = new String[]{"Klijent", "Zivotinja", "Vrsta", "Rasa", "Napomena", "Datum kreiranja"};

    public TableModelKarton(List<Karton> kartoni) {
        this.kartoni = kartoni;
    }

    @Override
    public int getRowCount() {
        return kartoni.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Karton k = kartoni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getZivotinja().getKlijent().getIme() + " " + k.getZivotinja().getKlijent().getPrezime();
            case 1:
                return k.getZivotinja().getIme();
            case 2:
                return k.getZivotinja().getVrsta();
            case 3:
                return k.getZivotinja().getRasa();
            case 4:
                return k.getNapomena();
            case 5:
                return new SimpleDateFormat("dd.MM.yyyy").format(k.getDatumKreiranja().getTime());
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void azuriraj(List<Karton> kartoni) {
        this.kartoni = kartoni;
        fireTableDataChanged();
    }

    public Karton getMedicalRecord(int index) {
        return kartoni.get(index);
    }

}
