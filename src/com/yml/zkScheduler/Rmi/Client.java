package com.yml.zkScheduler.Rmi;

/**
 * Created by yml on 8/1/16.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        ServiceConsumer consumer = new ServiceConsumer();
        int i=0;
        while (true) {
            HelloService helloService = consumer.lookup();
            String result = helloService.sayHello("Jack");
            System.out.println(i+1+":"+result);
            i++;
            Thread.sleep(3000);
        }
    }
}