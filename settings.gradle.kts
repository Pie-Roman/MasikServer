rootProject.name = "MasikServer"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":feature:post-feature")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
    }
}