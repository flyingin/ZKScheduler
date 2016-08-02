package com.yml.zkScheduler.Rmi;

/**
 * Created by yml on 8/1/16.
 */
public interface Constant {

    String ZK_CONNECTION_STRING = "localhost:2181";
    int ZK_SESSION_TIMEOUT = 5000;
    String ZK_REGISTRY_PATH = "/registry";
    String ZK_PROVIDER_PATH = ZK_REGISTRY_PATH + "/provider";
}
