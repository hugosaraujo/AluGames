package alugames.modelos

import java.time.LocalDate
import java.time.Period

data class Periodo(val dataInicial: LocalDate, val dataDevolucao: LocalDate){
    val emDias = Period.between(dataInicial, dataDevolucao).days
}
