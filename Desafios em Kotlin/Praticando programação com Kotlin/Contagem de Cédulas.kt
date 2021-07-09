/*
Desafio
Faça a leitura de um valor inteiro.
Em seguida, calcule o menor número de notas possíveis (cédulas) onde o valor pode ser decomposto.
As notas que você deve considerar são de 100, 50, 20, 10, 5, 2 e 1.
Na sequência mostre o valor lido e a relação de notas necessárias.

Entrada
Você receberá um valor inteiro N (0 < N < 1000000).

Saída
Exiba o valor lido e a quantidade mínima de notas de cada tipo necessárias, seguindo o exemplo de saída abaixo.
Após cada linha deve ser imprimido o fim de linha.
 */

// CÓDIGO

import java.util.Scanner

fun main() {
    val value = readLine()!!.toInt()

    numbers(value)
}

val numbers : (Int) -> Unit = {value ->
    val hunbill = mutableListOf<Int>()
    val fifbill = mutableListOf<Int>()
    val twebill = mutableListOf<Int>()
    val tenbill = mutableListOf<Int>()
    val fivbill = mutableListOf<Int>()
    val twobill = mutableListOf<Int>()
    val onebill = mutableListOf<Int>()
    var amount : Int
    var total = value
    var res = total % 100

    amount = (total - res) / 100
    hunbill.add(amount)

    total = res
    res %= 50
    amount = (total - res) / 50
    fifbill.add(amount)

    total = res
    res = total % 20
    amount = (total - res) / 20
    twebill.add(amount)

    total = res
    res = total % 10
    amount = (total - res) / 10
    tenbill.add(amount)

    total = res
    res = total % 5
    amount = (total - res) / 5
    fivbill.add(amount)

    total = res
    res = total % 2
    amount = (total - res) / 2
    twobill.add(amount)

    total = res
    res = total % 1
    amount = (total - res) / 1
    onebill.add(amount)

    println("$value")
    println("${hunbill[0]} nota(s) de R$ 100,00")
    println("${fifbill[0]} nota(s) de R$ 50,00")
    println("${twebill[0]} nota(s) de R$ 20,00")
    println("${tenbill[0]} nota(s) de R$ 10,00")
    println("${fivbill[0]} nota(s) de R$ 5,00")
    println("${twobill[0]} nota(s) de R$ 2,00")
    println("${onebill[0]} nota(s) de R$ 1,00")
}