# spring-cloud-kubernetes-demo
![](https://img.shields.io/static/v1?label=java&message=1.8&color=blue)
![](https://img.shields.io/static/v1?label=sppring-boot&message=2.6.8&color=blue)
![](https://img.shields.io/static/v1?label=sppring-cloud&message=2021.0.3&color=brightgreen)
![](https://img.shields.io/static/v1?label=lombok&message=1.18.24&color=blue)
* https://github.com/netbuffer/spring-cloud-kubernetes-demo
* https://gitee.com/netbuffer/spring-cloud-kubernetes-demo
![spring-cloud-kubernetes](https://raw.githubusercontent.com/salaboy/s1p_docs/master/s1p.png)

### help
* https://docs.spring.io/spring-cloud/docs/current/reference/html/
* https://github.com/wujiuye/share-projects/blob/main/sck-demo
* https://github.com/spring-cloud/spring-cloud-kubernetes
* curl http://localhost:8700/discoveryclient/getServices
* curl http://localhost:8700/discoveryclient/instances/{service}
* curl k8s-node-ip:30101/invoke/user/1
* curl k8s-node-ip:30102/discoveryclient/getServices
* kubectl apply -f sckd.yaml (for run on k8s)
* kubectl delete -f sckd.yaml
* kubectl get all -n default -o wide
* kubectl logs -f -n default xxx

### Docker Image
* docker build -f user-service-provider/Dockerfile -t javawiki/sckd-user-service-provider:v0.0.1-SNAPSHOT user-service-provider/
* docker build -f user-service-invoker/Dockerfile -t javawiki/sckd-user-service-invoker:v0.0.1-SNAPSHOT user-service-invoker/
* docker build -t javawiki/spring-cloud-kubernetes-demo:v1.0.0 .