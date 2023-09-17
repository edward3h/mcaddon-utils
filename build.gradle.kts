plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.0.3"
}

version = "0.1"
group = "org.ethelred.mcaddonutils"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("info.picocli:picocli-codegen")
    annotationProcessor("io.micronaut.validation:micronaut-validation-processor")
    implementation("info.picocli:picocli")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.validation:micronaut-validation")
    implementation("jakarta.validation:jakarta.validation-api")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.yaml:snakeyaml")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}


application {
    mainClass.set("org.ethelred.mcaddonutils.McaddonUtilsCommand")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("org.ethelred.mcaddonutils.*")
    }
}



