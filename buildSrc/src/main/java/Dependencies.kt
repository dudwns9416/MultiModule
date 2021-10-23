import org.gradle.api.artifacts.dsl.DependencyHandler

object Version {
    const val retrofit = "2.9.0"
    const val hilt = "2.39.1"
    const val coroutine = "1.5.2"
}

object Hilt {
    val android = "com.google.dagger:hilt-android:${Version.hilt}"
    val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
}

object Coroutine {
    val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
    val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
}

fun DependencyHandler.androidx() {
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("androidx.fragment:fragment-ktx:1.3.6")
}

fun DependencyHandler.hilt() {
    implementation(Hilt.android)
    kapt(Hilt.compiler)
}

fun DependencyHandler.coroutine() {
    implementation(Coroutine.core)
    implementation(Coroutine.android)
}

fun DependencyHandler.network() {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
}

fun DependencyHandler.test() {
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

fun DependencyHandler.implementation(dependencyNotation: String) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.testImplementation(dependencyNotation: String) {
    add("testImplementation", dependencyNotation)
}

fun DependencyHandler.androidTestImplementation(dependencyNotation: String) {
    add("androidTestImplementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: String) {
    add("kapt", dependencyNotation)
}