package com.companyName.snmpPoller.config;
/*
root 9/13/18 11:18 PM
*/

import org.snmp4j.TransportMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.io.IOException;

public class AppListener implements ApplicationListener<ApplicationReadyEvent> {

    private final TransportMapping transportMapping;

    @Autowired
    public AppListener(TransportMapping transportMapping) {
        this.transportMapping = transportMapping;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent readyEvent) {

        System.out.println("Application is ready");
        try {
            transportMapping.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
