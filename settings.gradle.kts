@file:Suppress("UnstableApiUsage")

rootProject.name = "caching-gemfire"
include("consumer")
include("provider")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
