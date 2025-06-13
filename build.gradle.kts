plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.springFrameworkBoot)
    alias(libs.plugins.springDependencyManagement)
    alias(libs.plugins.kotlinSpring)
}

group = "ru.pyroman.masik"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(libs.springFrameworkBoot.starterWeb)
    implementation(libs.springFrameworkBoot.starterWebFlux)
}

kotlin {
    jvmToolchain(21)
}