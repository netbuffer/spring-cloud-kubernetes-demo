package cn.netbuffer.springclouddemo.userserviceprovider.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/discoveryclient")
public class DiscoveryClientController {

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private Environment environment;
    @Value("${usp.desc}")
    private String uspDesc;

    @GetMapping("getOrder")
    public int getOrder() {
        return discoveryClient.getOrder();
    }

    @GetMapping("description")
    public String description() {
        return discoveryClient.description();
    }

    @GetMapping("getServices")
    public List<String> getServices() {
        return discoveryClient.getServices();
    }

    @GetMapping("discoveryclient")
    public DiscoveryClient getDiscoveryClient() {
        return discoveryClient;
    }

    @GetMapping("getHostAddress")
    public String getHostAddress() throws UnknownHostException {
        return Inet4Address.getLocalHost().getHostAddress();
    }

    @GetMapping("instances/{serviceId}")
    public List<ServiceInstance> getInstances(@PathVariable("serviceId") String serviceId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        for (ServiceInstance instance : instances) {
            //这里如果未设置prefer-ip-address: true，那么host将是主机名
            log.info("host={} port={} uri={}", instance.getHost(), instance.getPort(), instance.getUri());
        }
        return instances;
    }

    @GetMapping("getActiveProfiles")
    public String[] getActiveProfiles() {
        return environment.getActiveProfiles();
    }

    @GetMapping("getenv")
    public String getEnv(@RequestParam(required = false, defaultValue = "usp.desc") String key) {
        return environment.getProperty(key);
    }

    @GetMapping("getuspdesc")
    public String uspDesc() {
        return uspDesc;
    }

}
