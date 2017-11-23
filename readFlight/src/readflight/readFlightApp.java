/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readflight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author x16300351
 */
public class readFlightApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //I dont remember this
       /* readFlightsGUI myGUI = new readFlightsGUI();
        myGUI.setVisible(true);*/
       Scanner scanner = new Scanner(System.in);
        BufferedReader buffRead = null;
        String line;
            
        System.out.println("Enter the file");
        
        try{
            buffRead = new BufferedReader(new FileReader("H:\\OPP\\OOP Project\\Project\\practise\\readFlight\\Flights\\" + scanner.next()));
        } catch (FileNotFoundException fnfex) {
            System.out.println(fnfex.getMessage() + "The file wasn't found");
            //System.exit(0);
        }
        try{
            while((line = buffRead.readLine()) != null){
                System.out.println("Here is "+line);
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage() + " Error reading file");
        } finally {
            //System.exit(0);
        }
    }

}
