package jorgemrj.models

import jorgemrj.models.Alumno.Tipo
import java.time.LocalDateTime

data class AlumnoDto(
    val id: Long,
    val nombre: String,
    val createdAt: String,
    val tipo: String,
    val edad: Int,
)

