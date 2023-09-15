package model

class Carta(s: String) {
    val nome: String
    val tipo: String
    val ataque: Int
    val defesa: Int

    init {
        val campos = s.split(";")
        nome = campos[0]
        tipo = String.format("%-10s", campos[1])
        ataque = campos[2].toInt()
        defesa = campos[3].toInt()
    }

    override fun toString(): String {
        return "$nome - $tipo - $ataque - $defesa"
    }
}