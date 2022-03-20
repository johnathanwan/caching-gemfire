plugins {
    `kotlin-dsl`
}

dependencies {
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        implementation("org.jetbrains.kotlin.plugin.spring:org.jetbrains.kotlin.plugin.spring.gradle.plugin:1.5.20-RC")
        implementation("org.springframework.boot:spring-boot-gradle-plugin:2.6.4")
        implementation("io.spring.dependency-management:io.spring.dependency-management.gradle.plugin:1.0.11.RELEASE")
    }
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("org.jetbrains.kotlin.plugin.spring:org.jetbrains.kotlin.plugin.spring.gradle.plugin")
    implementation("org.springframework.boot:spring-boot-gradle-plugin")
    implementation("io.spring.dependency-management:io.spring.dependency-management.gradle.plugin")
}
