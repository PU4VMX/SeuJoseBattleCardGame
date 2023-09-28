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



    fun equiparMonstro(equipamento: Equipamento, monstro: Monstro) {
        monstro.ataque += equipamento.ataque
        monstro.defesa += equipamento.defesa

        println("Monstro equipado com sucesso!")
    }

    fun descartarCarta(player: Player, carta: Carta) {

    }


    fun atacar() {

    }

    fun alterarEstado(monstro: Monstro) {
        if (monstro.modo == "ataque") {
            monstro.modo = "defesa"
        } else {
            monstro.modo = "ataque"
        }
    }
}