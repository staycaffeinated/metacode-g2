#!/bin/sh
#

./gradlew :mc-common:jacocoTestReport :mc-common:sonar -Dsonar.projectKey=mc-common
./gradlew :mc-cli:jacocoTestReport :mc-cli:sonar -Dsonar.projectKey=mc-cli
./gradlew :mc-adapter-spring-core:jacocoTestReport :mc-adapter-spring-core:sonar \
      -Dsonar.projectKey=mc-adapter-spring-core
./gradlew :mc-adapter-spring-webmvc:jacocoTestReport :mc-adapter-spring-webmvc:sonar -Dsonar.projectKey=mc-adapter-spring-webmvc
./gradlew :mc-adapter-spring-webflux:jacocoTestReport :mc-adapter-spring-webflux:sonar -Dsonar.projectKey=mc-adapter-spring-webflux
./gradlew :mc-adapter-spring-batch:jacocoTestReport :mc-adapter-spring-batch:sonar -Dsonar.projectKey=mc-adapter-spring-batch
./gradlew :mc-adapter-spring-boot:jacocoTestReport :mc-adapter-spring-boot:sonar -Dsonar.projectKey=mc-adapter-spring-boot

