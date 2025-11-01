plugins {
    java
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.chousik"
version = "0.0.1-SNAPSHOT"
description = "mts-test-task"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register<Jar>("fooHeaderAutoConfigJar") {
    group = "build"
    dependsOn(tasks.named("classes"))
    from(sourceSets.main.get().output)
    exclude("ru/chousik/mts/controller")
    archiveClassifier.set("fooHeaderAutoConfig")
}
