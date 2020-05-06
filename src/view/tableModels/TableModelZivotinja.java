/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModels;

import domain.Zivotinja;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anakl
 */
public class TableModelZivotinja extends AbstractTableModel {

    private List<Zivotinja> zivotinje;
    String[] columnNames = new String[]{"Ime", "Vrsta", "Rasa", "Pol", "Datum rođenja", "Boja"};

    public TableModelZivotinja(List<Zivotinja> zivotinje) {
        this.zivotinje = zivotinje;
    }

    @Override
    public int getRowCount() {
        return zivotinje.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zivotinja z = zivotinje.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return z.getIme();
            case 1:
                return z.getVrsta();
            case 2:
                return z.getRasa();
            case 3:
                return z.getPol();
            case 4:
                return new SimpleDateFormat("dd.MM.yyyy").format(z.getDatumRodjenja().getTime());
            case 5:
                return z.getBoja();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void azuriraj(List<Zivotinja> zivotinje) {
        this.zivotinje = zivotinje;
        fireTableDataChanged();
    }

    public Zivotinja getPet(int clickedRow) {
        return zivotinje.get(clickedRow);
    }

}
