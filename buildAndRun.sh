#!/bin/sh
mvn clean package && docker build -t com.kudasa/ems-users .
docker rm -f ems-users || true && docker run -d -p 8080:8080 -p 4848:4848 --name ems-users com.kudasa/ems-users 
