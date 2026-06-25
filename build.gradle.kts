plugins {
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

// إذا كان عبارة عن ملف سكريبت مخصص في مشروعك (مثلاً detekt-config.gradle.kts)
// apply(from = "detekt-config.gradle.kts") 

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.dokkaHtmlMultiModule.configure {
    outputDirectory.set(rootDir.resolve("docs/api"))
}
