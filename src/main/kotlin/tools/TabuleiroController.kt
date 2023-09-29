package tools

import model.Monstro
import model.Player
import model.Tabuleiro
import java.util.*

class TabuleiroController {
    companion object {
        fun createTabuleiro(player1: Player, monstro: Monstro): Tabuleiro {
            MonstroController.setModo(monstro).modo.also { monstro.modo = it }
            return Tabuleiro(player1, monstro)
        }
    }
}