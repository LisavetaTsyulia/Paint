package paintField;

import fabrica.FabricaList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class OpenActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ShapesList.getInstance().clearList();
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(file);
                 InputStreamReader isr = new InputStreamReader(fis);
                 BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    DeserializedObject someShape = parseLine(line);
                    ShapesList.getInstance().addShape(someShape.getFabrica(), someShape.getBorderColor(),
                            someShape.getFillColor(), someShape.getCoords());
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    private DeserializedObject parseLine(String line) {
        String[] parts = line.split("/");
        String name = parts[0];
        String coords = parts[1];
        String fillColor = parts[2];
        String borderColor = parts[3];

        DeserializedObject someShape = new DeserializedObject();
        someShape.setName( name );
        System.out.println(name);
        String[] borderColorArray = borderColor.split("\\.");
        int borderRed = Integer.parseInt(borderColorArray[0]);
        int borderGreen = Integer.parseInt(borderColorArray[1]);
        int borderBlue = Integer.parseInt(borderColorArray[2]);
        someShape.setBorderColor(new Color(borderRed, borderGreen, borderBlue));

        String[] fillColorArray = fillColor.split("\\.");
        int fillRed = Integer.parseInt(fillColorArray[0]);
        int fillGreen = Integer.parseInt(fillColorArray[1]);
        int fillBlue = Integer.parseInt(fillColorArray[2]);
        someShape.setFillColor(new Color(fillRed, fillGreen, fillBlue));

        String[] stringCoords = coords.split(";");
        ArrayList<Point> coordsArray = new ArrayList<Point>();
        for (String pt :
             stringCoords) {
            if (!pt.equals("")) {
                String[] xy = pt.split(",");
                coordsArray.add(new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
            }
        }
        someShape.setCoords(coordsArray);
        someShape.setFabrica(FabricaList.getInstance().chooseFabrica(someShape.getName()));

        return someShape;
    }
}
