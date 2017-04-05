package paintStyles;

/**
 * Created by lisa on 11.3.17.
 */
import paintField.ShapesList;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ColorChooserButton extends JButton {

    private Color current;

    public ColorChooserButton(Color c, String str) {
        setSelectedColor(c);
        setText(str);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", current);
                setSelectedColor(newColor);
                if (ShapesList.getInstance().getSelectedShape() != null ) {
                    if ( str.equals("Border")) {
                        ShapesList.getInstance().getSelectedShape().setBorderCol(getSelectedColor());
                    } else {
                        ShapesList.getInstance().getSelectedShape().setFillCol(getSelectedColor());
                    }
                }
            }
        });
    }

    public Color getSelectedColor() {
        return current;
    }

    public void setSelectedColor(Color newColor) {
        setSelectedColor(newColor, true);
    }

    public void setSelectedColor(Color newColor, boolean notify) {

        if (newColor == null) return;

        current = newColor;
        repaint();

        if (notify) {
            // Notify everybody that may be interested.
            for (ColorChangedListener l : listeners) {
                l.colorChanged(newColor);
            }
        }
    }

    public static interface ColorChangedListener {
        public void colorChanged(Color newColor);
    }

    private List<ColorChangedListener> listeners = new ArrayList<ColorChangedListener>();

    public void addColorChangedListener(ColorChangedListener toAdd) {
        listeners.add(toAdd);
    }

}
