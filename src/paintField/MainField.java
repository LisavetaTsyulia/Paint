package paintField;

import fabrica.Fabrica;
import fabrica.FabricaList;
import loader.ModuleLoader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class MainField {
    private JFrame frm;
    private MenuPan menuPan;
    private PaintPan paintPan;
    private List<Class<?>> fabricaClasses;

    public static void main(String[] a) {
        MainField app = new MainField();
        app.loadFactories();
        app.go();
    }

    private List<Class<?>> loadClasses(Class<?> type, String path) {
        List<Class<?>> result = new ArrayList<>();
        ModuleLoader loader = new ModuleLoader(path, ClassLoader.getSystemClassLoader());
        File dir = new File(path);
        String[] classes = dir.list();
        if (classes != null) {
            for (String clazzName : classes) {
                try {
                    String shapeName = clazzName.split(".class")[0];
                    Class<?> clazz = loader.loadClass(shapeName);
                    if (type.isAssignableFrom(clazz)) {
                        result.add(clazz);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private void loadFactories() {
        fabricaClasses = loadClasses(Fabrica.class, "fabricas/");
    }

    public void go() {
        frm = new JFrame();
        menuPan = new MenuPan(fabricaClasses);
        paintPan = new PaintPan();
        menuPan.setMenu(paintPan);
        menuPan.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        MyMouseListener myListener = new MyMouseListener(paintPan.coords, paintPan);
        paintPan.addMouseListener(myListener);
        paintPan.addMouseMotionListener(myListener);

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
        frm.setSize(800, 400);
        frm.setVisible(true);
    }
}
