package cn.netbuffer.springclouddemo.userserviceprovider.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/discoveryclient")
public class DiscoveryClientController {

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("instances/{serviceId}")
    public List<ServiceInstance> getInstances(@PathVariable("serviceId") String serviceId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        for (ServiceInstance instance : instances) {
            //这里如果未设置prefer-ip-address: true，那么host将是主机名
            log.info("host={} port={} uri={}", instance.getHost(), instance.getPort(), instance.getUri());
        }
        return instances;
    }
}
