plugins {
    id("java")
}

group = "vn.fx.qh.sapo.entity"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor ("org.projectlombok:lombok:1.18.24")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.4")
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.5")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa:2.7.5")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}