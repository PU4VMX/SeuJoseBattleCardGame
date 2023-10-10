package model

class Carta(s: String) {
    //Declaração das propriedades da classe Carta
    val nome: String
    val descricao: String
    val ataque: Int
    val defesa: Int
    val categoria: String

    //Bloco de inicialização (executado quando uma instância da carta é criada).
    init {
        //Divide a string de entrada "s" em partes usando ";" como um delimitador.
        val campos = s.split(";")
        // Atribui o primeiro elemento da lista "campos" à propriedade "nome".
        nome = campos[0]
        // Formata o segundo elemento da lista "campos" com um comprimento mínimo de 10 caracteres
        // e atribui o resultado à propriedade "descricao".
        descricao = String.format("%-10s", campos[1])
        // Converte o terceiro elemento da lista "campos" para um valor inteiro e atribui à propriedade "ataque".
        ataque = campos[2].toInt()
        // Converte o quarto elemento da lista "campos" para um valor inteiro e atribui à propriedade "defesa".
        defesa = campos[3].toInt()
        // Atribui o quinto elemento da lista "campos" à propriedade "categoria".
        categoria = campos[4]
    }

    // Sobrescreve o método toString() para retornar uma representação de string da Carta.
    override fun toString(): String {
        // Formata os atributos da carta separados por hífens e retorna como uma string.
        return "$nome - $descricao - $ataque - $defesa - $categoria"
    }
}

