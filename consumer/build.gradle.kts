plugins {
    id("org.example.caching-gemfire.common-conventions")
}

dependencies {
    implementation(libs.org.springframework.geode.spring.geode.starter)
    implementation(libs.org.projectlombok.lombok)
    runtimeOnly(libs.javax.cache.cache.api)
    runtimeOnly(libs.org.springframework.shell.spring.shell)
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.geode:spring-geode-bom:1.6.3")
    }
}
