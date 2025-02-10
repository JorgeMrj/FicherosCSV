package jorgemrj

import jorgemrj.models.Alumno
import jorgemrj.models.AlumnoDto
import java.io.File
import jorgemrj.mappers.AlumnoMapper

fun main() {
    val file = File("data", "alumnos.csv")
    if (file.exists()) {
        println("El fichero existe")
    } else {
        throw IllegalArgumentException("El fichero no existe")
    }

    val alumnos = file.readLines().drop(1)
        .map {  it.split(',') }
        .map { item ->
            AlumnoDto(
                id = item[0].toLong(),
                nombre = item[1],
                createdAt = item[2],
                tipo = item[3],
                edad = item[4].toInt()

            )
        }
    alumnos.forEach { println(it)}


// Alumno más joven
    val alumnoMasJoven = alumnos.minByOrNull { it.edad }
    println("Alumno más joven: ${alumnoMasJoven?.nombre}")

// Media de edad de alumnos
    val mediaEdad = alumnos.map { it.edad }.average()
    println("Media de edad de alumnos: $mediaEdad")

// Media de longitud de nombre
    val mediaLongitudNombre = alumnos.map { it.nombre.length }.average()
    println("Media de longitud de nombre: $mediaLongitudNombre")

// Listado de agrupados por edad
    val agrupadosPorEdad = alumnos.groupBy { it.edad }
    println("Listado de agrupados por edad: $agrupadosPorEdad")

// Agrupados por edad, número de alumnos
    val numeroAlumnosPorEdad = alumnos.groupingBy { it.edad }.eachCount()
    println("Agrupados por edad, número de alumnos: $numeroAlumnosPorEdad")

// Agrupados por edad, obtener la longitud de nombre
    val longitudNombresPorEdad = alumnos.groupBy { it.edad }
        .mapValues { entry -> entry.value.map { it.nombre.length } }
    println("Agrupados por edad, obtener la longitud de nombre: $longitudNombresPorEdad")

// Agrupados por edad, obtener el nombre más largo
    val nombreMasLargoPorEdad = alumnos.groupBy { it.edad }
        .mapValues { entry -> entry.value.maxByOrNull { it.nombre.length }?.nombre }
    println("Agrupados por edad, obtener el nombre más largo: $nombreMasLargoPorEdad")

}