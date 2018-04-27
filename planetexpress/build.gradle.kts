buildscript {
    repositories { mavenCentral() }
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
    }
}

plugins {
    base
    kotlin("jvm") version "1.2.31" apply false
}

allprojects {
    group = "de.kramhal.kotlindemo"
    version = "1.0"
    repositories { mavenCentral() }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.junit.platform.gradle.plugin")

    dependencies {
        "testCompile"("org.junit.jupiter:junit-jupiter-api:5.0.1")
        "testCompile"("org.junit.jupiter:junit-jupiter-params:5.0.1")
        "testRuntime"("org.junit.jupiter:junit-jupiter-engine:5.0.1")
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}
