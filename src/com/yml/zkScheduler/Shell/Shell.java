package com.yml.zkScheduler.Shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yml on 7/26/16.
 */
public class Shell {
    public static void main(String []args){
        String shpath="/home/yml/test.sh";   //程序路径
        String command1 = "chmod 777 " + shpath;
        try {
            Runtime.getRuntime().exec(command1 ).waitFor();
        } catch (IOException e1) {
            e1.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }


        String var="201102";  //参数
        String command2 = "/bin/sh " + shpath + " "+var;
        try{
            Process pcs = Runtime.getRuntime().exec(command2);
            BufferedReader br = new BufferedReader(new InputStreamReader(pcs.getInputStream()));
            String line=new String();
            while((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /*public static void main(String args[]) throws IOException{

        Runtime rt=Runtime.getRuntime();
        String command="/home/yml/test.sh";
        Process pcs=rt.exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(pcs.getInputStream()));
        String line=new String();
        while((line = br.readLine()) != null)
        {
            System.out.println(line);
        }
        try{
            pcs.waitFor();
        }
        catch(InterruptedException e){
            System.err.println("processes was interrupted");
        }
        br.close();
        int ret=pcs.exitValue();
        System.out.println(ret);
        System.out.println("执行完毕!");
    }*/
}
