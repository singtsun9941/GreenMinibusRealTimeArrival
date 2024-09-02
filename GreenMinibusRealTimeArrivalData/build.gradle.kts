plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("com.stwcoding.networkmodule:ktorhelper:1.0.0")
    implementation("io.ktor:ktor-client-okhttp:2.3.12")
}