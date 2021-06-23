/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import interfaces.objCoordinador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author evert
 */
public class monitor2 {
    public static void main(String[] args) {

        int segundos;
        String ip = "localhost";
        String id;
        String loadavg;

        try {

            //EXTRAER VALOR DEL FICHERO
            BufferedReader br2 = new BufferedReader(new FileReader(new File("/etc/hostname")));
            id = br2.readLine();
            System.out.println("Monitor 2: " + id + " - en ejecucion");

            //REGISTRO DE LAS FUNCIONES
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            objCoordinador miCoordinador = (objCoordinador) registry.lookup("miCoordinador");

            //OBTENGO LOS SEGUNDOS
            segundos = miCoordinador.iniMonitor(id);

            while (true) {
                
                //EXTRAER VALOR DEL FICHERO
                BufferedReader br = new BufferedReader(new FileReader(new File("/proc/loadavg")));
                loadavg = br.readLine();

                //INSERTAR DATO DEL FICHERO LOADAVG
                miCoordinador.loadMonitor(loadavg);

                //ESPERAMOS X SEGUNDOS
                Thread.sleep(segundos * 15);
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

    }
    
}
