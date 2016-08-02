package com.yml.zkScheduler.Hello;

/**
 * Created by yml on 7/25/16.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IRMI extends Remote{
    public String invoke() throws RemoteException;
}
