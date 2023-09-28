import tools.PlayerController
import tools.TabuleiroController

fun main(args: Array<String>) {

    val player1 = PlayerController.createPlayer("Player 1")
    val player2 = PlayerController.createPlayer("Player 2")

    val tabuleiro_player1 = TabuleiroController.createTabuleiro(player1, PlayerController.getMonstro(player1));
    val tabuleiro_player2 = TabuleiroController.createTabuleiro(player2, PlayerController.getMonstro(player2));

    println("Player 1: ${player1.nome}")
    println("Player 2: ${player2.nome}")

    println("Monstro Player 1: ${tabuleiro_player1.monstro}")
    println("Monstro Player 2: ${tabuleiro_player2.monstro}")

}