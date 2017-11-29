package Ryanpack;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zanadaniel
 This class will be inherited by the Main class, which is instantiated in all the classes.
 Thus, all functions here will be readily available for use throughout the application.
 *
 */
public class Functions {
        
    /* add padding to a given textfield */
    public void addPaddingToJTextField(JTextField textfield){
        textfield.setBorder(BorderFactory.createCompoundBorder(
        textfield.getBorder(),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }
    
    /* load table data from file */
    public void loadData(String dataFile, JTable jtable){
        File file = new File(dataFile);

        // gets the table tableModel
        DefaultTableModel tableModel = (DefaultTableModel)jtable.getModel();
                
        // clear table
        tableModel.setRowCount(0);
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
                        
            Object[] lines = br.lines().toArray();
            
            for (Object line : lines) {
                String[] row = line.toString().split("//");
                tableModel.addRow(row);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* save table data to file */
    public void saveData(String dataFile, JTable jtable){
        File file = new File(dataFile);
        
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            // rows
            for(int r = 0; r < jtable.getRowCount(); r++){
                // columns
                for(int c = 0; c < jtable.getColumnCount(); c++){
                    bw.flush();
                    bw.write(jtable.getValueAt(r, c).toString() + "//");
                }
                bw.newLine();
            }
            
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Add flight */
    public void AddFlight(String dataFile, JTable jtable, JTextField from, JTextField to, JTextField dep, JTextField arr){
        if(isEmpty(from, to, dep, arr) == false){   
            DefaultTableModel model = (DefaultTableModel)jtable.getModel();
            Object[] newFlight = { "F"+generateFlightID(), "P"+generatePilotID(), from.getText(), to.getText(), dep.getText(), arr.getText(), calculateFlightDuration(dep.getText(), arr.getText()) };
            model.addRow(newFlight);
            saveData(dataFile, jtable);
        }else{
            JOptionPane.showMessageDialog(null, "One or more fields are missing.\nPlease try again.", "Missing Field(s)", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*Delete flight */
    public void DeleteFile(String dataFile, JTable jTable){
        //@reference https://stackoverflow.com/questions/8689122/joptionpane-yes-no-options-confirm-dialog-box-issue-java
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
     
        try{
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this flight?", "Delete Flights", JOptionPane.YES_NO_OPTION);

            if(result == 0) {
                int  SelectedRowIndex = jTable.getSelectedRow();
                model.removeRow(SelectedRowIndex);
                saveData(dataFile, jTable);
            }
        }catch(HeadlessException ex){
            JOptionPane.showMessageDialog(null, "Error "+ex);
        }
    }
    
    /*Update*/
    public void iFle(String dataFile, JTable jTable){}
    
    
    /* generates a number between the range of 10000 to 99999 */
    public String generateFlightID(){
        Random flightNumberGenerator = new Random();
        int flightID = flightNumberGenerator.nextInt(99999 - 10000 + 1) + 10000;
        return Integer.toString(flightID);
    }
    
    /* generates a number between the range of 100 to 999 */
    public String generatePilotID(){
        Random pilotNumberGenerator = new Random();
        int pilotID = pilotNumberGenerator.nextInt(999 - 100 + 1) + 100;
        return Integer.toString(pilotID);
    }
    
    /* calculates the flight duration in hours between the departure date and arrival date */
    public String calculateFlightDuration(String dep, String arr){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        Date departure;
        Date arrival;
        long duration = 0;

        try {
            departure = format.parse(dep);
            
            arrival = format.parse(arr);

            long difference = arrival.getTime() - departure.getTime();
            long durationInHours = difference / (60 * 60 * 1000) % 24;
            long durationInDays = difference / (24 * 60 * 60 * 1000);

            duration = (durationInDays * 24) + durationInHours;
            
        } catch (ParseException ex) {
            Logger.getLogger(AddFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Long.toString(duration);
    }
    
    /* checks if textfields are empty */
    public boolean isEmpty(JTextField a, JTextField b, JTextField c, JTextField d){
        if(a.getText().isEmpty() || b.getText().isEmpty() || c.getText().isEmpty() || d.getText().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    /* setting the look and feel to Nimbus */
    public void setTheme(){
        try{
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            System.out.println(e);
        }
    }
}