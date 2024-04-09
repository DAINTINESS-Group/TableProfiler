package DatabaseTasks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateDDLScript {

    public static void main(String[] args) {
        String ddlScript = generateDDLScript();

        try (FileWriter writer = new FileWriter("ddl_script.txt")) {
            writer.write(ddlScript);
            System.out.println("DDL script saved to ddl_script.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String generateDDLScript() {
        StringBuilder ddlScript = new StringBuilder();
        Random random = new Random();

        for (int i = 1; i <= 1000; i++) {
            ddlScript.append("CREATE TABLE table_").append(i).append(" (\n");
            ddlScript.append("    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n");

            if (i > 1) {
                ddlScript.append("    column_table_").append(i - 1).append("_id INT,\n");
                ddlScript.append("    FOREIGN KEY (column_table_").append(i - 1).append("_id) REFERENCES table_")
                        .append(i - 1).append("(id),\n");
            }

            for (int j = 2; j <= 100; j++) {
                String columnName = "column_" + j;
                String columnType = getRandomColumnType(random);
                ddlScript.append("    ").append(columnName).append(" ").append(columnType).append(",\n");
            }

            ddlScript.deleteCharAt(ddlScript.length() - 2); // Remove trailing comma and newline
            ddlScript.append("\n);\n\n");

            // Create index on id column
            ddlScript.append("CREATE INDEX idx_id_table_").append(i).append(" ON table_").append(i).append("(id);\n\n");
        }

        return ddlScript.toString();
    }

    private static String getRandomColumnType(Random random) {
        int randomNumber = random.nextInt(6); // Assuming there are 6 random data types
        switch (randomNumber) {
            case 0:
                return "VARCHAR(255)";
            case 1:
                return "INT";
            case 2:
                return "FLOAT";
            case 3:
                return "DATE";
            case 4:
                return "TINYINT";
            case 5:
                return "DECIMAL(10, 2)"; // Example: DECIMAL with precision 10 and scale 2
            default:
                return "VARCHAR(255)"; // Default to VARCHAR(255) if none match
        }
    }
}