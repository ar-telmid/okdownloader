plugins {
    id("com.android.library")
    `maven-publish`
    id("kotlin-kapt") // تأكد من وجود هذا الـ plugin لأنك تستخدم kapt مع Room
    // أي plugins أخرى تستخدمها...
}

android {
    compileSdk = 34 // أو الإصدار الذي تستخدمه

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
    // الاعتمادات الخاصة بك كما هي دون تغيير
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.android.test.junit.ext)
    androidTestImplementation(libs.android.test.espresso)
    
    api(libs.okhttp)
    implementation(libs.commons.codec)
    implementation(libs.okio)
    implementation(libs.room.runtime)
    kapt(libs.room.compiler.get())
}