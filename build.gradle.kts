plugins {
    java
    id("com.diffplug.spotless") version "8.0.0"
    id("com.github.ben-manes.versions") version "0.53.0"
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
    // Align JUnit artifacts
    testImplementation(platform("org.junit:junit-bom:5.10.2"))

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    // Ensure JUnit Platform launcher is available on the test runtime classpath
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")

    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    testImplementation("io.rest-assured:rest-assured:5.5.6")
    testImplementation("org.hamcrest:hamcrest:3.0")
    testImplementation("org.assertj:assertj-core:3.26.3")
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
    useJUnitPlatform()
}
