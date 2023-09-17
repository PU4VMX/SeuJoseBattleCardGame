package model

class Equipamento(nome: String, descricao: String, ataque: Int, defesa: Int) {
    val nome: String
    val descricao: String
    val ataque: Int
    val defesa: Int

    init {
        this.nome = nome
        this.descricao = descricao
        this.ataque = ataque
        this.defesa = defesa
    }

    override fun toString(): String {
        return "$nome - $descricao - $ataque - $defesa"
    }
}