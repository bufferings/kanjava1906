# kanjava1906

This is a demo code repository for KanJava1906.

My presentation slide is here:
TBD

## demo

A demo app will be pushed after my live coding is finished.

## mydb

```sh
# Start PostgreSQL
docker-compose up

# Then you can start mydb app
gradle run

# or
gradle build
java -jar build/libs/mydb-0.1.jar
```

## gatling

To check the difference of Threads of Blocking & Reactive.

```sh
# Check Blocking Endpoint
mvn gatling:test -DTARGET_URL=http://localhost:8080/hello/b/bufferings -DSIM_USERS=3000

# Check Reactive Endpoint
mvn gatling:test -DTARGET_URL=http://localhost:8080/hello/r/bufferings -DSIM_USERS=3000
```


