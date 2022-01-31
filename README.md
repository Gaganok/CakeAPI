# CakeAPI

To run:

mvn spring-boot:run

or use ./build.sh script to build a docker image "cake_api:latest"

./build.sh
docker run -d -p 8282:8282 cake_api

Additional:
1) CakeController behaviour test coverage
2) Spring Security basic configuration to support OAuth2
   To enable OAuth2: provide oauth2 issuer-url inside of application.properties file 
   and uncomment related lines in CakeSecurityConfiguration.class 
