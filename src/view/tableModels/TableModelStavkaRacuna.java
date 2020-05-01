/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModels;

import domain.StavkaRacuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anakl
 */
public class TableModelStavkaRacuna extends AbstractTableModel {

    private List<StavkaRacuna> stavkeRacuna;
    String[] columnNames = new String[]{"RB", "Naziv predmeta prodaje", "Kolicina", "Cena bez poreza", "Cena sa porezom", "Porez", "Ukupna cena bez poreza", "Ukupna cena sa porezom"};

    public TableModelStavkaRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    @Override
    public int getRowCount() {
        return stavkeRacuna.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna s = stavkeRacuna.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getStavkaRacunaID();
            case 1:
                return s.getPredmetProdaje().getNaziv();
            case 2:
                return s.getKolicina();
            case 3:
                return s.getCenaPoJediniciBezPoreza();
            case 4:
                return s.getCenaPoJediniciSaPorezom();
            case 5:
                return s.getPredmetProdaje().getPoreskaStopa().getVrednost();
            case 6:
                return s.getUkupnaCenaBezPoreza();
            case 7:
                return s.getUkupnaCenaSaPorezom();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void azuriraj(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
        fireTableDataChanged();
    }

    public StavkaRacuna getItemOfBill(int index) {
        return stavkeRacuna.get(index);
    }

}
