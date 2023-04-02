FROM amazoncorretto:17

COPY ./host/demo /demo

WORKDIR /demo

RUN echo `pwd`
RUN echo `ls`
RUN ./gradlew build
RUN echo `ls`
