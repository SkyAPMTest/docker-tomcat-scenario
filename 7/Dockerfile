FROM tomcat:7

# routing server ips
ENV SERVER_LIST 127.0.0.1:34000
# for jpda
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

# agent jar file
RUN mkdir /usr/local/agent
#
ADD tomcat-scenario.war /usr/local/tomcat/webapps
#
COPY catalina.sh /usr/local/tomcat/bin

VOLUME /usr/local/agent

EXPOSE 8080 8000
ENTRYPOINT ["catalina.sh", "jpda", "run"]
