rootProject.name = "Dialer"
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://nexus.m1k.cloud/repository/maven-releases/") }
        maven { setUrl("https://nexus.m1k.cloud/repository/maven-snapshots/") }
    }
}
include(":app")
