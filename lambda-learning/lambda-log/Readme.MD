This module is about How to print the log in lambda

#### Simple log
* package the module and upload the jar file
* set the handler ```com.fleetup.lambda.handler.HelloHandler::handle```
* save and run Test

#### Lambda log
* dependency
```xml
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-lambda-java-core</artifactId>
    <version>${aws-lambda-java-core.version}</version>
</dependency>
```
* handler code
```java
package com.fleetup.lambda.log.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class LambdaLogHandler {
    public void handle(Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Lambda log");
    }
}
```

**Note:**
    if you look at the default implementation of the lambda log, you known that you need to enter a newline character yourself
    
Lambda log implementation code in ```com.amazonaws.services.lambda.runtime.LambdaRuntime```    
```java
public void log(String message) {
    System.out.print(message);
}

public void log(byte[] message) {
    try {
        System.out.write(message);
    } catch (IOException var3) {
        var3.printStackTrace();
    }

}
```

#### Lambda with log4j
* dependency
```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>${log4j-api.version}</version>
</dependency>

<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>${log4j-core.version}</version>
</dependency>

<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-lambda-java-log4j2</artifactId>
    <version>${aws-lambda-java-log4j2.version}</version>
</dependency>
```

* add log4j2.xml in resource folder
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration packages="com.amazonaws.services.lambda.runtime.log4j2">
  <Appenders>
    <Lambda name="Lambda">
      <PatternLayout>
          <pattern>%d{yyyy-MM-dd HH:mm:ss} %X{AWSRequestId} %-5p %c{1}:%L - %m%n</pattern>
      </PatternLayout>
    </Lambda>
  </Appenders>
  <Loggers>
    <Root level="info">
      <AppenderRef ref="Lambda" />
    </Root>
  </Loggers>
</Configuration>
```

* and then you can use log like this
```java
static final Logger logger = LogManager.getLogger(Log4jHandler.class);

logger.info("log something")
```