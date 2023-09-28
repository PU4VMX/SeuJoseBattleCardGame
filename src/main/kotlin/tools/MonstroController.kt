package tools

import model.Monstro

class MonstroController {
    //setar modo de ataque ou defesa do monstro


    companion object {
        fun setModo(monstro: Monstro):Monstro {
            println("Deseja setar o modo de ataque ou defesa?")
            println("1 - Ataque")
            println("2 - Defesa")
            val modo = readln().toInt()
            if (modo == 1) {
                monstro.modo = "ataque"
            }
            if (modo == 2) {
                monstro.modo = "defesa"
            }
            else {
                println("Opção inválida, tente novamente")
                setModo(monstro)
            }
            return monstro
        }
    }
}