package tools

import model.*

class RodadaController {
    /*
    * Ações
    * a) Posicionar um novo monstro no tabuleiro
    * b) Equipar um monstro com uma carta de equipamento
    * c) Descartar uma carta da mão
    * d) Realizar um ataque contra o oponente
    * e) Alterar o estado de um monstro (ataque/defesa)
    * */

    companion object {
        fun executarAcao(tabuleiroA: Tabuleiro, tabuleiroB: Tabuleiro) {
            println("${tabuleiroA.player.nome} - Pts: ${tabuleiroA.player.pontos} - Escolha uma ação:")
            println("a) Posicionar um novo monstro no tabuleiro")
            println("b) Equipar um monstro com uma carta de equipamento")
            println("c) Descartar uma carta da mão")
            println("d) Realizar um ataque contra o oponente")
            println("e) Alterar o estado de um monstro (ataque/defesa)")

            val acao = readln()

            when (acao) {
                "a" -> posicionarMonstro(tabuleiroA, PlayerController.getMonstro(tabuleiroA.player))
                "b" -> equiparMonstro(tabuleiroA,PlayerController.getEquipamento(tabuleiroA.player))
                "c" -> descartarCarta(tabuleiroA.player, PlayerController.getCarta(tabuleiroA.player))
                "d" -> atacar(tabuleiroA.player, tabuleiroB.player)
                "e" -> alterarEstado(tabuleiroA.monstro[0])
                else -> {
                    println("Ação inválida, escolha outra ação")
                    executarAcao(tabuleiroA, tabuleiroB)
                }
            }
        }

        private fun equiparMonstro(tabuleiro: Tabuleiro, equipamento: Equipamento) {
            if (tabuleiro.monstro.size > 0) {
                println("${tabuleiro.player.nome} - Escolha um monstro para equipar: ")
                tabuleiro.monstro.forEachIndexed { index, monstro ->
                    println("$index - ${monstro.nome} - ${monstro.descricao} - ${monstro.ataque} - ${monstro.defesa}")
                }
                val index = readln().toInt()
                if (index > tabuleiro.monstro.size) {
                    println("Monstro não existe, escolha outro monstro")
                    equiparMonstro(tabuleiro, equipamento)
                }
                tabuleiro.monstro[index].let {
                    tabuleiro.monstro[index].ataque += equipamento.ataque
                    tabuleiro.monstro[index].defesa += equipamento.defesa
                    tabuleiro.player.baralho.minus(equipamento)
                }
            } else {
                println("Não existem monstros no tabuleiro")
            }
        }

        private fun posicionarMonstro(tabuleiro: Tabuleiro, monstro: Monstro) {
            if (tabuleiro.monstro.size < 5) {
                tabuleiro.monstro.plus(monstro)
                tabuleiro.player.baralho.minus(monstro)
            } else {
                println("Não é possível posicionar mais monstros no tabuleiro")
            }
        }



        private fun descartarCarta(player: Player, carta: Carta) {
            player.baralho.minus(carta)
        }

        private fun atacar(atacante:Player, oponente:Player){
            println("${atacante.nome} - Escolha um monstro do ${oponente.nome} para atacar: ")
            atacante.baralho.forEachIndexed { index, carta ->
                if (carta.categoria == "monstro") {
                    println("$index - ${carta.nome} - ${carta.descricao} - ${carta.ataque} - ${carta.defesa}")
                }
            }
            val index = readln().toInt()
            if (index > atacante.baralho.size) {
                println("Carta não existe, escolha outra carta")
                atacar(atacante, oponente)
            } else if (atacante.baralho[index].categoria != "monstro") {
                println("Carta não é um monstro, escolha outra carta")
                atacar(atacante, oponente)
            }
            atacante.baralho[index].let {
                oponente.pontos -= it.ataque
            }
        }

        private fun alterarEstado(monstro: Monstro) {
            if (monstro.modo == "ataque") {
                monstro.modo = "defesa"
            } else {
                monstro.modo = "ataque"
            }
        }
    }
}

