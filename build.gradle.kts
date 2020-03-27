import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    eclipse
    idea
    id("com.diffplug.gradle.spotless") version "3.27.1"
    id("com.github.ben-manes.versions") version "0.27.0"
}

repositories {
    jcenter()
}

dependencies {

    testImplementation("io.rest-assured:rest-assured:4.3.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.1")
    testImplementation("org.mockito:mockito-junit-jupiter:3.3.3")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
    }
}
