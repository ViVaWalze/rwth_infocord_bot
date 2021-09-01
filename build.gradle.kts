import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    application
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "cc.notabot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://kotlin.bintray.com/kotlinx/")
    maven("https://m2.dv8tion.net/releases/")
}

dependencies {
    testImplementation(kotlin("test-junit"))

    implementation(kotlin("stdlib-jdk8"))

    // Discord
    implementation("net.dv8tion", "JDA", "4.3.0_281") {
        exclude(module = "opus-java")
    }

    // Database
    implementation("org.litote.kmongo:kmongo-async:4.2.7")
    implementation("org.litote.kmongo:kmongo-coroutine:4.2.7")


    // Util
    implementation("io.github.cdimascio", "java-dotenv", "5.2.2")

    implementation("com.webfirmframework", "wffweb", "3.0.17")

    implementation("com.squareup.okhttp3", "okhttp", "5.0.0-alpha.2")

    implementation("org.json", "json", "20210307")

    implementation("commons-cli", "commons-cli", "1.4")

    // Monitoring
    implementation("io.prometheus", "simpleclient", "0.10.0")
    implementation("io.prometheus", "simpleclient_httpserver", "0.10.0")

    implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json", "1.0.0") {
        version {
            strictly("1.0.0")
        }
    }

}

application {
    mainClass.set("rwth_infokord_bot.LauncherKt")
    @Suppress("DEPRECATION")
    mainClassName = application.mainClass.get()
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "14"
}

tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClass
            )
        )
    }
}
