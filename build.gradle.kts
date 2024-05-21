plugins {
    java
    id("com.diffplug.spotless") version "6.25.0"
    id("com.github.ben-manes.versions") version "0.51.0"
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
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.assertj:assertj-core:3.25.3")

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

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
