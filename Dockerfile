FROM alpine:3.3
ARG VERSION=8.92.14-r0
ENV MAJOR=8


RUN apk update --purge \
&& apk add curl \
&& apk add unzip=6.0-r1 \
&& apk add openjdk8-jre-base=8.92.14-r0


RUN curl -s -k -L -C - -b "oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jce/${MAJOR}/jce_policy-${MAJOR}.zip > /tmp/jce_policy-${MAJOR}.zip \
&& unzip -d /tmp/ /tmp/jce_policy-${MAJOR}.zip \
&& rm -vf /usr/lib/jvm/java-1.${MAJOR}-openjdk/jre/lib/security/*.jar \
&& cp -vf /tmp/UnlimitedJCEPolicyJDK${MAJOR}/*.jar /usr/lib/jvm/java-1.${MAJOR}-openjdk/jre/lib/security \
&& rm -rf /tmp/*


RUN apk del --force --purge unzip \
&& apk del --force --purge curl

# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk

EXPOSE 8080
ADD target/*SNAPSHOT.jar /data/bookstore.jar
CMD java -jar bookstore.jar
