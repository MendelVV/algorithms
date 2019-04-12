package ru.mendel.apps.algorithms.sort

class QuickSortObjects<T>(val compare: (o1: T, o2: T) -> Int) {

    fun sort(array: Array<T>): Array<T> {
        val startIndex = 0
        val endIndex = array.size-1
        doSort(array, startIndex, endIndex)
        return array
    }

    private fun doSort(array: Array<T>, start: Int, end: Int) {
        if (start >= end)
            return
        var i = start
        var j = end
        var cur = i - (i - j) / 2
        while (i < j) {
            while (i < cur && compare(array[i],array[cur])<=0) {
                i++
            }
            while (j > cur && compare(array[cur], array[j])<=0) {
                j--
            }
            if (i < j) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
                if (i == cur)
                    cur = j
                else if (j == cur)
                    cur = i
            }
        }
        doSort(array, start, cur)
        doSort(array, cur + 1, end)
    }


}