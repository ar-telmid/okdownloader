plugins {
    `maven-publish`
    id("org.jetbrains.dokka") version "1.9.0" 
}

tasks.dokkaHtmlMultiModule.configure {
    outputDirectory.set(rootDir.resolve("docs/api"))
}
