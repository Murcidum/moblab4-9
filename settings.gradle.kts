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
    }
}

rootProject.name = "My Application"
include(":app")
include(":app:lab4")
include(":app:lab4:bd")
include(":app:lab4:pr")
include(":app:lab4:q")
include(":app:lab5")
include(":app:lab5:lemonade")
include(":app:lab5:diceroller")
include(":app:lab5:calc")
include(":app:lab5:gal")
