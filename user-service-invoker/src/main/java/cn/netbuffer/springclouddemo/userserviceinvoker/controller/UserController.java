package cn.netbuffer.springclouddemo.userserviceinvoker.controller;

import cn.netbuffer.springclouddemo.userserviceinvoker.client.UserClient;
import cn.netbuffer.springclouddemo.userserviceinvoker.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/invoke")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserService userService;

    @Resource
    private UserClient userClient;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id, Integer s) {
        log.info("invoke get user {},sleep {} s", id, s);
        if (s == null) {
            return restTemplate.getForObject("http://" + UserService.SERVICE_NAME + "/user/" + id, String.class);
        } else {
            try {
                TimeUnit.SECONDS.sleep(s);
            } catch (InterruptedException e) {
                log.error("sleep InterruptedException", e);
            }
            String result = "user:" + id;
            log.info("return {}", result);
            return result;
        }
    }

    @PostMapping("user")
    public Map addUser(@RequestBody Map user) {
        log.info("addUser={}", user);
        return userClient.add(user);
    }

    @GetMapping("/feign/user/{id}")
    public String fgetUser(@PathVariable("id") Long id, @RequestParam(required = false) Integer s) {
        return userClient.getUser(id, s);
    }

    @GetMapping("headers")
    public Map<String, String> headers(HttpServletRequest httpServletRequest) {
        //经过zuul后会携带x-forwarded-prefix
        Enumeration<String> names = httpServletRequest.getHeaderNames();
        Map<String, String> headers = new HashMap<>();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            headers.put(key, httpServletRequest.getHeader(key));
        }
        return headers;
    }

    @GetMapping("from")
    public void from(HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getHeader("x-forwarded-prefix") != null) {
            log.debug("from zuul");
        }
    }
}
