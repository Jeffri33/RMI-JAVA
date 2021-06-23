/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import apps.coordinador;
import interfaces.objCoordinador;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class coordinadorclass extends UnicastRemoteObject implements objCoordinador {

    String loadavg = "loadavg"; //GUARDAR EL VALOR DE LOADAVG 
    

    public coordinadorclass() throws RemoteException {
        super(); //CONSTRUCTOR
    }

    @Override
    public int iniMonitor(String id) throws RemoteException {
        
        //SE REGISTRA
        coordinador.listaMonitor.add(id); 
        System.out.println("Monitor: "+id+" ha sido agregado");
        
        //DEVUELVO LA CANTIDAD DE TIEMPO
        return coordinador.tiempo;
    }

    @Override
    public void loadMonitor(String loadavg) throws RemoteException {
        
        this.loadavg = loadavg; //GUARDO EL VALOR EL LA VARIABLE
    }

    
    @Override
    public int iniClient() throws RemoteException {
        //COMPROBAR QUE MONITORES ESTAN FUNCIONANDO
        //LLAMAR A PING MONITOR
        
        //SI MONITOR = DESCONTECTADO
        //ELIMINAR
        
        
        return coordinador.listaMonitor.size(); //CANTIDAD DE MONITORES FUNCIONANDO
    }

    @Override
    public String getLoadAvg() throws RemoteException {
        
        return loadavg; //ULTIMO VALOR CAPTURADO
    }

}