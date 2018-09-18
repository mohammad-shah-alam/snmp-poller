package com.companyName.snmpPoller.config;
/*
root 9/13/18 10:37 PM
*/

import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Config {

    @Bean
    public TransportMapping transportMapping() throws IOException {
        return new DefaultUdpTransportMapping();
    }

    @Bean
    public Snmp snmp(TransportMapping transportMapping) {
        return new Snmp(transportMapping);
    }
}
