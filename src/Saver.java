import java.io.*;

public class Saver {
    @AnnotationForMethod
    public static void save(String text, String fileName) {
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text);
        }
        catch(IOException ex) {
        }
    }
}
