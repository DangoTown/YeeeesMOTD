val pluginVersion: String by project

base {
    archivesName = rootProject.name + ".bungeecord"
}

dependencies {
    api(project(":core"))
    compileOnly(libs.bungeecord)
    implementation(libs.adventure)
}

tasks.processResources {
    val properties = mapOf(
        "version" to pluginVersion,
        "description" to "返回个性化的MOTD"
    )
    inputs.properties(properties)
    filteringCharset = "UTF-8"
    filesMatching("bungee.yml") {
        expand(properties)
    }
}
