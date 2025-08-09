package Memento2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ScheduleGUI extends JFrame {  // Caretaker
    private static final long serialVersionUID = 1L;

    private ScheduleTableModel.TableMemento memento;
    private ScheduleTableModel tableModel;

    private Object[][] data = {
        {"08.00-09.00", "----", "Math", "", "", ""},
        {"09.00-10.00", "", "Math", "", "", ""},
        {"10.00-11.00", "", "", "SE 2", "", "Math"},
        {"11.00-12.00", "", "", "SE 2", "", "Math"},
        {"12.00-13.00", "----", "----", "----", "----", "----"},
        {"13.00-14.00", "SE 2", "OpSys", "", "", ""},
        {"14.00-15.00", "SE 2", "OpSys", "", "Project", ""},
        {"15.00-16.00", "", "OpSys", "", "Project", ""},
        {"16.00-17.00", "", "OpSys", "", "Project", ""},
        {"17.00-18.00", "", "", "", "Project", ""}
    };

    private String[] columnNames = {
        "Time",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday"
    };

    public ScheduleGUI() {
        super("Schedule GUI with Memento");
        initComponents();
        pack();
    }

    protected void initComponents() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });

        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        // Add "Save As.." menu item here; register corresponding
        // listener (optional);
        JMenuItem saveAsMenuItem = new JMenuItem("Save As...");
        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsMenuItemActionPerformed(e);
            }
        });
        fileMenu.add(saveAsMenuItem);
        
        // Add "Load" menu item
        JMenuItem loadMenuItem = new JMenuItem("Load...");
        loadMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMenuItemActionPerformed(e);
            }
        });
        fileMenu.add(loadMenuItem);
        fileMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitMenuItemActionPerformed(e);
            }
        });

        fileMenu.add(exitMenuItem);
        mb.add(fileMenu);
        setJMenuBar(mb);

        tableModel = new ScheduleTableModel(data, columnNames);
        final JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton newButton = new JButton("Snapshot");
        newButton.setPreferredSize(new Dimension(125, 27));
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Get new memento.
                memento = tableModel.createMemento();
                JOptionPane.showMessageDialog(ScheduleGUI.this, 
                    "Snapshot taken!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton revertButton = new JButton("Revert");
        revertButton.setPreferredSize(new Dimension(125, 27));
        revertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Set memento.
                if (memento != null) {
                    tableModel.setMemento(memento);
                    JOptionPane.showMessageDialog(ScheduleGUI.this, 
                        "Reverted to snapshot!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ScheduleGUI.this, 
                        "No snapshot available!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        JPanel panel = new JPanel();
        panel.add(newButton);
        panel.add(revertButton);
        getContentPane().add(panel, BorderLayout.SOUTH);

        // Take a memento for the initial state of the table.
        memento = tableModel.createMemento();
    }

    protected void exitMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    protected void exitForm(WindowEvent e) {
        System.exit(0);
    }

    protected void saveAsMenuItemActionPerformed(ActionEvent evt) {
        if (memento == null) {
            JOptionPane.showMessageDialog(this, 
                "No memento available to save. Please take a snapshot first!", 
                "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Memento As...");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Memento files (*.mem)", "mem"));
        
        // Set default filename
        fileChooser.setSelectedFile(new java.io.File("schedule_snapshot.mem"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            
            // Add .mem extension if not present
            if (!fileToSave.getName().toLowerCase().endsWith(".mem")) {
                fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".mem");
            }

            try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(
                    new java.io.FileOutputStream(fileToSave))) {
                
                oos.writeObject(memento);
                JOptionPane.showMessageDialog(this, 
                    "Memento saved successfully to: " + fileToSave.getName(), 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (java.io.IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error saving memento: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void loadMenuItemActionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load Memento...");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Memento files (*.mem)", "mem"));

        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToLoad = fileChooser.getSelectedFile();

            try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
                    new java.io.FileInputStream(fileToLoad))) {
                
                Object loadedObject = ois.readObject();
                
                if (loadedObject instanceof ScheduleTableModel.TableMemento) {
                    ScheduleTableModel.TableMemento loadedMemento = 
                        (ScheduleTableModel.TableMemento) loadedObject;
                    
                    // Apply the loaded memento to the table
                    tableModel.setMemento(loadedMemento);
                    
                    // Update the current memento reference
                    memento = loadedMemento;
                    
                    JOptionPane.showMessageDialog(this, 
                        "Memento loaded and applied successfully from: " + fileToLoad.getName(), 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Invalid file format. Please select a valid memento file.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (java.io.IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error loading memento: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error: Incompatible memento file format.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScheduleGUI().setVisible(true);
            }
        });
    } // end of main ()
}