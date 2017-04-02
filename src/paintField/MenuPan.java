package paintField;

import fabrica.*;
import paintStyles.ColorChooserButton;
import paintStyles.CustomizedButtonUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by lisa on 11.3.17.
 */
public class MenuPan extends JPanel{
    private JPanel box;
    private Color borderColor = new Color(0x310683);
    private Color fillColor = new Color(0x1B832A);
    private ColorChooserButton border;
    private ColorChooserButton fill;
    private PaintPan paintPan;
    Fabrica fabrica;

    public void setMenu(PaintPan pan){
        paintPan = pan;
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //shapes
        JButton square = new JButton("Square");
        square.addActionListener(new BtnSquareActionListener());
        //System.out.println("/images/square.png");
        square.setIcon(new ImageIcon("/images/square.png"));


        JButton circle = new JButton("Circle");
        circle.addActionListener(new BtnCircleActionListener());
        JButton line = new JButton("Line");
        line.addActionListener(new BtnLineActionListener());
        JButton polygon = new JButton("Polygon");
        polygon.addActionListener(new BtnPolygonActionListener());
        JButton oval = new JButton("Oval");
        oval.addActionListener(new BtnOvalActionListener());
        JButton rectangle = new JButton("Rectangle");
        rectangle.addActionListener(new BtnRectangleActionListener());


        //JButton border = new JButton("Border");
        border = new ColorChooserButton(borderColor, "Border");
        fill = new ColorChooserButton(fillColor, "Fill");

        JButton clear = new JButton("Clear");
        clear.addActionListener(new BtnClearActionListener());

        //look
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(border);
        buttons.add(fill);
        buttons.add(circle);
        buttons.add(line);
        buttons.add(polygon);
        buttons.add(square);
        buttons.add(oval);
        buttons.add(rectangle);
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

    class BtnSquareActionListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if ( !paintPan.isEmptyCoords() ) {
                System.out.println(paintPan.coords);
                borderColor = border.getSelectedColor();
                fillColor = fill.getSelectedColor();
                System.out.println("Square listener");
                fabrica = new FabricaSquare();
                ShapesList.getInstance().addShape(fabrica, borderColor, fillColor, paintPan.coords);
                paintPan.clearCoords();
            }
        }
    }
    class BtnCircleActionListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if ( !paintPan.isEmptyCoords() ) {
                borderColor = border.getSelectedColor();
                fillColor = fill.getSelectedColor();
                System.out.println("Circle listener");
                fabrica = new FabricaCircle();
                ShapesList.getInstance().addShape(fabrica, borderColor, fillColor, paintPan.coords);
                paintPan.clearCoords();
            }
        }
    }
    class BtnLineActionListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if ( !paintPan.isEmptyCoords() ) {
                borderColor = border.getSelectedColor();
                fillColor = fill.getSelectedColor();
                System.out.println("Line listener");
                fabrica = new FabricaLine();
                ShapesList.getInstance().addShape(fabrica, borderColor, fillColor, paintPan.coords);
                paintPan.clearCoords();
            }
        }
    }
    class BtnPolygonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if ( !paintPan.isEmptyCoords() ) {
                borderColor = border.getSelectedColor();
                fillColor = fill.getSelectedColor();
                System.out.println("Polygon listener");
                fabrica = new FabricaPolygon();
                ShapesList.getInstance().addShape(fabrica, borderColor, fillColor, paintPan.coords);
                paintPan.clearCoords();
            }
        }
    }
    class BtnOvalActionListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if ( !paintPan.isEmptyCoords() ) {
                borderColor = border.getSelectedColor();
                fillColor = fill.getSelectedColor();
                System.out.println("Oval listener");
                fabrica = new FabricaOval();
                ShapesList.getInstance().addShape(fabrica, borderColor, fillColor, paintPan.coords);
                paintPan.clearCoords();
            }
        }
    }
    class BtnRectangleActionListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if ( !paintPan.isEmptyCoords() ) {
                borderColor = border.getSelectedColor();
                fillColor = fill.getSelectedColor();
                System.out.println("Rectangle listener");
                fabrica = new FabricaRectangle();
                ShapesList.getInstance().addShape(fabrica, borderColor, fillColor, paintPan.coords);
                paintPan.clearCoords();
            }
        }
    }

    class BtnClearActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clear the screen");
            ShapesList.getInstance().clearList();
        }
    }

}
