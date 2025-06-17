plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.springFrameworkBoot)
    alias(libs.plugins.springDependencyManagement)
    alias(libs.plugins.kotlinSpring)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    api(projects.domain.noteDomain)

    implementation(libs.springFrameworkBoot.starterWeb)
    implementation(libs.springFrameworkBoot.starterDataJpa)
    implementation(libs.jackson.module)
    runtimeOnly(libs.postgresql)
}