package com.yml.zkScheduler.Hdfs;

import org.apache.hadoop.conf.Configuration;

/**
 * Created by yml on 8/1/16.
 */
public interface HdfsConstant {
    String url = "hdfs://master:9000";
    Configuration configuration = new Configuration();
}
