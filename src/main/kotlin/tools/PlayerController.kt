package tools

import model.Equipamento
import model.Monstro
import model.Player

class PlayerController {

    companion object {
        fun createPlayer(nome: String): Player {
            val baralho = LeitorCartas.distribuirCartas()
            val monstro = mutableListOf<Monstro>()

            baralho.forEach {
                if (it.categoria == "monstro") {
                    monstro.add(Monstro(it.nome, it.descricao, it.ataque, it.defesa))
                }
            }
            return Player(nome, 10000, baralho, monstro)
        }

        fun getPontuacao(player: Player): Int {
            return player.pontos
        }


        fun getMonstro(player: Player): Monstro {
            println("Player: ${player.nome}, escolha um monstro para jogar: ")
            player.baralho.forEachIndexed { index, carta ->
                if (carta.categoria == "monstro") {
                    println("$index - ${carta.nome} - ${carta.descricao} - ${carta.ataque} - ${carta.defesa}")
                }
            }
            val index = readln().toInt()
            if (index > player.baralho.size) {
                println("Carta não existe, escolha outra carta")
                getMonstro(player)
            }
            else if (player.baralho[index].categoria != "monstro") {
                println("Carta não é um monstro, escolha outra carta")
                getMonstro(player)
            }
            player.baralho[index].let {
                return Monstro(it.nome, it.descricao, it.ataque, it.defesa)
            }
        }


        fun getEquipamento(player: Player): Equipamento {
            println("Escolha um equipamento para jogar: ")
            player.baralho.forEachIndexed { index, carta ->
                if (carta.categoria == "equipamento") {
                    println("$index - ${carta.nome} - ${carta.descricao} - ${carta.ataque} - ${carta.defesa}")
                }
            }
            val index = readln().toInt()
            player.baralho[index].let {
                return Equipamento(it.nome, it.descricao, it.ataque, it.defesa)
            }
        }


    }
}