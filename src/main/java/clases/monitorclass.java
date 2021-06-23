/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author evert
 */
import interfaces.objMonitor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class monitorclass extends UnicastRemoteObject implements objMonitor {

    public monitorclass() throws RemoteException {
        super();
    }

    
    @Override
    public void pingMonitor() throws RemoteException {
        System.out.print("monitor activo\n");
        
        
    }
}