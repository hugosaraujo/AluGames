package alugames.modelos

import java.math.BigDecimal

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}