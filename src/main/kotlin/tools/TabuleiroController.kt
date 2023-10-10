package tools

import model.Monstro
import model.Player
import model.Tabuleiro
import java.util.*

// Classe que fornece funcionalidades relacionadas à criação de tabuleiros.
class TabuleiroController {
    companion object {
        // Função pública para criar um tabuleiro com um jogador e um monstro inicial.
        fun createTabuleiro(player1: Player, monstro: Monstro): Tabuleiro {
            // Define o modo (ataque ou defesa) do monstro inicial.
            MonstroController.setModo(monstro).modo.also { monstro.modo = it }
            // Retorna um novo tabuleiro com o jogador 1 e o monstro inicial.
            return Tabuleiro(player1, monstro)
        }
    }
}