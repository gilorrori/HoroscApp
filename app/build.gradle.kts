plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.safe.args)
}

android {
    namespace = "com.gilorroristore.horoscapplication"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.gilorroristore.horoscapplication"
        minSdk = 24
        targetSdk = 36
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
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)


    //NavComponent
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    //Dagger Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.runner)
    kapt(libs.hilt.android.compiler)

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.interceptor)

    //Camera X
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.extensions)

    //UITesting
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.espresso.contrib)
    androidTestImplementation (libs.androidx.espresso.intents)
    androidTestImplementation (libs.hilt.android.testing)
    androidTestImplementation (libs.androidx.fragment.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    kapt(libs.hilt.compiler)

    //UnitTesting
    testImplementation (libs.kotlintest.runner.junit5)
    testImplementation (libs.mockk)
}