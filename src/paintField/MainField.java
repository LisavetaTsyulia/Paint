package paintField;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        menuPan.setMenu(paintPan);
        menuPan.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        paintPan.addMouseListener(new MyMouseListener(paintPan.coords));

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("functions");
        JMenuItem serialize = new JMenuItem("save");
        serialize.addActionListener(new SerializeActionListener());
        menu.add(serialize);
        JMenuItem open = new JMenuItem("open");
        menu.add(open);
        open.addActionListener(new OpenActionListener());
        JMenuItem select = new JMenuItem("select shape");
        menu.add(select);
        select.addActionListener(new SelectActionListener(menuPan, paintPan.coords));
        JMenuItem backToPaint = new JMenuItem("back to paint");
        menu.add(backToPaint);
        backToPaint.addActionListener(new BackToPaintListener(menuPan, paintPan.coords));
        menubar.add(menu);
        frm.setJMenuBar(menubar);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().add(BorderLayout.WEST, menuPan);
        frm.getContentPane().add(BorderLayout.CENTER, paintPan);
        frm.pack();
        frm.setSize(800,400);
        frm.setVisible(true);
    }
}
