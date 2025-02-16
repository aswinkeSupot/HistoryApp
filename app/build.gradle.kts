plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.aswin.transactionsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aswin.transactionsapp"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("androidx.activity:activity:1.9.5")
    //Shimmer
    implementation ("com.facebook.shimmer:shimmer:0.5.0")

    implementation ("com.timehop.stickyheadersrecyclerview:library:0.4.3")
    implementation ("com.github.smuyyh:StickyHeaderRecyclerView:1.1.0")

//    implementation ("com.yuyang:sticky-headers:1.0.0")

    //Circular Imageview
    implementation ("de.hdodenhof:circleimageview:2.2.0")

    //GLide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")


}