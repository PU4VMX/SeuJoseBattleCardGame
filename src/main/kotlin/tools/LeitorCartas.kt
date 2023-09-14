package tools

import model.Carta
import java.io.File
import java.io.InputStream

class LeitorCartas (){

    companion object{
        private lateinit var cartas:List<Carta>

        fun getCartas():List<Carta>{
            if(!::cartas.isInitialized){
                /*aqui deve ocorrer a carga das cartas
                *
                *Sugiro usar a função map para transformar as String recuperadas do arquivo em objetos do tipo carta
                */
                //cartas = lerCartasCSV()
                println(lerCartasCSV())
            }
            return cartas.map { it }  //retorna uma replica das cartas
        }

        private fun lerCartasCSV():List<String>{
            val streamDados:InputStream = File("cartas.csv").inputStream()
            val leitorStream = streamDados.bufferedReader()
            return leitorStream.lineSequence()
                .filter { it.isNotBlank() }.toList()

        }
    }



}