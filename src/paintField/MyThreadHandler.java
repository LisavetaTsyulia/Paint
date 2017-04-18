package paintField;

public class MyThreadHandler extends Thread {
    private PaintPan paintPan;
    public MyThreadHandler(PaintPan paintPan) {
        this.paintPan = paintPan;
    }

    @Override
    public void run() {
        while (true) {
            if (ShapesList.getInstance().status.equals("changed")) {
                paintPan.paint(paintPan.getGraphics());
            }
        }
    }
}
