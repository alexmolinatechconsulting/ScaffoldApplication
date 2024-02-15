import java.util.Properties

var properties = Properties()
var baseUrl : String = ""
var baseImageUrl : String = ""
var endpointMovie : String = ""
var apiKey : String = ""
var bearerToken : String = ""

if (File("local.properties").exists()) {
    properties = Properties().apply { load(project.rootProject.file("local.properties").inputStream()) }
    baseUrl = properties.getProperty("BASE_URL")
    baseImageUrl = properties.getProperty("BASE_IMAGE_URL")
    endpointMovie = properties.getProperty("ENDPOINT_MOVIE")
    apiKey = properties.getProperty("API_KEY")
    bearerToken = properties.getProperty("BEARER_TOKEN")
}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.scaffoldapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.scaffoldapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    buildTypes {
        debug{
            buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
            buildConfigField("String", "BASE_IMAGE_URL", "\"$baseImageUrl\"")
            buildConfigField("String", "ENDPOINT_MOVIE", "\"$endpointMovie\"")
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
            buildConfigField("String", "BEARER_TOKEN", "\"$bearerToken\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
            buildConfigField("String", "BASE_IMAGE_URL", "\"$baseImageUrl\"")
            buildConfigField("String", "ENDPOINT_MOVIE", "\"$endpointMovie\"")
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
            buildConfigField("String", "BEARER_TOKEN", "\"$bearerToken\"")
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.material:material:1.6.1")

    val bomPlatform = platform("androidx.compose:compose-bom:2023.10.01")
    implementation(bomPlatform)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")
    implementation("androidx.navigation:navigation-compose:2.7.6")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.4.0")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation(bomPlatform)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("io.insert-koin:koin-android:3.5.3")
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
}