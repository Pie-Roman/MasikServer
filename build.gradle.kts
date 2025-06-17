import org.springframework.boot.gradle.tasks.bundling.BootJar

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
    implementation(libs.springFrameworkBoot.starterDataJpa)

    implementation(projects.feature.postFeature)
    implementation(projects.feature.noteFeature)
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<BootJar> {
    archiveFileName.set("masik.jar")
}