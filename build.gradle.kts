plugins {
    kotlin("jvm") version "2.3.21"
    id("com.gradleup.shadow") version "9.4.3"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

val paperVersion = "26.1.2.build.+"

dependencies {
    compileOnly("io.papermc.paper:paper-api:$paperVersion")
}

kotlin {
    jvmToolchain(25)
}

tasks {
    shadowJar {
        archiveFileName.set("bvzElytraSwapBlocker-v${project.version}.jar")
    }

    build {
        dependsOn(shadowJar)
    }

    processResources {
        val props = mapOf(
            "version" to version
        )
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}