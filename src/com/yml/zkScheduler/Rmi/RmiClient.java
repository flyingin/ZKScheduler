package com.yml.zkScheduler.Rmi;

/**
 * Created by yml on 8/1/16.
 */
import java.rmi.Naming;

public class RmiClient {

    public static void main(String[] args) throws Exception {
        String url = "rmi://192.168.226.131:1099/demo.zookeeper.remoting.server.HelloServiceImpl";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("Jack");
        System.out.println(result);
    }
}