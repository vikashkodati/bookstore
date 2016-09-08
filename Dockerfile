FROM dockerfile/java:oracle-java7
MAINTAINER abhinav.akey@gmail.com
EXPOSE 8080
ADD target/*SNAPSHOT.jar /data/bookstore.jar
CMD java -jar bookstore.jar
