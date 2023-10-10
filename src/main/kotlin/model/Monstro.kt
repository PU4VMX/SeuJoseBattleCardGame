package model

// Declaração da classe Monstro, que representa um monstro com atributos.
class Monstro(nome: String, descricao: String, ataque: Int, defesa: Int, modo: String? = null) {
    // Declaração das propriedades da classe Monstro.
    val nome: String
    val descricao: String
    var ataque: Int
    var defesa: Int
    var modo: String? = null

    // Bloco de inicialização (executado quando uma instância de Monstro é criada).
    init {
        // Atribui o valor do argumento "nome" à propriedade "nome".
        this.nome = nome
        // Atribui o valor do argumento "descricao" à propriedade "descricao".
        this.descricao = descricao
        // Atribui o valor do argumento "ataque" à propriedade "ataque".
        this.ataque = ataque
        // Atribui o valor do argumento "defesa" à propriedade "defesa".
        this.defesa = defesa
        // Atribui o valor do argumento "modo" à propriedade "modo" (pode ser nulo).
        this.modo = modo
    }

    // Sobrescreve o método toString() para retornar uma representação de string do Monstro.
    override fun toString(): String {
        // Formata os atributos do monstro separados por hífens e retorna como uma string.
        return "$nome - $descricao - $ataque - $defesa - $modo"
    }

}