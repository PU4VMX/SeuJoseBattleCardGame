package tools

import model.*

class RodadaController {

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
                "a" -> posicionarMonstro(tabuleiroA)
                "b" -> equiparMonstro(tabuleiroA)
                "c" -> descartarCarta(tabuleiroA.player)
                "d" -> atacar(tabuleiroA, tabuleiroB)
                "e" -> alterarEstado(tabuleiroA.monstro[0])
                else -> {
                    println("Ação inválida, escolha outra ação")
                    executarAcao(tabuleiroA, tabuleiroB)
                }
            }
        }

        private fun equiparMonstro(tabuleiro: Tabuleiro) {
            if (tabuleiro.monstro.isEmpty()) {
                println("Não existem monstros no tabuleiro")
                return
            }

            println("${tabuleiro.player.nome} - Escolha um monstro para equipar:")
            tabuleiro.monstro.forEachIndexed { index, monstro ->
                println("$index - ${monstro.nome} - ${monstro.descricao} - ${monstro.ataque} - ${monstro.defesa}")
            }
            val index = readln().toInt()
            if (index < 0 || index >= tabuleiro.monstro.size) {
                println("Monstro não existe, escolha outro monstro")
                return
            }

            val monstro = tabuleiro.monstro[index]
            val equipamento = PlayerController.getEquipamento(tabuleiro.player)

            monstro.ataque += equipamento.ataque
            monstro.defesa += equipamento.defesa


            println("Monstro equipado com sucesso")
            println("Seu monstro agora possui ${monstro.ataque} de ataque e ${monstro.defesa} de defesa")
        }

        private fun posicionarMonstro(tabuleiro: Tabuleiro) {
            if (tabuleiro.monstro.size >= 5) {
                println("Não é possível posicionar mais monstros no tabuleiro")
                return
            }

            val monstro = PlayerController.getMonstro(tabuleiro.player)
            MonstroController.setModo(monstro).modo.also { monstro.modo = it }
        }

        private fun descartarCarta(player: Player) {
            val carta = PlayerController.getCarta(player)
            player.baralho.filter { it.nome == carta.nome }
        }

        private fun atacar(tabuleiroA: Tabuleiro, tabuleiroB: Tabuleiro) {
            val monstroA = escolherMonstroParaAtacar(tabuleiroA)
            val monstroB = escolherMonstroParaAtacar(tabuleiroB)

            if (monstroA.modo == "defesa") {
                println("Não é possível atacar no modo de defesa")
                return
            }

            val dano = calcularDano(monstroA, monstroB)

            if (dano < 0) {
                tabuleiroB.player.pontos += dano
                tabuleiroA.player.pontos -= dano
            } else {
                tabuleiroB.player.pontos -= dano
                tabuleiroA.player.pontos += dano
            }

            removerMonstro(tabuleiroB, monstroB)

        }

        private fun removerMonstro(tabuleiroB: Tabuleiro, monstroB: Monstro) {
            tabuleiroB.monstro = tabuleiroB.monstro.filter { it.nome != monstroB.nome }
            tabuleiroB.player.baralho.filter { it.nome != monstroB.nome }
        }

        private fun escolherMonstroParaAtacar(tabuleiro: Tabuleiro): Monstro {
            if (tabuleiro.monstro.isEmpty()) {
                println("Não existem monstros no tabuleiro")
                println("Deseja posicionar um monstro? S/N")
                val opcao = readln()
                if (opcao == "S") {
                    posicionarMonstro(tabuleiro)
                } else {
                    return Monstro("", "", 0, 0, "")
                }
            }

            println("Escolha um monstro para atacar:")
            tabuleiro.monstro.forEachIndexed { index, monstro ->
                println("$index - ${monstro.nome} - ${monstro.descricao} - ${monstro.ataque} - ${monstro.defesa}")
            }
            val index = readln().toInt()
            if (index < 0 || index >= tabuleiro.monstro.size) {
                println("Monstro não existe, escolha outro monstro")
                // Retorna um monstro vazio, apenas para não quebrar o código
                return Monstro("", "", 0, 0, "")
            }

            return tabuleiro.monstro[index]
        }

        private fun calcularDano(monstroA: Monstro, monstroB: Monstro): Int {
            return if (monstroB.modo == "defesa") {
                0 // Não perde pontos se o monstro B estiver em modo de defesa
            } else {
                var dano: Int = monstroA.ataque - monstroB.defesa
                println("O monstro ${monstroA.nome} atacou o monstro ${monstroB.nome} e causou $dano de dano")
                return dano
            }
        }

        private fun alterarEstado(monstro: Monstro) {
            monstro.modo = if (monstro.modo == "ataque") "defesa" else "ataque"
            println("O monstro ${monstro.nome} agora está no modo de ${monstro.modo}")
        }
    }
}
