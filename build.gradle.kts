plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
    id("maven-publish")

}
buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4") // Use the appropriate version
    }
}