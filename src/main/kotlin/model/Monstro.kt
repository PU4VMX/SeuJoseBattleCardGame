package model

class Monstro(nome: String, descricao: String, ataque: Int, defesa: Int, modo: String? = null) {
    val nome: String
    val descricao: String
    var ataque: Int
    var defesa: Int
    var modo: String? = null

    init {
        this.nome = nome
        this.descricao = descricao
        this.ataque = ataque
        this.defesa = defesa
        this.modo = modo
    }

    override fun toString(): String {
        return "$nome - $descricao - $ataque - $defesa - $modo"
    }

}