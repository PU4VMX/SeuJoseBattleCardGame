import model.Player
import tools.LeitorCartas
import tools.LeitorCartas.Companion.distribuirCartas
import tools.PlayerController
import tools.RodadaController
import tools.TabuleiroController

fun main(args: Array<String>) {

    val baralho = LeitorCartas.getCartas()

    val player1: Player = PlayerController.createPlayer("Duda", distribuirCartas(baralho))
    val player2: Player = PlayerController.createPlayer("Vinicius", distribuirCartas(baralho))

    val tabuleiro_player1 = TabuleiroController.createTabuleiro(player1, PlayerController.getMonstro(player1));
    val tabuleiro_player2 = TabuleiroController.createTabuleiro(player2, PlayerController.getMonstro(player2));

    do {
        RodadaController.executarAcao(tabuleiro_player1, tabuleiro_player2)
        RodadaController.executarAcao(tabuleiro_player2, tabuleiro_player1)
    } while (player1.pontos > 0 && player2.pontos > 0)

    if (player1.pontos > 0) {
        println("O player ${player1.nome} venceu")
    } else {
        println("O player ${player2.nome} venceu")
    }

}