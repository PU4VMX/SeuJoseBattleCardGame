package model

// Declaração da classe Equipamento, que representa um equipamento com atributos.
class Equipamento(nome: String, descricao: String, ataque: Int, defesa: Int) {
    // Declaração das propriedades da classe Equipamento.
    val nome: String
    val descricao: String
    val ataque: Int
    val defesa: Int

    // Bloco de inicialização (executado quando uma instância de Equipamento é criada).
    init {
        // Atribui o valor do argumento "nome" à propriedade "nome".
        this.nome = nome
        // Atribui o valor do argumento "descricao" à propriedade "descricao".
        this.descricao = descricao
        // Atribui o valor do argumento "ataque" à propriedade "ataque".
        this.ataque = ataque
        // Atribui o valor do argumento "defesa" à propriedade "defesa".
        this.defesa = defesa
    }

    // Sobrescreve o método toString() para retornar uma representação de string do Equipamento.
    override fun toString(): String {
        // Formata os atributos do equipamento separados por hífens e retorna como uma string.
        return "$nome - $descricao - $ataque - $defesa"
    }
}