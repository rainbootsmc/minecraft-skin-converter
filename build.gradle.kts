plugins {
    kotlin("jvm") version "1.8.0"
    `maven-publish`
}

group = "dev.uten2c"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.soywiz.korlibs.korim:korim-jvm:2.2.0")
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("main") {
            from(components["java"])
        }
    }
}
