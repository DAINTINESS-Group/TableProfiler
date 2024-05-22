package App;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Enums.MetadataType;
import Model.MetadataManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class MainApp extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField ipField;
    private JTextField tableNameField;
    private JTextField schemaNameField;
    private final Map<MetadataType, JCheckBox> checkboxMap = new HashMap<>();
    MetadataManager metaManager;

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainApp frame = new MainApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 420); // Set frame size
        contentPane = new JPanel(new GridLayout(2, 2)); 
        setContentPane(contentPane);

        JPanel inputPanel = createInputPanel();
        contentPane.add(inputPanel);

//        JPanel filePanel = createFilePanel();
//        contentPane.add(filePanel);
        
        JPanel checkboxPanel = createCheckboxPanel();
        contentPane.add(checkboxPanel);

        JPanel containerPanel = new JPanel(new BorderLayout()); // Container panel with BorderLayout
        JPanel buttonPanel = createButtonPanel();
        containerPanel.add(buttonPanel, BorderLayout.SOUTH); // Add button panel to the bottom of container panel

        addPanel(containerPanel, 1, 1, GridBagConstraints.SOUTH);
        
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(new TitledBorder(null, "Connection Credentials", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        usernameField = new JTextField("reportUser", 20);
        passwordField = new JPasswordField("123456", 20);
        ipField = new JTextField("localhost:3306", 20);
        tableNameField = new JTextField("ALL", 20);
        schemaNameField = new JTextField("adventureworks", 20);
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Increased gap between rows and columns

        inputPanel.add(new JLabel("Server's IP Address:"));
        inputPanel.add(ipField);

        inputPanel.add(new JLabel("Database Username:"));
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);

        inputPanel.add(new JLabel("Desired Table Name:"));
        inputPanel.add(tableNameField);

        inputPanel.add(new JLabel("Schema Name:"));
        inputPanel.add(schemaNameField);

        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton fetchMetadataButton = new JButton("Fetch Metadata");
        fetchMetadataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    displayMetadataResults();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JButton copyButton = new JButton("Copy");        
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (metaManager == null) {
                    JOptionPane.showMessageDialog(null, "Please fetch the metadata first.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method early
                }
                
                String metadataString = metaManager.toString();
                if (metadataString == null) {
                    JOptionPane.showMessageDialog(null, "Metadata is null. Please fetch the metadata first.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method early
                }

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save Metadata");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
                fileChooser.setFileFilter(filter);

                int userSelection = fileChooser.showSaveDialog(MainApp.this);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    String filePath = fileToSave.getAbsolutePath();

                    metaManager.writeToFile(metadataString, filePath);
					JOptionPane.showMessageDialog(null, "Metadata copied to file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        buttonPanel.add(fetchMetadataButton);
        buttonPanel.add(copyButton);
        buttonPanel.add(exitButton);
        
        return buttonPanel;
    }

    private JPanel createCheckboxPanel() {
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setBorder(new TitledBorder(null, "Metadata Types", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        checkboxPanel.setLayout(new GridLayout(0, 1));

        for (MetadataType type : MetadataType.values()) {
            JCheckBox checkBox = new JCheckBox(type.getDisplayName());
            checkboxMap.put(type, checkBox);
            checkboxPanel.add(checkBox);
        }

        return checkboxPanel;
    }


    private void displayMetadataResults() throws SQLException {
        // Retrieve credentials from fields
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        String ip = ipField.getText();
        String tableName = tableNameField.getText();
        String schemaName = schemaNameField.getText();

        metaManager = new MetadataManager();

        // Create a list of selected metadata types
        ArrayList<MetadataType> tableTypes =  new ArrayList<MetadataType>();
        for (Map.Entry<MetadataType, JCheckBox> entry : checkboxMap.entrySet()) {
            MetadataType type = entry.getKey();
            JCheckBox checkBox = entry.getValue();
            if (checkBox.isSelected()) {
                tableTypes.add(type);
            }
        }

        // Create metadata
        metaManager.createMetadata(ip, schemaName, username, password, tableTypes, schemaName, tableName);

        // Show metadata dialog
        showMetadataDialog();
        // Print metadata tables
        //metaManager.printMetadatalistTables();
    }

    private void showMetadataDialog() throws SQLException {
        JFrame dialogFrame = new JFrame("Metadata Results");
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea(metaManager.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);

        dialogFrame.getContentPane().add(scrollPane);

        dialogFrame.setSize(1024, 768);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setVisible(true);
    }
    
    private void addPanel(JPanel panel, int gridX, int gridY, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.anchor = anchor;
        gbc.insets = new Insets(50, 50, 50, 50); // Add insets for spacing
        contentPane.add(panel, gbc);
    }
    
}