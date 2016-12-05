# docker-tomcat-scenario
Tomcat scenario based on **Docker**, testing skywalking tracer for tomcat.

* command that build docker images
```shell
   mvn package docker:build
```

* Provide Tomcat and Application to instrument.
  * Tomcat 7
  * Tomcat 8
* docker run, for sky-walking tracer
```shell
    docker run -it --env SERVER_LIST=<routing server address> -p <server port>:8080 -p <jpda port>:8000 -v <dir that store skywalking agent jar >:/usr/local/agent tomcat-scenario:7
```

**Prepare on release**...
