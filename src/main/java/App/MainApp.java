package App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Enums.MetadataType;
import Model.MetadataManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public MainApp() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel inputPanel = createInputPanel();
        contentPane.add(inputPanel, BorderLayout.NORTH);

        JPanel checkboxPanel = createCheckboxPanel();
        contentPane.add(checkboxPanel, BorderLayout.WEST);

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
                System.exit(0); // Exit the application
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(fetchMetadataButton);
        buttonPanel.add(exitButton);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        usernameField = new JTextField("reportUser");
        passwordField = new JPasswordField("123456");
        ipField = new JTextField("localhost:3306");
        tableNameField = new JTextField("ALL");//"salesorderheader");
        schemaNameField = new JTextField("adventureworks");

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

    private JPanel createCheckboxPanel() {
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));

        for (MetadataType type : MetadataType.values()) {
            JCheckBox checkBox = new JCheckBox(type.getDisplayName());
            checkboxMap.put(type, checkBox);
            checkboxPanel.add(checkBox);
        }

        return checkboxPanel;
    }

    private void displayMetadataResults() throws SQLException {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        String ip = ipField.getText();
        String tableName = tableNameField.getText();
        String schemaName = schemaNameField.getText();
        
        metaManager = new MetadataManager();
        ArrayList<MetadataType> tableTypes = new ArrayList<>();
        for (Map.Entry<MetadataType, JCheckBox> entry : checkboxMap.entrySet()) {
            MetadataType type = entry.getKey();
            JCheckBox checkBox = entry.getValue();
            if (checkBox.isSelected()) {
                tableTypes.add(type);
            }
        }
        metaManager.createMetadata(ip, schemaName, username, password, tableTypes, schemaName, tableName);

    }
}