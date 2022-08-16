FROM javawiki/supervisord:v4.0.2-openjdk8
ARG project_dir=/usr/local/project/
COPY user-service-invoker/target/*.jar $project_dir
COPY user-service-provider/target/*.jar $project_dir
COPY spring-cloud-kubernetes-demo.ini /etc/supervisor.d/spring-cloud-kubernetes-demo.conf