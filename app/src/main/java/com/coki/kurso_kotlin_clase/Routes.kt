package com.coki.kurso_kotlin_clase

sealed class Routes(val route: String) {



//    object Login : Routes("Login")
    object Home : Routes("Home")
    object Login : Routes("Login")
//    object Kotlin : Routes("Kotlin/{parteCurso}") {
//        fun createRoute(parteCurso: String) = "Kotlin/$parteCurso"
//    }
//    object Jetpack : Routes("Jetpack/{parteCurso}") {
//        fun createRoute(parteCurso: String) = "Jetpack/$parteCurso"
//    }
//    object EjercicioPoo : Routes("EjercicioPoo")
//    object EjercicioRutinas : Routes("EjercicioRutinas")
//    object ApiScreen : Routes("ApiScreen")
//    object RoomCrud : Routes("RoomCrud")
//    object PokeApi : Routes("PokeApi")
//    object SharedPreferences : Routes("SharedPreferences")
}