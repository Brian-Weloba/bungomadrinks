FROM openjdk:latest
COPY target/web-0.0.1-SNAPSHOT.jar web-0.0.1-SNAPSHOT.jar
#CMD ["sh", "-c", "java -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /web-0.0.1-SNAPSHOT.jar"]
# use this instead and comment out the line above to build for linode
EXPOSE 8081
ENTRYPOINT ["java","-jar","/web-0.0.1-SNAPSHOT.jar"]
