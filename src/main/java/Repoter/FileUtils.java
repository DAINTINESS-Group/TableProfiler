package Repoter;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	public static void writeToFile(String metadata, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(metadata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
