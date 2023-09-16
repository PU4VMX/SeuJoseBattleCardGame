package tools

import model.Carta
import java.io.File
import java.io.InputStream

class LeitorCartas (){

    companion object{
        private lateinit var cartas:List<Carta>

        fun getCartas():List<Carta>{
            if(!::cartas.isInitialized){
                cartas = lerCartasCSV().map { Carta(it) }
            }
            return cartas.map { it }  //retorna uma replica das cartas
        }

        private fun lerCartasCSV():List<String>{
            val streamDados:InputStream = File("cartas.csv").inputStream()
            val leitorStream = streamDados.bufferedReader()
            return leitorStream.lineSequence()
                .filter { it.isNotBlank() }.toList()
        }

        //sortear 5 cartas
        fun sortearCartas():List<Carta>{
            val cartas = getCartas()
            val cartasSorteadas = mutableListOf<Carta>()
            for(i in 1..5){
                val carta = cartas.random()
                cartasSorteadas.add(carta)
            }
            return cartasSorteadas
        }


    }



}