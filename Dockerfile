FROM openjdk:8u191-jre-alpine3.8

#intalling curl and jq
RUN apk add curl jq

#workspace
WORKDIR usr/docker

#Add .jar file to the image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

#Add files
ADD src/test/resources/dataproviders	src/test/resources/dataproviders

#Add suite files
ADD SignUpTestSuite.xml SignUpTestSuite.xml
ADD NegativeLogInTests.xml NegativeLogInTests.xml
ADD ValidateItemsFromShopingCartTests.xml ValidateItemsFromShopingCartTests.xml 

#Add api call to check the hub
ADD CheckingHub.sh CheckingHub.sh

ENTRYPOINT sh CheckingHub.sh