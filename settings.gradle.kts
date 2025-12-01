pluginManagement {
    repositories {
        maven {
            url = uri("https://appmaven.iwhalecloud.com/repository/maven-public/")
            isAllowInsecureProtocol = true
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://appmaven.iwhalecloud.com/repository/maven-public/")
            isAllowInsecureProtocol = true
        }
    }
}

rootProject.name = "ComposeKotlinStudy"
include(":app")
 