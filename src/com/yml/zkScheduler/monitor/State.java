package com.yml.zkScheduler.monitor;

/**
 * Created by yml on 7/22/16.
 */
/*监控集群的状态，监控的是zookeeper的状态
* */
public class State {
    public  static String ReturnStat(String ip,int port){
        boolean state;
        String result = null;
        TelnetTools telnetTools = new TelnetTools();
        telnetTools.login(ip,port);
        state = telnetTools.state;
        if(state){
            String stat = telnetTools.sendCommand("stat");
            String []records=stat.split("\n");
            for(String s:records){
                if(s.startsWith("Mode:")){
                    result=s.substring(6);
                }
            }
        }else {
            result = "error";
        }
        telnetTools.distinct();
        return result;
    }

    public static String []Stat(String []IpPort){
        int i = 0;
        String []result = new String[IpPort.length];
        for (String record:IpPort){
            result[i]=record+";"+ReturnStat(record.split(":")[0],Integer.valueOf(record.split(":")[1]));
            i++;
        }
        return result;
    }
    public static void main(String []args){
        System.out.println(ReturnStat("localhost",2181));
        System.out.println(ReturnStat("localhost",2182));
        System.out.println(ReturnStat("localhost",2183));
    }
}
