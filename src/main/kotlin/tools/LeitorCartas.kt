package tools

import model.Carta
import java.io.File
import java.io.InputStream

class LeitorCartas() {

    companion object {
        private lateinit var cartas: List<Carta>

        private fun lerCartasCSV(): List<String> {
            var streamDados: InputStream = File("cartas.csv").inputStream()
            if (streamDados.available() == 0) {
                streamDados = File("SeuJoseBattleCardGame/cartas.csv").inputStream()
            }
            val leitorStream = streamDados.bufferedReader()
            return leitorStream.lineSequence()
                .filter { it.isNotBlank() }.toList()
        }


        fun getCartas(): List<Carta> {
            if (!::cartas.isInitialized) {
                cartas = lerCartasCSV().map { Carta(it) }
            }
            return cartas.map { it }  //retorna uma replica das cartas
        }

        private fun removeCarta(carta: Carta) {
            cartas = cartas.filter { it.nome != carta.nome }
        }

        fun distribuirCartas(Baralho: List<Carta>): List<Carta> {
            val cartasDistribuidas = mutableListOf<Carta>()
            for (i in 1..5) {
                val carta = cartas.random()
                cartasDistribuidas.add(carta)
                removeCarta(carta)
            }
            return cartasDistribuidas
        }

        fun obterCartaAleatoria(): Carta {
            val cartas = getCartas()
            val carta = cartas.random()
            removeCarta(carta)
            return carta
        }
    }
}