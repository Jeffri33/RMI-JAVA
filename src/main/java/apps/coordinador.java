/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

/**
 *
 * @author evert
 */
import clases.coordinadorclass;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class coordinador {

    public static int tiempo;
    public static ArrayList<String> listaMonitor = new ArrayList<String>();

    public static void main(String[] args) {

        try {

            //REGISTRO
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("miCoordinador", (Remote) new coordinadorclass());
           
            
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            System.exit(0);
        }

        //PEDIR
        
        System.out.print("Intervalo de medición de los monitores: ");
        Scanner leer = new Scanner(System.in);
        tiempo = leer.nextInt();
        
        //---
        System.out.println("Servidor en ejecucion...");
    }
}