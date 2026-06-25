plugins {
    id("com.android.library")
    `maven-publish`
    id("kotlin-kapt")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 21
    }

    // أخبر Gradle بتجهيز نسخة الـ release للنشر مع الكود المصدر (Sources) والـ Javadoc
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

// إعداد النشر لـ JitPack
afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                
                groupId = "com.github.ar-telmid"
                artifactId = "okdownloader"
                version = "1.0.0" 
            }
        }
    }
}

dependencies {
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.android.test.junit.ext)
    androidTestImplementation(libs.android.test.espresso)
    
    api(libs.okhttp)
    implementation(libs.commons.codec)
    implementation(libs.okio)
    implementation(libs.room.runtime)
    this.kapt(libs.room.compiler)
}