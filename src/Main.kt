import java.util.Scanner

fun main() {
    val informacoesCasas: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    var continuar: Boolean

    do {
        val input = Scanner(System.`in`)

        println("\nInforme o numero da casa: ")
        val numeroCasa: Int = input
            .nextLine()
            .toInt()

        val idadesMoradores: MutableList<Int> = mutableListOf()

        println("Informe a idade dos moradores: ")
        input
            .nextLine()
            .split(", ")
            .map{ idadesMoradores.add(it.toInt()) }

        informacoesCasas.put(numeroCasa, idadesMoradores)

        println("Continuar? Sim | Nao")
        continuar = if(input.nextLine() == "Sim") true else false
    } while (continuar)

    val idadeMedia = informacoesCasas
        .values
        .flatten()
        .average()

    println("\n\nIdade Media: $idadeMedia")
}