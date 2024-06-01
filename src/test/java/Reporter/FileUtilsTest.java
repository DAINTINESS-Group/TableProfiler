package Reporter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import Reporter.Reporter;

public class FileUtilsTest {

    @Test
    public void testWriteToFile() {
        String metadata = "Test metadata";
        String filePath = "test.txt";

        Reporter.writeToFile( filePath);

        // Now let's try to read the file and check if the content matches the metadata
        try {
            String fileContent = readFile(filePath);
            assertEquals(metadata, fileContent);
        } catch (IOException e) {
            fail("Failed to read the file: " + e.getMessage());
        }
    }

    // This is a helper method to read the content of a file
    private String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}