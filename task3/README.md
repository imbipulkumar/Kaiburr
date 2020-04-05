# Task 3

:globe_with_meridians: :rocket: [LIVE APP](http://3.18.207.40/)

**NOTE:** [README First](/README.md)

### Requirements

- Docker
- docker-compose

## Docker compose Dockerizing multi-container application

#### Containerizing Task1 and Task4 apps

docker-compose.yaml file contains commands to set up multi-container services.

Example docker-compose.yaml file

```
version: '3.1'

services:

  mongod:	#Service name
    image: mongo	#Official MongoDB container image
    container_name: "mongod"
    ports:
    - 27017:27017	#<host-port>:<container-port>

  spring-server:
    image: imbipulkumar/task1javarestapiserver	#My task1 container image. You can set
    ports:                                      #your own task1 container image
    - 8080:8080	#<host-port>:<container-port>
    links:
    - mongod	#Links
```

1. Go to `/Task1docker-compose` folder

2. Run `sudo docker-compose up`
Containers of Task2 and Task4 will load and run.

Web App will start and available at port `80` of the `localhost`.

#### Containerizing Task2 and Task4 apps

1. Go to `/Task1docker-compose` folder

2. Run `sudo docker-compose up`
Containers of Task1 will load and run.

3. Go to `Task4Dockerfile`

4. Run `sudo docker run -p 80:3000 <task4_container_image_name>

Web App will start and available at port `80` of the `localhost`.

## Container Logs

```
mongodb          | 2020-04-04T21:04:38.187+0000 I  INDEX    [LogicalSessionCacheRefresh] build may temporarily use up to 200 megabytes of RAM
mongodb          | 2020-04-04T21:04:38.226+0000 I  INDEX    [LogicalSessionCacheRefresh] index build: collection scan done. scanned 0 total records in 0 seconds
mongodb          | 2020-04-04T21:04:38.269+0000 I  INDEX    [LogicalSessionCacheRefresh] index build: inserted 0 keys from external sorter into index in 0 seconds
mongodb          | 2020-04-04T21:04:38.393+0000 I  INDEX    [LogicalSessionCacheRefresh] index build: done building index lsidTTLIndex on ns config.system.sessions
mongodb          | 2020-04-04T21:04:38.552+0000 I  COMMAND  [LogicalSessionCacheRefresh] command config.system.sessions command: createIndexes { createIndexes: "system.sessions", indexes: [ { key: { lastUse: 1 }, name: "lsidTTLIndex", expireAfterSeconds: 1800 } ], $db: "config" } numYields:0 reslen:114 locks:{ ParallelBatchWriterMode: { acquireCount: { r: 2 } }, ReplicationStateTransition: { acquireCount: { w: 3 } }, Global: { acquireCount: { r: 1, w: 2 } }, Database: { acquireCount: { r: 1, w: 2, W: 1 } }, Collection: { acquireCount: { r: 4, w: 1, R: 1, W: 2 } }, Mutex: { acquireCount: { r: 3 } } } flowControl:{ acquireCount: 1, timeAcquiringMicros: 1 } storage:{} protocol:op_msg 1638ms
spring-server_1  |
spring-server_1  |   .   ____          _            __ _ _
spring-server_1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
spring-server_1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
spring-server_1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
spring-server_1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
spring-server_1  |  =========|_|==============|___/=/_/_/_/
mongodb          | 2020-04-04T21:04:46.405+0000 I  COMMAND  [ftdc] serverStatus was very slow: { after basic: 26, after asserts: 83, after connections: 83, after electionMetrics: 119, after extra_info: 119, after flowControl: 140, after freeMonitoring: 150, after globalLock: 150, after locks: 212, after logicalSessionRecordCache: 240, after network: 240, after opLatencies: 240, after opReadConcernCounters: 240, after opcounters: 240, after opcountersRepl: 240, after oplogTruncation: 451, after repl: 451, after security: 451, after storageEngine: 520, after tcmalloc: 557, after trafficRecording: 557, after transactions: 557, after transportSecurity: 557, after twoPhaseCommitCoordinator: 597, after wiredTiger: 797, at end: 1225 }
spring-server_1  |  :: Spring Boot ::       (v1.5.22.RELEASE)
spring-server_1  |
spring-server_1  | 2020-04-04 21:04:42.892  INFO 1 --- [           main] io.swagger.Swagger2SpringBoot            : Starting Swagger2SpringBoot v1.0.0 on d6751d26630a with PID 1 (/swagger-spring.jar started by root in /)
spring-server_1  | 2020-04-04 21:04:42.948  INFO 1 --- [           main] io.swagger.Swagger2SpringBoot            : No active profile set, falling back to default profiles: default
spring-server_1  | 2020-04-04 21:04:43.754  INFO 1 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@6e5e91e4: startup date [Sat Apr 04 21:04:43 GMT 2020]; root of context hierarchy
spring-server_1  | 2020-04-04 21:05:03.357  INFO 1 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
spring-server_1  | 2020-04-04 21:05:03.885  INFO 1 --- [           main] o.apache.catalina.core.StandardS
```
## Screenshots

![DockerServExcAndLogs](/screenshots/task3dockerServExcAndLogs.PNG)

**Note:** *The docker-compose part is Documented in Task3*

**If run into problem, do not hesitate to comment or connect :smile: !**