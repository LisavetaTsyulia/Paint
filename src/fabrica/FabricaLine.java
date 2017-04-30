package fabrica;

import paintShapes.*;

public class FabricaLine extends Fabrica {

    public FabricaLine(){
        setName("Line");
    }
    public Shape createShape() {
        return new Line();
    }

    @Override
    public String getName() {
        return fabricaName;
    }

    @Override
    public void setName(String name) {
        fabricaName = name;
    }
}
