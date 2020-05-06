/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModels;

import domain.Racun;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anakl
 */
public class TableModelRacun extends AbstractTableModel {

    private List<Racun> racuni;
    String[] columnNames = new String[]{"Šifra računa", "Šifra kartona", "Klijent", "Ljubimac", "Datum kreiranja", "Radnik", "Ukupna cena bez PDV-a", "PDV", "Ukupna cena sa PDV-om", "Obrađen", "Storniran"};

    public TableModelRacun(List<Racun> racuni) {
        this.racuni = racuni;
    }

    @Override
    public int getRowCount() {
        return racuni.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun r = racuni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getRacunID();
            case 1:
                return r.getKarton().getKartonID();
            case 2:
                return r.getKarton().getZivotinja().getKlijent().toString();
            case 3:
                return r.getKarton().getZivotinja().getIme();
            case 4:
                return new SimpleDateFormat("dd.MM.yyyy").format(r.getDatumKreiranja().getTime());
            case 5:
                return r.getRadnik().toString();
            case 6:
                return r.getUkupnaCenaBezPoreza();
            case 7:
                return r.getPorez();
            case 8:
                return r.getUkupnaCenaSaPorezom();
            case 9:
                return r.isObradjen();
            case 10:
                return r.isStorniran();
            default:
                return "n/a";

        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void azuriraj(List<Racun> racuni) {
        this.racuni = racuni;
        fireTableDataChanged();
    }

    public Racun getBill(int index) {
        return racuni.get(index);
    }

}
