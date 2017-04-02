package paintField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

/**
 * Created by lisa on 1.4.17.
 */
public class SerializeActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FileWriter writer = new FileWriter("Foo.txt");
            ShapesList.getInstance().serializeList(writer);
            writer.close();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
