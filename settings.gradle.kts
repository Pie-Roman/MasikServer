rootProject.name = "MasikServer"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":domain:note-domain")

include(":data:note-data")

include(":feature:post-feature")
include(":feature:note-feature")

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