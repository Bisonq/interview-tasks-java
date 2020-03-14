plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("junit:junit:4.13")
    testImplementation("org.assertj:assertj-core:3.15.0")
}
