plugins {
    java
    id("com.diffplug.spotless") version "6.25.0"
    id("com.github.ben-manes.versions") version "0.52.0"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    testImplementation("io.rest-assured:rest-assured:5.5.1")
    testImplementation("org.hamcrest:hamcrest:3.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.1")
    testImplementation("org.assertj:assertj-core:3.27.3")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.12.1")
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
