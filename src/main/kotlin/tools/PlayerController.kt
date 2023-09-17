package tools

import model.Equipamento
import model.Monstro
import model.Player

class PlayerController {


    companion object {

        fun randomNumber(): Int {
            return (1..2).random()
        }
        fun createPlayer(): Player {
            val baralho = LeitorCartas.distribuirCartas()
            val monstro = mutableListOf<Monstro>()
            val equipamento = mutableListOf<Equipamento>()

            baralho.forEach {
                if (it.categoria == "monstro") {
                    monstro.add(Monstro(it.nome, it.descricao, it.ataque, it.defesa))
                } else {
                    equipamento.add(Equipamento(it.nome, it.descricao, it.ataque, it.defesa))
                }
            }
            val nome = "Jogador ${randomNumber()}"
            return Player(nome, 10000, baralho, monstro, equipamento)
        }


    }
}