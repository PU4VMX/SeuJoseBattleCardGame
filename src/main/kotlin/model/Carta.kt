package model

class Carta(s: String) {
    val nome: String
    val descricao: String
    val ataque: Int
    val defesa: Int
    val categoria: String

    init {
        val campos = s.split(";")
        nome = campos[0]
        descricao = String.format("%-10s", campos[1])
        ataque = campos[2].toInt()
        defesa = campos[3].toInt()
        categoria = campos[4]
    }

    override fun toString(): String {
        return "$nome - $descricao - $ataque - $defesa - $categoria"
    }
}