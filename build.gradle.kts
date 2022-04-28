import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    eclipse
    idea
    id("com.diffplug.spotless") version "6.5.0"
    id("com.github.ben-manes.versions") version "0.42.0"
}

repositories {
    jcenter()
}

dependencies {

    testImplementation("io.rest-assured:rest-assured:5.0.1")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.assertj:assertj-core:3.22.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
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
