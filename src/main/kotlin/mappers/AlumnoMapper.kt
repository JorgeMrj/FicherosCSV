package jorgemrj.mappers

import jorgemrj.models.Alumno
import jorgemrj.models.AlumnoDto
import java.time.LocalDateTime

class AlumnoMapper {
    fun Alumno.toDto() = AlumnoDto(
        id = id,
        nombre = nombre,
        createdAt = createdAt.toString(),
        tipo = tipo.toString(),
        edad = edad,
    )

    fun AlumnoDto.toModel() = Alumno(
        id = id,
        nombre = nombre,
        createdAt = LocalDateTime.parse(createdAt),
        tipo = Alumno.Tipo.valueOf(tipo),
        edad = edad,
    )
}