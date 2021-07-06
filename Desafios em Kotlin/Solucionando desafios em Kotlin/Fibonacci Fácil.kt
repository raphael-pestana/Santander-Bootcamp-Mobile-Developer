/* Desafio
A seguinte sequência de números 0 1 1 2 3 5 8 13 21... é conhecida como série de Fibonacci.
Nessa sequência, cada número, depois dos 2 primeiros, é igual à soma dos 2 anteriores.
Escreva um algoritmo que leia um inteiro N (N < 46) e mostre os N primeiros números dessa série.

Entrada
O arquivo de entrada contém um valor inteiro N (0 < N < 46).

Saída
Os valores devem ser mostrados na mesma linha, separados por um espaço em branco.
Não deve haver espaço após o último valor.
 */

// CÓDIGO

fun main(args: Array<String>) {

    val n = readLine()!!.toInt()

    //declare suas variaveis auxiliares e continue a solucao

    var sum : Int
    var t1 = 0
    var t2 = 1

    for (i in 1..(n-1)) {
        sum = t1 + t2
        print("$t1 ")
        t1 = t2
        t2 = sum
    }
    print("$t1")
}