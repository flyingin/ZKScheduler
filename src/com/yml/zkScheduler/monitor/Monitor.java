package com.yml.zkScheduler.monitor;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by yml on 8/1/16.
 */
public class Monitor{
    private static String ClusterIpPort;
    private static String [] stat;
    private Timer timer = new Timer();
    private Calendar calendar = Calendar.getInstance();
    static {
        Properties props = new Properties();
        InputStream in = Object.class.getResourceAsStream("/com/yml/zkScheduler/Resources/configure.properties");
        try{
            props.load(in);
            ClusterIpPort = props.getProperty("ClusterIpPort").trim();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        int count = 1;
        Callable callable = new Monitorcall(ClusterIpPort);
        try{
            while (true){
                System.out.println(count+"----------------");
                String []result = (String[]) callable.call();
                for(String record:result){
                    System.out.println(record);
                }
                System.out.println("-----------");
                count++;
                Thread.sleep(6000);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
class Monitorcall  implements Callable {
    public String[] IpPort;
    Monitorcall(String ClusterIpPort){
        this.IpPort = ClusterIpPort.split(",");
    }
    //String []IpPort = ClusterIpPort.split(",");
    @Override
    public Object call() throws Exception {
        return State.Stat(IpPort);
    }
}
