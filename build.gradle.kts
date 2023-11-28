import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    id("com.diffplug.spotless") version "6.23.0"
    id("com.github.ben-manes.versions") version "0.50.0"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    testImplementation("io.rest-assured:rest-assured:5.3.2")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.assertj:assertj-core:3.24.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
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
