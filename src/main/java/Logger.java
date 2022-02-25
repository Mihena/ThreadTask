import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    static FileWriter writer;
    Logger(String fileName) {
        try {
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String text) {
        try {
            writer.write(text+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
