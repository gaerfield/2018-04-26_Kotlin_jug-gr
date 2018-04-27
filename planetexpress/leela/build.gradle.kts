plugins {
    kotlin("jvm")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(project(":ship"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.22.5")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:0.22.5")
}

