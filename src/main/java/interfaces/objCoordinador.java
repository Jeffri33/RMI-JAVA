/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface objCoordinador extends Remote {

    //DEVUELVE EL INTERVALO DE TIEMPO
    int iniMonitor(String id) throws RemoteException; 
    //registra los monitores en el coordinador

    
    void loadMonitor(String loadavg) throws RemoteException; 
    //los monitores llaman a este metodo, le envian el loadavg

    
    int iniClient() throws RemoteException; 
    //el cliente llama este metodo y deviuelve los monitores conectados. el resultado es guardado en la cache del coordinador


    //OBTIENE EL VALOR DE AVG DE LOS MONITORES
    String getLoadAvg() throws RemoteException; 
    //es llamado por el cliente, y consigue el valor avg de los monitores
}