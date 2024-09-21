pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri(System.getenv("MY_MAVEN_REPO_PATH"))
        }
    }
}

rootProject.name = "GreenMinibusRealTimeArrival"
include(":sampleApp")
include(":GreenMinibusRealTimeArrivalData")
