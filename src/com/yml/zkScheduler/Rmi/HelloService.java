package com.yml.zkScheduler.Rmi;

/**
 * Created by yml on 8/1/16.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;
}
