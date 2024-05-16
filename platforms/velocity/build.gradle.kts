plugins {
    kotlin("jvm") version("1.9.24")
    id("xyz.jpenilla.run-velocity") version ("2.3.0")
}

val pluginVersion: String by project
val velocityVersion: String by project

repositories {
    maven {
        name = "papermc"
        setUrl("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    api(project(":commons"))
    compileOnly("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")

    implementation(kotlin("stdlib"))

}

base {
    archivesName = rootProject.name + ".velocity"
}

tasks.processResources {
    val properties = mapOf(
        "version" to pluginVersion,
    )
    inputs.properties(properties)
    filesMatching("velocity-plugin.json") {
        expand(properties)
    }
}

tasks.runVelocity {
    velocityVersion(velocityVersion)
}

tasks.create("generateTemplates") {}
