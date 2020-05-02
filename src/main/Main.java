/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.main.FrmLoginClient;
import view.main.FrmProgressOpen;

/**
 *
 * @author student1
 */
public class Main {

    public static void main(String[] args) {
        FrmProgressOpen frm = new FrmProgressOpen();
//        FrmLoginClient frm = new FrmLoginClient();
//        Radnik radnik = new Radnik();
//        FrmMainWork frm = new FrmMainWork(radnik);
        frm.setVisible(true);
    }
}
