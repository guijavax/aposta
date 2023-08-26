import org.jetbrains.kotlin.gradle.tasks.KotlinCompile



plugins {
	val versionDefault = "1.8.22"

	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	kotlin("jvm") version versionDefault
	kotlin("plugin.spring") version versionDefault
	kotlin("plugin.jpa") version versionDefault
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}
val versionAws = "1.12.533"
dependencies {
	implementation ("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.security:spring-security-oauth2-jose")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation ("org.jetbrains.kotlin:kotlin-reflect")

	implementation("com.amazonaws:aws-java-sdk-s3:$versionAws")
	implementation("com.amazonaws:aws-java-sdk-core:$versionAws")
	implementation("com.amazonaws:aws-java-sdk-cognitoidp:$versionAws")

	runtimeOnly("com.h2database:h2:2.2.220")

	testImplementation ("org.springframework.boot:spring-boot-starter-test")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
