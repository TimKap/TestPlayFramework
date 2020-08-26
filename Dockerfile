FROM base:auto
ARG APP=myApp
ARG APP_SOURCE=target/universal/stage
ENV APP_ROOT=/opt/$APP \
    APP_LOG=/var/log/$APP
WORKDIR $APP_ROOT
COPY $APP_SOURCE $APP_ROOT
EXPOSE 9443 9010 9020
ENTRYPOINT [ "/opt/myApp/bin/myapp",\
             "-XX:+UseContainerSupport", \
             "-XX:MaxRAMPercentage=90.0", \
             "-J-Xdebug", \
             "-J-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=*:9020", \
             "-J-XshowSettings:vm", \
             "-Dpidfile.path=/dev/null",\
             "-Dhttp.port=disabled",\
             "-Dhttps.port=9443", \
              "-Dcom.sun.management.jmxremote=true", \
              "-Dcom.sun.management.jmxremote.local.only=false", \
              "-Dcom.sun.management.jmxremote.authenticate=false", \
              "-Dcom.sun.management.jmxremote.ssl=false", \
              "-Djava.rmi.server.hostname=localhost", \
              "-Dcom.sun.management.jmxremote.port=9010", \
              "-Dcom.sun.management.jmxremote.rmi.port=9010" \
             ]
