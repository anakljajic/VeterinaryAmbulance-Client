/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import view.main.FrmLoginClient;

/**
 *
 * @author anakl
 */
public class ProgressThread extends Thread {

    private JProgressBar progressBar;
    private JFrame frame;
    private JLabel valueProgress;
    private int value;
    private int i;
//    private boolean signal = true;

    public ProgressThread(JProgressBar progressBar, JFrame frame, JLabel valueProgress) {
        this.progressBar = progressBar;
        this.frame = frame;
        this.valueProgress = valueProgress;
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
                    valueProgress.setText(Integer.toString(i) + "%");
                    progressBar.setValue(i);
                } else if (i > 70) {
                    valueProgress.setText(Integer.toString(i) + "%");
                    progressBar.setValue(i);
                } else if (i > 90 && i < 100) {
                    i = 100;
                    valueProgress.setText(Integer.toString(i) + "%");
                    progressBar.setValue(i);
                } else {
                    valueProgress.setText(Integer.toString(i) + "%");
                    progressBar.setValue(i);
                }

                progressBar.setValue(i + 14);

                Thread.sleep(900);
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
