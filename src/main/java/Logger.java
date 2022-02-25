import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Logger {
    static FileWriter writer;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("[dd.MM.yyyy hh:mm:ss]");

    Logger(String fileName) {
        try {
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String text) {
        try {
            writer.write(simpleDateFormat.format(System.currentTimeMillis())+ " " + text+"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void log() {
        try {
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
