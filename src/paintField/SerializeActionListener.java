package paintField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class SerializeActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                FileWriter writer = new FileWriter(file);
                ShapesList.getInstance().serializeList(writer);
                writer.close();
            }
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
