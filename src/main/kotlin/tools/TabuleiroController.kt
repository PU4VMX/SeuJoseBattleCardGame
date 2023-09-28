package tools

import model.Monstro
import model.Player
import model.Tabuleiro

class TabuleiroController {
    companion object {
        fun createTabuleiro(player1: Player, monstro: Monstro): Tabuleiro {
            MonstroController.setModo(monstro).modo.also { monstro.modo = it }
            return Tabuleiro(player1, monstro)
        }

        fun posicionarMonstro(tabuleiro: Tabuleiro, monstro: Monstro) {
            if (tabuleiro.monstro.size < 5) {
                MonstroController.setModo(monstro).modo.also { monstro.modo = it }
                tabuleiro.monstro.plus(monstro)
            } else {
                println("Não é possível posicionar mais monstros no tabuleiro")
            //    println
            }
        }
    }
}