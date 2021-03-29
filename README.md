# Spring Boot Buildpack
Example project showing Paketo buildpacks together with Spring Boot 2.4 

## Table of Content  
                   

##  Buildpacks? CNCF??
__Buildpacks?__

* Heroku invented (2011)  the term buildpacks and drove the first ideas around the concept to have  a cloud first build framework that is easy

> Buildpacks were first conceived by Heroku in 2011. Since then, they have been adopted by Cloud Foundry (Pivotal) and other PaaS such as Google App Engine, Gitlab, Knative, Deis, Dokku, and Drie.

__Cloud Native Buildpacks (CNCF) & Paketo__

* today: [CNCF Incubation project](https://www.cncf.io/blog/2020/11/18/toc-approves-cloud-native-buildpacks-from-sandbox-to-incubation/)

> Specification for turning applications into Docker images: [buildpacks.io](https://buildpacks.io/)

Paketo.io is an implementation for major languages (Java, Go, .Net, node.js, Ruby, PHP...)
--> [paketo.io](https://paketo.io/)

Similar to tools are from Google Jib https://github.com/GoogleContainerTools/jib, ko https://github.com/google/ko, or C++: Bazel (https://bazel.build/)

__Gradle Plugin to use Paketo Buildpacks__

The Spring Boot Gradle plugin  takes care of doing the Paketo build. If you have used a starter project from start.spring.io you are ready to go:

```shell script
gradle bootBuildImage
```


```
 > Task :bootBuildImage
Building image 'docker.io/library/spring-buildpack:0.0.1-SNAPSHOT'

 > Pulling builder image 'docker.io/paketobuildpacks/builder:base' ..................................................
 > Pulled builder image 'paketobuildpacks/builder@sha256:8078a685a85014b4fb30c6749ad0abdd4f4affeeb7be6836963eb10ee04fe8b2'
 > Pulling run image 'docker.io/paketobuildpacks/run:base-cnb' ..................................................
 > Pulled run image 'paketobuildpacks/run@sha256:0bf521429c5fac06616ef542da735f9e34c4997cc5d5987242eb7199b04ac923'
 > Executing lifecycle version v0.10.2
 > Using build cache volume 'pack-cache-f4e51fa19e8e.build'

 > Running creator
    [creator]     ===> DETECTING
    [creator]     5 of 18 buildpacks participating
    [creator]     paketo-buildpacks/ca-certificates   2.1.0
    [creator]     paketo-buildpacks/bellsoft-liberica 7.1.0
    [creator]     paketo-buildpacks/executable-jar    5.0.0
    [creator]     paketo-buildpacks/dist-zip          4.0.0
    [creator]     paketo-buildpacks/spring-boot       4.1.0
    [creator]     ===> ANALYZING
    [creator]     Previous image with name "docker.io/library/spring-buildpack:0.0.1-SNAPSHOT" not found
    [creator]     ===> RESTORING
    [creator]     ===> BUILDING
    [creator]
    [creator]     Paketo CA Certificates Buildpack 2.1.0
    [creator]       https://github.com/paketo-buildpacks/ca-certificates
    [creator]       Launch Helper: Contributing to layer
    [creator]         Creating /layers/paketo-buildpacks_ca-certificates/helper/exec.d/ca-certificates-helper
    [creator]
    [creator]     Paketo BellSoft Liberica Buildpack 7.1.0
    [creator]       https://github.com/paketo-buildpacks/bellsoft-liberica
    [creator]       Build Configuration:
```


Successfully built image 'docker.io/library/spring-buildpack:0.0.1-SNAPSHOT'







$ docker run -p 8080:8080 -it spring-buildpack:0.0.1-SNAPSHOT

```
Setting Active Processor Count to 2
Calculating JVM memory based on 1066992K available memory
Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -Xmx666398K -XX:MaxMetaspaceSize=93393K -XX:ReservedCodeCacheSize=240M -Xss1M (Total Memory: 1066992K, Thread Count: 50, Loaded Class Count: 14075, Headroom: 0%)
Adding 129 container CA certificates to JVM truststore
Spring Cloud Bindings Enabled
Picked up JAVA_TOOL_OPTIONS: -Djava.security.properties=/layers/paketo-buildpacks_bellsoft-liberica/java-security-properties/java-security.properties -agentpath:/layers/paketo-buildpacks_bellsoft-liberica/jvmkill/jvmkill-1.16.0-RELEASE.so=printHeapHistogram=1 -XX:ActiveProcessorCount=2 -XX:MaxDirectMemorySize=10M -Xmx666398K -XX:MaxMetaspaceSize=93393K -XX:ReservedCodeCacheSize=240M -Xss1M -Dorg.springframework.cloud.bindings.boot.enable=true

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

2021-03-29 17:16:14.649  INFO 1 --- [           main] i.g.h.s.SpringBuildpackApplicationKt     : Starting SpringBuildpackApplicationKt using Java 11.0.10 on 0db7aa49dbc5 with PID 1 (/workspace/BOOT-INF/classes started by cnb in /workspace)
2021-03-29 17:16:14.656  INFO 1 --- [           main] i.g.h.s.SpringBuildpackApplicationKt     : No active profile set, falling back to default profiles: default
2021-03-29 17:16:18.033  INFO 1 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2021-03-29 17:16:18.065  INFO 1 --- [           main] i.g.h.s.SpringBuildpackApplicationKt     : Started SpringBuildpackApplicationKt in 4.473 seconds (JVM running for 5.368)
```
