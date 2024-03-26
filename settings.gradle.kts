enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
val authToken: String? by settings
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io")
            credentials {
                // Use authToken here
                username = authToken ?: ""
            }        }

    }
}

rootProject.name = "CorelibKmm"
include(":shared")