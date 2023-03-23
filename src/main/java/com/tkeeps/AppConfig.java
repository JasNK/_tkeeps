package com.tkeeps;

import com.tkeeps.config.JPAConfig;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("api")
public class AppConfig extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "com.tkeeps.controller");
        JPAConfig.getEntityManager();
        return properties;
    }
}
