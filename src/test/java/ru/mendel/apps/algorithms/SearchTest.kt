package ru.mendel.apps.algorithms

import org.junit.Test
import ru.mendel.apps.algorithms.search.SearchObj
import ru.mendel.apps.algorithms.sort.QuickSortObjects
import java.util.*

class SearchTest {

    @Test
    fun search(){
        val random = Random()
        val array = mutableListOf<TestData>()
        for (i in 0..20){
            val data = TestData(random.nextInt(1000) - 500, "name$i")
            array.add(data)
        }

        val compare:(TestData, TestData)-> Int  = { o1: TestData, o2: TestData ->
            when {
                o1.sz>o2.sz ->  1
                o1.sz==o2.sz ->  0
                else -> -1
            }

        }

        val sort = QuickSortObjects(compare)
        val search = SearchObj(compare)
        val res = sort.sort(array.toTypedArray())
        assert(search.search(res,res[10])==10)
        assert(search.search(res, TestData(1000, "nm"))==-1)

    }

}