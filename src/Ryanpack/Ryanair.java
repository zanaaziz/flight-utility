package Ryanpack;

public class Ryanair {

    public static void main(String[] args) {
        //For flight table
        RyanairUI GUI = new RyanairUI();
        GUI.setVisible(true);
        
        //User Flight GUI
        RyanAirUserGUI userGUI = new RyanAirUserGUI();
        userGUI.setVisible(true);
    }
    
}