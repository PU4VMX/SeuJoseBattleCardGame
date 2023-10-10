package tools

import model.*

// Declaração da classe RodadaController, que lida com ações de rodada no jogo.
class RodadaController {

    // Declaração de uma função estática (membro do Companion Object) para executar uma ação em uma rodada.
    companion object {
        // Função para executar uma ação em uma rodada, recebendo dois tabuleiros como entrada (um para cada jogador).
        fun executarAcao(tabuleiroA: Tabuleiro, tabuleiroB: Tabuleiro) {
            // Exibe as opções de ação para o jogador A.
            println("${tabuleiroA.player.nome} - Pts: ${tabuleiroA.player.pontos} - Escolha uma ação:")
            println("a) Posicionar um novo monstro no tabuleiro")
            println("b) Equipar um monstro com uma carta de equipamento")
            println("c) Descartar uma carta da mão")
            println("d) Realizar um ataque contra o oponente")
            println("e) Alterar o estado de um monstro (ataque/defesa)")

            // Lê a ação escolhida pelo jogador A.
            val acao = readln()

            // Usa um bloco when para determinar a ação com base na entrada do jogador A.
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

        // Função privada para equipar um monstro do jogador A com um equipamento.
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
            // Verifica se o índice é válido (se o monstro existe)
            if (index < 0 || index >= tabuleiro.monstro.size) {
                println("Monstro não existe, escolha outro monstro")
                return
            }

            // Obtém o monstro escolhido e um equipamento do jogador.
            val monstro = tabuleiro.monstro[index]
            val equipamento = PlayerController.getEquipamento(tabuleiro.player)

            // Aumenta o ataque e defesa do monstro com base no equipamento.
            monstro.ataque += equipamento.ataque
            monstro.defesa += equipamento.defesa


            // Exibe uma mensagem de sucesso com as novas estatísticas do monstro.
            println("Monstro equipado com sucesso")
            println("Seu monstro agora possui ${monstro.ataque} de ataque e ${monstro.defesa} de defesa")
        }

        // Função privada para posicionar um novo monstro no tabuleiro do jogador A.
        private fun posicionarMonstro(tabuleiro: Tabuleiro) {
            if (tabuleiro.monstro.size >= 5) {
                println("Não é possível posicionar mais monstros no tabuleiro")
                return
            }

            val monstro = PlayerController.getMonstro(tabuleiro.player)
            // Define o modo (ataque ou defesa) do monstro.
            MonstroController.setModo(monstro).modo.also { monstro.modo = it }
        }

        // Função privada para descartar uma carta da mão do jogador A.
        private fun descartarCarta(player: Player) {
            val carta = PlayerController.getCarta(player)
            // Filtra as cartas do baralho do jogador A para remover a carta escolhida.
            player.baralho.filter { it.nome == carta.nome }
        }

        // Função privada para realizar um ataque do jogador A contra o jogador B.
        private fun atacar(tabuleiroA: Tabuleiro, tabuleiroB: Tabuleiro) {
            val monstroA = escolherMonstroParaAtacar(tabuleiroA)
            val monstroB = escolherMonstroParaAtacar(tabuleiroB)

            if (monstroA.modo == "defesa") {
                println("Não é possível atacar no modo de defesa")
                return
            }

            // Calcula o dano causado pelo monstro A ao monstro B.
            val dano = calcularDano(monstroA, monstroB)

            // Atualiza os pontos dos jogadores com base no dano causado.
            if (dano < 0) {
                tabuleiroB.player.pontos += dano
                tabuleiroA.player.pontos -= dano
            } else {
                tabuleiroB.player.pontos -= dano
                tabuleiroA.player.pontos += dano
            }

            // Remove o monstro B do tabuleiro B.
            removerMonstro(tabuleiroB, monstroB)

        }

        // Função privada para remover um monstro do tabuleiro B e do baralho do jogador B.
        private fun removerMonstro(tabuleiroB: Tabuleiro, monstroB: Monstro) {
            // Filtra a lista de monstros no tabuleiro B, mantendo apenas aqueles que não têm o mesmo nome do monstro a ser removido.
            tabuleiroB.monstro = tabuleiroB.monstro.filter { it.nome != monstroB.nome }
            // Filtra o baralho do jogador B da mesma forma, removendo a carta correspondente ao monstro removido.
            tabuleiroB.player.baralho.filter { it.nome != monstroB.nome }
        }

        // Função privada para escolher um monstro no tabuleiro para atacar.
        private fun escolherMonstroParaAtacar(tabuleiro: Tabuleiro): Monstro {
            if (tabuleiro.monstro.isEmpty()) {
                println("Não existem monstros no tabuleiro")
                println("Deseja posicionar um monstro? S/N")
                val opcao = readln()
                if (opcao == "S") {
                    posicionarMonstro(tabuleiro)
                } else {
                    // Retorna um monstro vazio, apenas para não quebrar o código
                    return Monstro("", "", 0, 0, "")
                }
            }

            // Exibe a lista de monstros disponíveis no tabuleiro com suas informações.
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
            // Altera o modo do monstro para "defesa" se estiver em "ataque", e vice-versa.
            monstro.modo = if (monstro.modo == "ataque") "defesa" else "ataque"
            println("O monstro ${monstro.nome} agora está no modo de ${monstro.modo}")
        }
    }
}
