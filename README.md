# webconsumer

A springboot web interface for a Java app that deliberately consumes resources

## Prerequisites

- Java 17 or above
- Gradle

## Build boot image

**NOTE** Docker needs to be running for this to work

```bash
./gradlew bootBuildImage
```

To test this image, run the command

```bash
docker run -it -p8080:8080 webconsumer:0.0.1-SNAPSHOT
```

**NOTE** the part "0.0.1-SNAPSHOT" may be different check the output of the previous command
