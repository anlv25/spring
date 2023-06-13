package com.example.eureka;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class EurekaEventService {

    @EventListener
    public void onInstanceDown(EurekaInstanceCanceledEvent event) {
        String appName = event.getAppName();
        String instanceId = event.getServerId();
        System.out.println("Service instance down - App Name: " + appName + ", Instance ID: " + instanceId);
        // Thực hiện các hành động phù hợp khi service instance bị down
    }

}
