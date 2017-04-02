package fabrica;

import java.util.ArrayList;

/**
 * Created by lisa on 2.4.17.
 */
public class FabricaList {
    private static FabricaList ourInstance = new FabricaList();

    ArrayList<Fabrica> fabricaList = new ArrayList<>();
    public static FabricaList getInstance() {
        return ourInstance;
    }

    private FabricaList() {
        fabricaList.add(new FabricaCircle());
        fabricaList.add(new FabricaRectangle());
        fabricaList.add(new FabricaLine());
        fabricaList.add(new FabricaOval());
        fabricaList.add(new FabricaPolygon());
        fabricaList.add(new FabricaSquare());
    }

    public Fabrica chooseFabrica(String name) {
        for (Fabrica fabrica:
             fabricaList) {
            if (fabrica.getName().equals(name)) {
                return fabrica;
            }
        }
        return null;
    }
}
