package ru.mendel.apps.algorithms

import org.junit.Test
import ru.mendel.apps.algorithms.strings.KMP
import java.util.*

class KMPTests {

    @Test
    fun indexesOf(){
        val mainStr = "mainmainsuperstring"
        val subStr = "ain"
        val res = KMP.indexesOf(subStr,mainStr)
        println(Arrays.toString(res))
    }

}