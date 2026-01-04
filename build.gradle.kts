plugins {
    id("java")
    kotlin("jvm") version "2.2.0"
}

group = "harkhorning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("uk.co.electronstudio.jaylib:jaylib:5.5.+")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    testImplementation(kotlin('test'))
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:null")
}

tasks.test {
    useJUnitPlatform()
}
//kotlin {
//    jvmToolchain(25)
//}

//java {
//    toolchain {
//        languageVersion.set(JavaLanguageVersion.of(25))
//    }
//}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
// Or shorter:
    jvmToolchain(25)
// For example:
    jvmToolchain(17)
}

