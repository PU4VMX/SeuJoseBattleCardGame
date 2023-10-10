package tools

import model.Carta
import model.Equipamento
import model.Monstro
import model.Player
import tools.LeitorCartas.Companion.obterCartaAleatoria

// Declaração da classe PlayerController, que lida com operações relacionadas ao jogador.
class PlayerController {

    // Declaração de uma função estática (membro do Companion Object) para criar um jogador.
    companion object {
        // Função para criar um jogador com um nome e um baralho de cartas.
        fun createPlayer(nome: String, baralho: List<Carta>): Player {
            // Inicializa uma lista mutável de Monstros.
            val monstro = mutableListOf<Monstro>()

            // Itera sobre as cartas do baralho e adiciona monstros à lista de monstros.
            baralho.forEach {
                if (it.categoria == "monstro") {
                    monstro.add(Monstro(it.nome, it.descricao, it.ataque, it.defesa))
                }
            }
            // Cria e retorna um jogador com nome, pontos, baralho e monstros.
            return Player(nome, 10000, baralho, monstro)
        }

        // Função privada para remover uma carta do baralho de um jogador.
        private fun removerCarta(player: Player, carta: Carta) {
            player.baralho = player.baralho.filter { it.nome != carta.nome }
        }


        // Função para obter um monstro do baralho de um jogador.
        fun getMonstro(player: Player): Monstro {
            println("${player.nome} - Escolha um monstro para jogar: ")
            // Exibe as opções de monstros disponíveis no baralho do jogador.
            player.baralho.forEachIndexed { index, carta ->
                if (carta.categoria == "monstro") {
                    println("$index - ${carta.nome} - ${carta.descricao} - ${carta.ataque} - ${carta.defesa}")
                }
            }
            // Lê o índice escolhido pelo jogador.
            val index = readln().toInt()
            if (index > player.baralho.size) {
                println("Carta não existe, escolha outra carta")
                getMonstro(player) // Chama recursivamente a função se o índice for inválido.
            } else if (player.baralho[index].categoria != "monstro") {
                println("Carta não é um monstro, escolha outra carta")
                getMonstro(player) // Chama recursivamente a função se a carta não for um monstro.
            }
            // Remove a carta escolhida do baralho do jogador e retorna um Monstro com base nela.
            player.baralho[index].let {
                removerCarta(player, it)
                return Monstro(it.nome, it.descricao, it.ataque, it.defesa)
            }
        }


        // Função para obter um equipamento do baralho de um jogador.
        fun getEquipamento(player: Player): Equipamento {
            println("${player.nome} - Escolha um equipamento para jogar: ")
            // Exibe as opções de equipamentos disponíveis no baralho do jogador.
            player.baralho.forEachIndexed { index, carta ->
                if (carta.categoria == "equipamento") {
                    println("$index - ${carta.nome} - ${carta.descricao} - ${carta.ataque} - ${carta.defesa}")
                }
            }
            // Verifica se não há equipamentos disponíveis no baralho do jogador.
            if (player.baralho.filter { it.categoria == "equipamento" }.isEmpty()) {
                println("Não existem equipamentos no baralho")
                println("Deseja obter uma carta aleatória? S/N")
                val opcao = readln()
                // Verifica se o jogador optou por obter uma carta aleatória.
                if (opcao == "S") {
                    val carta = obterCartaAleatoria()
                    // Verifica se a carta aleatória obtida é um equipamento.
                    if (carta.categoria == "equipamento") {
                        return Equipamento(carta.nome, carta.descricao, carta.ataque, carta.defesa)
                    } else {
                        // Se a carta aleatória não for um equipamento, chama recursivamente a função
                        // getEquipamento para permitir ao jogador escolher uma carta válida.

                        getEquipamento(player)
                    }
                } else {
                    // Se a carta aleatória não for um equipamento, chama recursivamente a função
                    // getEquipamento para permitir ao jogador escolher uma carta válida.

                    getEquipamento(player)
                }
            }
            val index = readln().toInt()
            // Remove a carta escolhida do baralho do jogador e retorna um Equipamento com base nela.
            player.baralho[index].let {
                removerCarta(player, it)
                return Equipamento(it.nome, it.descricao, it.ataque, it.defesa)
            }
        }

        // Função para obter uma carta do baralho de um jogador.
        fun getCarta(player: Player): Carta {
            // Exibe as opções de cartas disponíveis no baralho do jogador.
            player.baralho.forEachIndexed { index, carta ->
                println("$index - ${carta.nome} - ${carta.descricao} - ${carta.ataque} - ${carta.defesa}")
            }
            // Lê o índice escolhido pelo jogador.
            val index = readln().toInt()
            // Remove a carta escolhida do baralho do jogador e retorna a própria carta.
            player.baralho[index].let {
                removerCarta(player, it)
                return it
            }
        }


    }
}
