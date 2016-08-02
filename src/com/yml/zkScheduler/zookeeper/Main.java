package com.yml.zkScheduler.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * Created by yml on 7/21/16.
 */
public class Main {
    public static String SERVER = "/server";//node
    public static String TASK ="/task"; //task
    private static final String CONNECTION_STRING = "localhost:2181,localhost:2182";
    private static volatile ZooKeeper zookeeper;
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static int sessionTimeout = 3000;//Session超时时间
    // 创建一个目录节点
    /**
     * CreateMode:
     * 	PERSISTENT (持续的，相对于EPHEMERAL，不会随着client的断开而消失)
     *		PERSISTENT_SEQUENTIAL（持久的且带顺序的）
     *		EPHEMERAL (短暂的，生命周期依赖于client session)
     *		EPHEMERAL_SEQUENTIAL  (短暂的，带顺序的)
     */
    private static String []arg = {"localhost:2181","localhost:2182","localhost:2183"};
    public static void main(String []args)throws IOException,InterruptedException,KeeperException{
        ZooKeeper zk = new ZooKeeper(CONNECTION_STRING,
                sessionTimeout, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                // TODO Auto-generated method stub
                LOG.info("已经触发了" + event.getType() + "事件！");
            }
        });
        ZookeeperFactory zookeeperFactory = new ZookeeperFactory();
        String string = zookeeperFactory.getData(zk,"/disLocks");
        System.out.println(zk.getState().name());
        System.out.println(string);
        zk.create(SERVER,null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

}
