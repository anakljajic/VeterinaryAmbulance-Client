/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModels;

import domain.PredmetProdaje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anakl
 */
public class TableModelPredmetProdaje extends AbstractTableModel {

    private List<PredmetProdaje> predmeti;
    String[] columnNames = new String[]{"Naziv", "Cena bez poreza", "Cena sa porezom", "Porez"};

    public TableModelPredmetProdaje(List<PredmetProdaje> predmeti) {
        this.predmeti = predmeti;
    }

    @Override
    public int getRowCount() {
        return predmeti.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PredmetProdaje p = predmeti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getNaziv();
            case 1:
                return p.getCenaBezPoreza();
            case 2:
                return p.getCenaSaPorezom();
            case 3:
                return p.getPoreskaStopa().getVrednost();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void azuriraj(List<PredmetProdaje> predmeti) {
        this.predmeti = predmeti;
        fireTableDataChanged();
    }

    public PredmetProdaje getObjectOfSale(int index) {
        return predmeti.get(index);
    }

}
