package com.yml.zkScheduler.Hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.rmi.RemoteException;

/**
 * Created by yml on 8/1/16.
 */
public class UploadImpl {
    public static void Upload(String src,String dst) throws RemoteException,Exception {
        Configuration configuration = HdfsConstant.configuration;
        String url = HdfsConstant.url;
        try {
            configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fileSystem = FileSystem.get(URI.create(url), configuration);
            Path srcPath = new Path(src);//本地文件系统中的路径
            Path dstPath = new Path(dst);//Hdfs中的文件路径
            if(fileSystem.exists(dstPath)!=false){
                fileSystem.copyFromLocalFile(srcPath, dstPath);
            }else {
                fileSystem.mkdirs(dstPath);
                fileSystem.copyFromLocalFile(srcPath,dstPath);
            }
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        String src = "/home/yml/Desktop/monkey-master.zip";
        String dst = "/home/yml/test";
        try{
            Upload(src,dst);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
