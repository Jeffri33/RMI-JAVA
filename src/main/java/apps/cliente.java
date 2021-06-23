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
import interfaces.objCoordinador;
import interfaces.objMonitor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) throws RemoteException, NotBoundException {

        int segundos;
        

        try {
            //REGISTRO DE LAS FUNCIONES
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            objCoordinador miCoordinador = (objCoordinador) registry.lookup("miCoordinador");
            objMonitor miMonitor = (objMonitor) registry.lookup("miMonitor");

            //VERIFICAR CUANTOS MONITORES HAY FUNCIONANDO
            if (miCoordinador.iniClient() > 0) {
                //se consigue el tiempo de medicion
                
                System.out.print("Segundos: ");
                Scanner leer = new Scanner(System.in);
                segundos = leer.nextInt();

                //devuelve la cantidad de monitores activos
                while (true) {
                    miMonitor.pingMonitor();
                    
                    System.out.println("loadavg: " + miCoordinador.getLoadAvg());

                    //se espera para la siguiente consulta
                    Thread.sleep(segundos * 1000);
                }
            } else {
                System.out.println("No hay monitores registrados...");
            }
        } catch (InterruptedException | NotBoundException | RemoteException ex) {
            System.out.println(ex.getMessage());
        }

    }
}