package cn.netbuffer.springclouddemo.userserviceinvoker.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class UserService {

    @Resource
    private RestTemplate restTemplate;

    public String getUser(Long id) {
        String r = restTemplate.getForObject("http://user-service-provider/user/" + id, String.class);
        log.info("after getUser {},result:{}", id, r);
        return r;
    }

    public String getUserRandomSleep(Long id) {
        int sleep = RandomUtils.nextInt(1,6);
        log.info("invoke getUser {},sleep {} s", id, sleep);
        String r = restTemplate.getForObject("http://user-service-provider/user/" + id + "?s={1}", String.class, sleep);
        log.info("after getUser {},result:{}", id, r);
        return r;
    }

    public String getUserWithSeparateThreadPool(Long id) {
        int sleep = RandomUtils.nextInt(1,6);
        log.info("invoke getUser {},sleep {} s", id, sleep);
        String r = restTemplate.getForObject("http://user-service-provider/user/" + id + "?s={1}", String.class, sleep);
        log.info("after getUser {},result:{}", id, r);
        return r;
    }

    public String getUserFallback(Long id) {
        log.error("getUserFallback {}", id);
        return id + " error at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
