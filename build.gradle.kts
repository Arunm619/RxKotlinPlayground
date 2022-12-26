import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    application
}

group = "io.arunbuilds"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("com.netflix.rxjava:rxjava-apache-http:0.20.7")
    testImplementation("org.testng:testng:7.1.0")
    compileOnly("junit:junit:4.12")
    compileOnly("org.mockito:mockito-core:1.9.5")
    compileOnly("org.jetbrains.kotlin:kotlin-test-junit:1.6.21")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}