package jorgemrj.models

import java.time.LocalDateTime

data class Alumno(
    val id: Long,
    val nombre: String,
    val createdAt: LocalDateTime,
    val tipo: Tipo,
    val edad: Int,
)
{
    enum class Tipo {
        ALUMNO, PROFESOR
    }
}
