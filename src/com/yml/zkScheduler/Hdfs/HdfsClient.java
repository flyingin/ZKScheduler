package com.yml.zkScheduler.Hdfs;

import com.yml.zkScheduler.Rmi.HelloService;
import com.yml.zkScheduler.Rmi.ServiceConsumer;

import java.rmi.RemoteException;

/**
 * Created by yml on 8/1/16.
 */
public class HdfsClient {
    public static void main(String []args)throws RemoteException{
        String src = "/test.sh";
        String dst = "/home/yml";

        ServiceConsumer consumer = new ServiceConsumer();

        DownloadService downloadService = consumer.lookup();
        downloadService.Download(src,dst);
    }
}
