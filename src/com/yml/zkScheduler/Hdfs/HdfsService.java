package com.yml.zkScheduler.Hdfs;

import com.yml.zkScheduler.Rmi.ServiceProvider;

/**
 * Created by yml on 8/1/16.
 */
public class HdfsService {
    public static void main(String []args) throws Exception{
        if (args.length != 2) {
            System.err.println("please using command: java Server <rmi_host> <rmi_port>");
            System.exit(-1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        ServiceProvider provider = new ServiceProvider();

        DownloadService downloadService = new DownloadServiceImpl();

        provider.publish(downloadService, host, port);

        Thread.sleep(Integer.MAX_VALUE);
    }
}
