package com.stark.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.AbstractEnvironment

@SpringBootApplication
class KotlinIntroApplication

fun main(args: Array<String>) {
	setupEnv()
	runApplication<KotlinIntroApplication>(*args)
}

private fun setupEnv() {
	System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, getCurrentProfile())
}

private fun getCurrentProfile(): String {
	val scope = System.getenv("SCOPE") ?: "development"
	return when {
		scope.contains("stage", true) -> "stage"
		scope.contains("production", true) -> "production"
		else -> "development"
	}
}
