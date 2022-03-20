plugins {
    id("org.example.caching-gemfire.common-conventions")
}

dependencies {
    implementation(libs.org.springframework.boot.spring.boot.starter.web)
    implementation(libs.com.fasterxml.jackson.module.jackson.module.kotlin)
}
