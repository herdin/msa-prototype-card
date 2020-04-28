FROM alpine:3.10

RUN apk add openjdk11
RUN mkdir /msa
COPY ./build/libs/MSACard-1.0-SNAPSHOT.jar /msa

CMD ["java", "-jar", "/msa/MSACard-1.0-SNAPSHOT.jar"]