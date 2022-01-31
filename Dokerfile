FROM openjdk:17-alpine3.12
RUN addgroup -S cake && adduser -S cake -G cake
USER cake:cake
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /cake_app/lib
COPY ${DEPENDENCY}/META-INF /cake_app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /cake_app
ENTRYPOINT ["java","-cp","cake_app:cake_app/lib/*","com.cake.manager.cake.CakeApplication"]