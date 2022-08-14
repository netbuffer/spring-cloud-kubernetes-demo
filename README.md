# spring-cloud-kubernetes-demo
![](https://img.shields.io/static/v1?label=java&message=1.8&color=blue)
![](https://img.shields.io/static/v1?label=sppring-boot&message=2.6.8&color=blue)
![](https://img.shields.io/static/v1?label=sppring-cloud&message=2021.0.3&color=brightgreen)
![](https://img.shields.io/static/v1?label=lombok&message=1.18.24&color=blue)
* https://github.com/netbuffer/spring-cloud-demo  
* https://gitee.com/netbuffer/spring-cloud-demo

### help
* https://docs.spring.io/spring-cloud/docs/current/reference/html/
* 通过/actuator/service-registry?status=UP/DOWN接口来平滑上下线spring-boot微服务
* curl http://localhost:8700/discoveryclient/getServices
* kubectl apply -f sckd.yaml (for run on k8s)
* kubectl delete -f sckd.yaml
* kubectl  get all -n default -o wide
* 

### Docker Image
* docker build -f user-service-provider/Dockerfile -t javawiki/sckd-user-service-provider:v0.0.1-SNAPSHOT user-service-provider/