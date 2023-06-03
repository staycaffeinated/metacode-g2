
plugins {
    id 'groovy-gradle-plugin'
}

dependencies {
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:4.1.0.3113")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.19.0")
    implementation("com.netflix.nebula:gradle-lint-plugin:18.0.3")
    implementation("com.google.cloud.tools:jib-gradle-plugin:3.3.2")
    implementation("com.palantir.javaformat:gradle-palantir-java-format:2.32.0")
    implementation("io.freefair.gradle:lombok-plugin:8.0.1")
    implementation(platform("org.example.platform:platform"))
    compileOnly("org.projectlombok:lombok:1.18.28")
}