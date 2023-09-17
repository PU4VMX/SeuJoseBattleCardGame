package model

class Monstro(nome: String, descricao: String, ataque: Int, defesa: Int, modo: String? = null, equipamentos: List<Equipamento>? = null) {
    val nome: String
    val descricao: String
    val ataque: Int
    val defesa: Int
    var modo: String? = null
    var equipamentos: List<Equipamento>? = null

    init {
        this.nome = nome
        this.descricao = descricao
        this.ataque = ataque
        this.defesa = defesa
        this.modo = modo
        this.equipamentos = equipamentos
    }

    override fun toString(): String {
        return "$nome - $descricao - $ataque - $defesa - $modo - $equipamentos"
    }

}