package tools

// Importando a classe Monstro para uso no MonstroController.
import model.Monstro

// Declaração da classe MonstroController, que lida com a configuração do modo de um Monstro.
class MonstroController {

    // Declaração de uma função estática (membro do Companion Object) para configurar o modo de um Monstro.
    companion object {
        // Função para configurar o modo (ataque ou defesa) de um Monstro.
        fun setModo(monstro: Monstro): Monstro {
            println("Deseja setar o modo de ataque ou defesa?")
            println("1 - Ataque")
            println("2 - Defesa")
            var modo: Int = 0
            try {
                modo = readln().toInt()
            } catch (e: Exception) {
                println("Opção inválida, tente novamente")
                // Em caso de exceção, a função é chamada novamente para obter uma entrada válida.
                setModo(monstro)
            }
            // Usa um bloco when para determinar o modo com base na entrada do usuário.
            when (modo) {
                1 -> {
                    // Define o modo como "ataque" se a escolha for 1.
                    monstro.modo = "ataque"
                }

                2 -> {
                    monstro.modo = "defesa" // Define o modo como "defesa" se a escolha for 2.
                }

                else -> {
                    println("Opção inválida, tente novamente")
                    // Se a entrada não for 1 ou 2, a função é chamada novamente para obter uma escolha válida.
                    setModo(monstro)
                }
            }
            return monstro
        }
    }
}