/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import view.main.FrmLoginClient;

/**
 *
 * @author anakl
 */
public class ProgressThread extends Thread {

    private JProgressBar progressBar;
    private JFrame frame;
    private int value;
    private int i;
//    private boolean signal = true;

    public ProgressThread(JProgressBar progressBar, JFrame frame) {
        this.progressBar = progressBar;
        this.frame = frame;
    }

    @Override
    public void run() {
//        while (signal) {
//            try {
//                value = new Random().nextInt(100);
//                progressBar.setValue(value);
//                sleep(100);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
        while (i <= 100) {
            try {
                // set text accoring to the level to which the bar is filled
                if (i > 30 && i < 70) {
                    progressBar.setString("wait a bit");
                } else if (i > 70) {
                    progressBar.setString("almost finished loading");
                } else {
                    progressBar.setString("loading started");

                }

                // fill the menu bar
                progressBar.setValue(i + 10);

                // delay the thread
                Thread.sleep(1500);
                i += 20;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        frame.dispose();
        FrmLoginClient frm = new FrmLoginClient();
        frm.setVisible(true);
    }
}
