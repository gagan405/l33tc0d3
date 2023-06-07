import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
}

group = "in.minbox"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("script-runtime"))
    implementation("in.minbox:KStringUtils:1.0-SNAPSHOT")
    testImplementation("junit:junit:4.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "17"
}
