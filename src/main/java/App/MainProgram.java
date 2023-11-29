package App;

import javax.swing.*;

import DatabaseTasks.DatabaseConnection;
import Enums.MetadataType;
import Model.Metadata;
import Model.MetadataManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainProgram {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField ipField;
    private JTextField tableNameField;
    private final Map<MetadataType, JCheckBox> checkboxMap = new HashMap<>();


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Metadata Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainProgram metadataFacade = new MainProgram();
        JPanel panel = metadataFacade.createPanel();

        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createPanel() {
        //JPanel panel = new JPanel(new GridLayout(5, 2));
    	JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        usernameField = new JTextField("root");
        passwordField = new JPasswordField("123456");
        ipField = new JTextField("localhost:3306");
        tableNameField = new JTextField("countries");
        
        for (MetadataType type : MetadataType.values()) {
            JCheckBox checkBox = new JCheckBox(type.getDisplayName());
            checkboxMap.put(type, checkBox);
            mainPanel.add(checkBox);
        }

        JButton fetchMetadataButton = new JButton("Fetch Metadata");

        fetchMetadataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                try {
                	System.out.print("yeah!!!!");
					displayMetadataResults();					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
        
        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
        
        inputPanel.add(new JLabel("Server's IP Address:"));
        inputPanel.add(ipField);

        inputPanel.add(new JLabel("Database Username:"));
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);

        inputPanel.add(new JLabel("Desired Table Name:"));
        inputPanel.add(tableNameField);

        mainPanel.add(inputPanel);

        mainPanel.add(fetchMetadataButton);        
        mainPanel.add(exitButton);
        
        return mainPanel;
    }
    
    private void displayMetadataResults() throws SQLException {
    	String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        String ip = ipField.getText();
        String tableName = tableNameField.getText();
        System.out.println("username :" +username+",password :"+password+", ip :"+ip);
        Connection connection = DatabaseConnection.connect(ip, username, password);
        MetadataManager metaManager = new MetadataManager();        
        ArrayList<MetadataType> tableTypes =  new ArrayList<MetadataType>();
        for (Map.Entry<MetadataType, JCheckBox> entry : checkboxMap.entrySet()) {
            MetadataType type = entry.getKey();
            JCheckBox checkBox = entry.getValue();
            if (checkBox.isSelected()) {
            	System.out.println(type.toString());
                tableTypes.add(type);
            }
        }
        metaManager.createMetadata(tableTypes, tableName, connection);
        for(Metadata metadata : metaManager.getMetadataList()) {
        	System.out.println(metadata.getTableName());
        	getMetadataText(metadata);
        	showMetadataDialog(metadata);
        }
        
        DatabaseConnection.closeConnection();    
    }

    private void showMetadataDialog(Metadata metadata) throws SQLException {
        JFrame dialogFrame = new JFrame("Metadata Results");
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea(getMetadataText(metadata));
        JScrollPane scrollPane = new JScrollPane(textArea);

        dialogFrame.getContentPane().add(scrollPane);

        dialogFrame.setSize(600, 400);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setVisible(true);
    }

    private String getMetadataText(Metadata metadata) {
        return "Table Name: " + metadata.getTableName() + "\n"
		        + metadata.getAllMetadata();
    }
}