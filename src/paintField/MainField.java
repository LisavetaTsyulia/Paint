package paintField;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
/**
 * Created by lisa on 11.3.17.
 */
public class MainField {
    JFrame frm;
    MenuPan menuPan;
    PaintPan paintPan;

    public static void main(String[] a) {
        MainField app = new MainField();
        app.go();
    }
    public void go(){
        frm = new JFrame();
        menuPan = new MenuPan();
        paintPan = new PaintPan();
        menuPan.setMenu();
        menuPan.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));


        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().add(BorderLayout.WEST, menuPan);
        frm.getContentPane().add(BorderLayout.CENTER, paintPan);
        frm.pack();
        frm.setSize(800,400);
        frm.setVisible(true);
    }
}
