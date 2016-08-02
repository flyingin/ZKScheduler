package com.yml.zkScheduler.Rmi;

/**
 * Created by yml on 8/1/16.
 */
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

    public static void main(String[] args) throws Exception {
        String ip = args[0];
        int port = Integer.valueOf(args[1]);
        String url = "rmi://"+ip+":"+port+"/demo.zookeeper.remoting.server.HelloServiceImpl";
        LocateRegistry.createRegistry(port);
        Naming.rebind(url, new HelloServiceImpl());
    }
}
