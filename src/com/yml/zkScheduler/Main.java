package com.yml.zkScheduler;

import com.yml.zkScheduler.Hdfs.UploadImpl;
import com.yml.zkScheduler.monitor.State;

/**
 * Created by yml on 7/27/16.
 */
public class Main {
    private static String src = "/home/yml/Desktop/monkey-master.zip";
    private static String dst = "/home/yml/test";
    private static String ip = "192.1689.226.131"; //要执行的机器节点IP
    public static void main(String []args){
        //步奏1：上传到Hdfs中
        try{
            UploadImpl.Upload(src,dst);
        }catch (Exception e){
            e.printStackTrace();
        }
        //步奏2：将Hdfs中的文件下载到要执行的机器节点中

    }
}
