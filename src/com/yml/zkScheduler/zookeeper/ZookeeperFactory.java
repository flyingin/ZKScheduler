package com.yml.zkScheduler.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yml on 7/22/16.
 */
public class ZookeeperFactory {
    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperFactory.class);
    public static String getData(ZooKeeper zk, String path) {
        if (zk == null) {
            return null;
        }
        byte[] bytes = null;
        try {
            bytes = zk.getData(path, false, null);
        } catch (KeeperException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(bytes);
    }
    public static void setData(ZooKeeper zk,String path, String value) {
        if (zk == null) {
            LOG.info("Set Data Error: " + value);
            return;
        } else {
            try {
                zk.setData(path, value.getBytes(), -1);
                LOG.info("Set Data success.");
            } catch (KeeperException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void delete(ZooKeeper zk,String path){
        if(zk==null){
            LOG.info("zkClient is null");
            return;
        }else {
            try{
                zk.delete(path,-1);
                LOG.info("delete path success.");
            }catch (KeeperException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
