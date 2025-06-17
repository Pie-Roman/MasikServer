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
    implementation(libs.springFrameworkBoot.starterWeb)
    implementation(libs.springFrameworkBoot.starterWebFlux)
}