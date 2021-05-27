package com.ypw.code.java.https;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class HttpAndHttpsConfig {

    @Value("${server.port}")
    private Integer port;

    @Bean
    public ServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addAdditionalTomcatConnectors(createStandardConnector());
        return factory;
    }

    /**
     * @author: yangpengwei
     * @time: 2021/5/27 4:03 下午
     * @description http 端口配置
     */
    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(port-1);
        return connector;
    }

}
