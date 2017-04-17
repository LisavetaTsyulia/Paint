package paintStyles;

import interfaces.Editable;
import paintField.ShapesList;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
                if (ShapesList.getInstance().getSelectedShape() != null &&
                        ShapesList.getInstance().getSelectedShape() instanceof Editable) {
                    Color fill;
                    Color border;
                    if ( str.equals("Border")) {
                        border = getSelectedColor();
                        ((Editable) ShapesList.getInstance().getSelectedShape()).update(null, border);
                    } else {
                        fill = getSelectedColor();
                        ((Editable) ShapesList.getInstance().getSelectedShape()).update(fill, null);
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
