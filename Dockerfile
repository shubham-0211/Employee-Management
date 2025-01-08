FROM tomcat:latest
MAINTAINER Shubham Ghongade<shubhamghongade199@gmail.com>
EXPOSE 8080
COPY employee-management-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps