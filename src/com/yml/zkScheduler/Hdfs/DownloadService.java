package com.yml.zkScheduler.Hdfs;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by yml on 8/1/16.
 */
public interface DownloadService extends Remote {
    void Download(String src,String dst) throws RemoteException;
}
