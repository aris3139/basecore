buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.3")
    }
}

plugins {
    id("com.google.devtools.ksp") version "1.9.22-1.0.16" apply false
}