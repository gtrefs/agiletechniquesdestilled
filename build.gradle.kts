plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.20")
    `java-library`
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.vavr:vavr:0.10.0")
    testImplementation("com.natpryce:hamkrest:1.7.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")

}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
