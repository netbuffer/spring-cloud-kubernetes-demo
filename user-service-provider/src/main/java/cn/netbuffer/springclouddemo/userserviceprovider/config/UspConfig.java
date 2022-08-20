package cn.netbuffer.springclouddemo.userserviceprovider.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "usp")
public class UspConfig {

    private String desc;

}