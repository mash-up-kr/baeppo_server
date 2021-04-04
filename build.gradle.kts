import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val springVersion = "2.4.4"
    val kotlinVersion = "1.4.31"
    id("org.springframework.boot") version springVersion
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion
}

group = "com.baeppo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.mariadb.jdbc:mariadb-java-client")
    implementation("org.modelmapper:modelmapper:2.0.0")
    implementation(group = "org.springframework.cloud", name = "spring-cloud-aws-context", version = "2.2.1.RELEASE")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-configuration-processor")

    //queryDSL
    implementation("com.querydsl:querydsl-jpa:4.4.0")
    kapt("com.querydsl:querydsl-apt:4.4.0:jpa")

    // test
    testImplementation("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
