package paintField;

import fabrica.*;
import paintStyles.ColorChooserButton;
import paintStyles.CustomizedButtonUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class MenuPan extends JPanel{
    private JPanel box;
    private Color borderColor = new Color(0x310683);
    private Color fillColor = new Color(0x1B832A);
    private ColorChooserButton borderBtn;
    private ColorChooserButton fill;
    private PaintPan paintPan;
    private List<Class <?>> fabricaClasses;
    public ArrayList<JButton> buttons;

    public MenuPan(List<Class<?>> fabricaClasses) {
        this.fabricaClasses = fabricaClasses;
    }

    public ColorChooserButton getBorderBtn() {
        return borderBtn;
    }

    public ColorChooserButton getFill() {
        return fill;
    }

    public void setMenu(PaintPan pan){
        paintPan = pan;
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        borderBtn = new ColorChooserButton(borderColor, "Border");
        fill = new ColorChooserButton(fillColor, "Fill");

        JButton clear = new JButton("Clear");
        clear.addActionListener(new BtnClearActionListener());
        buttons = new ArrayList<>();
        for (Class<?> factoryClass:
             fabricaClasses) {
            String shapeName = factoryClass.getName();
            JButton btn = new JButton(shapeName);
            try {
                Fabrica factory = (Fabrica) factoryClass.newInstance();
                FabricaList.getInstance().addFabrica(factory);
                System.out.println(factory.getName());
            }catch (Exception e) { }
            btn.addActionListener(e -> {
                if ( !paintPan.isEmptyCoords() ) {
                    borderColor = borderBtn.getSelectedColor();
                    fillColor = fill.getSelectedColor();
                    try {
                        Fabrica factory = (Fabrica) factoryClass.newInstance();
                        ShapesList.getInstance().addShape(factory, borderColor, fillColor, paintPan.coords);
                        paintPan.clearCoords();
                    } catch (InstantiationException e1) {
                        e1.printStackTrace();
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            buttons.add(btn);
        }
        buttons.add(borderBtn);
        buttons.add(fill);
        buttons.add(clear);
        Color bg = new Color(68, 120, 182);
        Color pr = new Color(59, 89, 220);
        box = new JPanel(new GridLayout(9, 1));
        for (JButton b : buttons) {
            b.setUI(new CustomizedButtonUI(bg, bg, pr));
            box.add(b);
        }
        this.add(box);
    }

    class BtnClearActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clear the screen");
            ShapesList.getInstance().clearList();
            paintPan.coords.clear();
        }
    }
}
