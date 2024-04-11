plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "rs.ac.ecommerceapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "rs.ac.ecommerceapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        //sourceCompatibility = JavaVersion.VERSION_11
        //    targetCompatibility = JavaVersion.VERSION_11
    }
}


    dependencies {
        implementation ("androidx.appcompat:appcompat:1.6.1")
        implementation ("com.google.android.material:material:1.11.0")
        implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation ("com.google.firebase:firebase-auth:22.3.0")
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.0")
        implementation("com.android.tools:desugar_jdk_libs:1.1.5")
        // Jackson Databind sa Kotlin podrškom
        implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.3")
        implementation ("org.jsoup:jsoup:1.14.3")
        implementation ("com.fasterxml.jackson.core:jackson-databind:2.12.4")
        implementation ("com.squareup.picasso:picasso:2.8")

        testImplementation ("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    }

