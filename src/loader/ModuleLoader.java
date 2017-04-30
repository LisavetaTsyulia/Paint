package loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ModuleLoader extends ClassLoader {
    private String pathtobin;

    public ModuleLoader(String pathtobin, ClassLoader parent) {
        super(parent);
        this.pathtobin = pathtobin;
    }

    @Override
    public Class<?> loadClass(String fileName) throws ClassNotFoundException {
        try {
            byte b[] = fetchClassFromFS(pathtobin + fileName + ".class");
            return defineClass(fileName, b, 0, b.length);
        } catch (IOException e) {
            return super.loadClass(fileName);
        }

    }

    private byte[] fetchClassFromFS(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }
}
