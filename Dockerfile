FROM tomcat:8.5-alpine

COPY target/hermes-demo*.war $CATALINA_HOME/webapps/hermes-demo.war
RUN mkdir $CATALINA_HOME/webapps/hermes-demo && unzip $CATALINA_HOME/webapps/hermes-demo.war -d $CATALINA_HOME/webapps/hermes-demo \
    && rm $CATALINA_HOME/webapps/hermes-demo.war

EXPOSE 8080
# HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:8080/hermes-demo/ || exit 1
