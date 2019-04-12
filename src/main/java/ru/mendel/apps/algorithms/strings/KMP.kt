package ru.mendel.apps.algorithms.strings

import java.util.*

object KMP {

    fun indexesOf(pattern: CharArray, text: CharArray): IntArray {
        val pfl = pfl(pattern)
        val indexes = IntArray(text.size)
        var size = 0
        var k = 0
        for (i in text.indices) {
            while (pattern[k] != text[i] && k > 0) {
                k = pfl[k - 1]
            }
            if (pattern[k] == text[i]) {
                k++
                if (k == pattern.size) {
                    indexes[size] = i + 1 - k
                    size += 1
                    k = pfl[k - 1]
                }
            } else {
                k = 0
            }
        }
        return Arrays.copyOfRange(indexes, 0, size)
    }

    private fun pfl(text: CharArray): IntArray {
        val pfl = IntArray(text.size)
        pfl[0] = 0

        for (i in 1 until text.size) {
            var k = pfl[i - 1]
            while (text[k] != text[i] && k > 0) {
                k = pfl[k - 1]
            }
            if (text[k] == text[i]) {
                pfl[i] = k + 1
            } else {
                pfl[i] = 0
            }
        }

        return pfl
    }

    fun indexesOf(pattern: String, text: String): IntArray {
        return KMP.indexesOf(pattern.toCharArray(), text.toCharArray())
    }


}