package ru.mendel.apps.algorithms.permutations

fun factorial(n:Int):Long{
    var res : Long = 1;
    for (i in 1..n){
        res*=i
    }
    return res
}