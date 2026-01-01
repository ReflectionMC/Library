plugins {
    id("java")
    id("maven-publish")
    id("com.gradleup.shadow") version "8.3.5"
}

group = "im.ghosty.reflection"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21.11-R0.1-SNAPSHOT")
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }

    repositories {
        if (project.hasProperty("deployRepoPath")) {
            maven {
                name = "deploy"
                url = uri(project.property("deployRepoPath") as String)
            }
        } else {
            mavenLocal()
        }
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    assemble {
        dependsOn(shadowJar)
    }

    shadowJar {
        archiveClassifier.set("")
    }

    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }
}