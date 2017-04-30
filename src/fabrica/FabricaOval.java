package fabrica;

import paintShapes.Oval;
import paintShapes.Shape;

public class FabricaOval extends Fabrica {
    public FabricaOval(){
        setName("Oval");
    }
    public Shape createShape() {
        return new Oval();
    }

    @Override
    public String getName() {
        return "Oval";
    }

    @Override
    public void setName(String name) {
        fabricaName = name;
    }
}
