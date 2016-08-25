FROM 362112714802.dkr.ecr.us-west-2.amazonaws.com/tomcat8:8.0.33

ENV CATALINA_HOME /usr/local/tomcat8
ENV CATALINA_BASE /opt/servers/reading-tomcat8-8443
ENV PATH ${CATALINA_HOME}/bin:${PATH}

RUN mkdir -p ${CATALINA_BASE}
COPY docker/catalina_base/ ${CATALINA_BASE}/
RUN ls -la ${CATALINA_BASE}/build
RUN ln -s ${CATALINA_BASE}/build/* ${CATALINA_BASE}/webapps/reading.war
WORKDIR ${CATALINA_BASE}

VOLUME ${CATALINA_BASE}

EXPOSE 8443
EXPOSE 8020

CMD ["catalina.sh","run"]
