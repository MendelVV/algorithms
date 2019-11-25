package ru.mendel.apps.algorithms

import org.junit.Test
import ru.mendel.apps.algorithms.sort.QuickSortObjects
import ru.mendel.apps.algorithms.sort.QuickSortPrimitive
import ru.mendel.apps.algorithms.strings.EscapeHTML
import java.util.*

class SortTests {

    @Test
    fun quickSortInt(){

        val random = Random()
        val array = mutableListOf<Int>()
        for (i in 0..100){
            array.add(random.nextInt(1000)-500)
        }
        val start = System.currentTimeMillis()
 //       array.sort()//быстрее в разы
        val sort = QuickSortPrimitive()
        val res = sort.sortInt(array.toTypedArray())
        println(Arrays.toString(res))
        val end = System.currentTimeMillis()-start
        println("time=$end")
    }

    @Test
    fun quickSortObj(){
        val random = Random()
        val array = mutableListOf<TestData>()
        for (i in 0..20){
            val data = TestData(random.nextInt(1000) - 500, "name$i")
            array.add(data)
        }
        val sort = QuickSortObjects<TestData> { o1, o2 ->
            when {
                o1.sz>o2.sz -> return@QuickSortObjects 1
                o1.sz==o2.sz -> return@QuickSortObjects 0
                else -> return@QuickSortObjects -1
            }
        }
        val res = sort.sort(array.toTypedArray())
        for (data in res){
            println("${data.sz} ${data.name}")
        }

        val sortStr = QuickSortObjects<TestData> { o1, o2 ->
            when {
                o1.name>o2.name -> return@QuickSortObjects 1
                o1.name==o2.name -> return@QuickSortObjects 0
                else -> return@QuickSortObjects -1
            }
        }
        val resStr = sortStr.sort(array.toTypedArray())
        for (data in resStr){
            println("${data.sz} ${data.name}")
        }
    }
}