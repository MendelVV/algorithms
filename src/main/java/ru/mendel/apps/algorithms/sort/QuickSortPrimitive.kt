package ru.mendel.apps.algorithms.sort

class QuickSortPrimitive {

    fun sortInt(array: Array<Int>): Array<Int> {
        val startIndex = 0
        val endIndex = array.size-1
        doSortInt(array, startIndex, endIndex)
        return array
    }

    private fun doSortInt(array: Array<Int>, start: Int, end: Int) {
        if (start >= end)
            return
        var i = start
        var j = end
        var cur = i - (i - j) / 2
        while (i < j) {
            while (i < cur && array[i] <= array[cur]) {
                i++
            }
            while (j > cur && array[cur] <= array[j]) {
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
        doSortInt(array, start, cur)
        doSortInt(array, cur + 1, end)
    }

    fun sortLong(array: Array<Long>): Array<Long> {
        val startIndex = 0
        val endIndex = array.size-1
        doSortLong(array, startIndex, endIndex)
        return array
    }

    private fun doSortLong(array: Array<Long>, start: Int, end: Int) {
        if (start >= end)
            return
        var i = start
        var j = end
        var cur = i - (i - j) / 2
        while (i < j) {
            while (i < cur && array[i] <= array[cur]) {
                i++
            }
            while (j > cur && array[cur] <= array[j]) {
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
        doSortLong(array, start, cur)
        doSortLong(array, cur + 1, end)
    }

    fun sortFloat(array: Array<Float>): Array<Float> {
        val startIndex = 0
        val endIndex = array.size-1
        doSortFloat(array, startIndex, endIndex)
        return array
    }

    private fun doSortFloat(array: Array<Float>, start: Int, end: Int) {
        if (start >= end)
            return
        var i = start
        var j = end
        var cur = i - (i - j) / 2
        while (i < j) {
            while (i < cur && array[i] <= array[cur]) {
                i++
            }
            while (j > cur && array[cur] <= array[j]) {
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
        doSortFloat(array, start, cur)
        doSortFloat(array, cur + 1, end)
    }

    fun sortDouble(array: Array<Double>): Array<Double> {
        val startIndex = 0
        val endIndex = array.size-1
        doSortDouble(array, startIndex, endIndex)
        return array
    }

    private fun doSortDouble(array: Array<Double>, start: Int, end: Int) {
        if (start >= end)
            return
        var i = start
        var j = end
        var cur = i - (i - j) / 2
        while (i < j) {
            while (i < cur && array[i] <= array[cur]) {
                i++
            }
            while (j > cur && array[cur] <= array[j]) {
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
        doSortDouble(array, start, cur)
        doSortDouble(array, cur + 1, end)
    }
}