package tools

import model.Carta
import java.io.File
import java.io.InputStream
// Declaração da classe LeitorCartas, que lida com a leitura e distribuição de cartas.
class LeitorCartas() {

    // Propriedade de classe para armazenar as cartas lidas do arquivo CSV fornecidas pelo professor da disciplina.
    companion object {
        private lateinit var cartas: List<Carta>

        // Função privada para ler as linhas do arquivo CSV e retornar como uma lista de strings.

        private fun lerCartasCSV(): List<String> {
            var streamDados: InputStream = File("cartas.csv").inputStream()
            // Verifica se o arquivo "cartas.csv" não está disponível e tenta um caminho alternativo.
            if (streamDados.available() == 0) {
                streamDados = File("SeuJoseBattleCardGame/cartas.csv").inputStream()
            }
            // Inicializa um leitor de stream para ler as linhas do arquivo CSV.
            val leitorStream = streamDados.bufferedReader()

            // Filtra as linhas em branco e retorna como uma lista de strings.
            return leitorStream.lineSequence()
                .filter { it.isNotBlank() }.toList()
        }


        // Função para obter a lista de cartas.
        fun getCartas(): List<Carta> {
            if (!::cartas.isInitialized) {
                // Se a lista de cartas ainda não estiver inicializada, lê o arquivo CSV e mapeia para objetos Carta.
                cartas = lerCartasCSV().map { Carta(it) }
            }
            //Retorna uma replica das cartas para evitar modificações indesejadas
            return cartas.map { it }
        }

        // Função privada para remover uma carta da lista de cartas.
        private fun removeCarta(carta: Carta) {
            cartas = cartas.filter { it.nome != carta.nome }
        }

        // Função pública para distribuir cartas.
        fun distribuirCartas(Baralho: List<Carta>): List<Carta> {
            val cartasDistribuidas = mutableListOf<Carta>()
            for (i in 1..5) {
                // Escolhe aleatoriamente uma carta da lista de cartas disponíveis.
                val carta = cartas.random()
                cartasDistribuidas.add(carta)
                // Remove a carta distribuída da lista de cartas disponíveis.
                removeCarta(carta)
            }
            return cartasDistribuidas
        }

        // Função pública para obter uma carta aleatória da lista de cartas disponíveis.
        fun obterCartaAleatoria(): Carta {
            val cartas = getCartas()
            // Escolhe aleatoriamente uma carta da lista de cartas disponíveis.
            val carta = cartas.random()
            // Remove a carta obtida da lista de cartas disponíveis.
            removeCarta(carta)
            return carta
        }
    }
}