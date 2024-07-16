package com.evtask.myproject.main;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        String webAppDir = Paths.get("src/main/webapp").toAbsolutePath().toString();
        File webApp = new File(webAppDir);
        if (!webApp.exists() || !webApp.isDirectory()) {
            throw new IllegalArgumentException("webapp does not exist or is not a directory" + webAppDir);
        }
        tomcat.addWebapp("/", webAppDir);
        tomcat.start();
        System.out.println("Tomcat started" + tomcat.getConnector().getPort());
        tomcat.getServer().await();
    }
}
