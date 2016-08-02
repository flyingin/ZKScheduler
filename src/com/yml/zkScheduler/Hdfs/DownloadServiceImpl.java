package com.yml.zkScheduler.Hdfs;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * Created by yml on 8/1/16.
 */
public class DownloadServiceImpl extends UnicastRemoteObject implements DownloadService {
    private final String url = "hdfs://master:9000";
    private final Configuration configuration = new Configuration();
    protected DownloadServiceImpl() throws RemoteException {
    }
    @Override
    public void Download(String src,String dst) throws RemoteException {
        try{
            configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fileSystem = FileSystem.get(URI.create(url),configuration);
            Path srcPath = new Path(src);
            Path dstPath = new Path(dst);
            fileSystem.copyToLocalFile(srcPath,dstPath);
            fileSystem.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
