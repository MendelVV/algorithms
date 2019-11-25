package ru.mendel.apps.algorithms

import org.junit.Before
import org.junit.Test
import ru.mendel.apps.algorithms.data.TreeInt
import ru.mendel.apps.algorithms.data.TreeObject


class TreeObjectTest {

    lateinit var tree: TreeObject<Int>

    @Before
    fun initTree(){
        tree = TreeObject{ v1: Int, v2:Int ->
            when {
                v1==v2 -> {
                    return@TreeObject 0
                }
                v1<v2 -> {
                    return@TreeObject -1
                }
                else -> {
                    return@TreeObject 1
                }
            }
        }
    }

    @Test
    fun insertTest(){

        val node1 = TreeObject.NodeObject(20)
        tree.insert(node1)
        assert(tree.root==node1)

        val node2 = TreeObject.NodeObject(25)
        tree.insert(node2)
        assert(tree.root!!.rightChild==node2)

        val node3 = TreeObject.NodeObject(24)
        tree.insert(node3)
        assert(tree.root!!.rightChild!!.leftChild==node3)

        showAll(tree)
    }

    @Test
    fun findTest(){
        val node1 = TreeObject.NodeObject(20)
        tree.insert(node1)

        val node2 = TreeObject.NodeObject(25)
        tree.insert(node2)

        val node3 = TreeObject.NodeObject(24)
        tree.insert(node3)
        val node = tree.find(25)
        assert(node==node2)
    }

    @Test
    fun deleteTest(){
        insertArray(arrayListOf(20, 10, 15, 50, 55, 40, 25, 45, 30, 53, 54, 60, 65, 62))

        tree.delete(10)
        var node = tree.root!!.leftChild
        assert(node!!.value==15)

        tree.delete(55)
        node = tree.root!!.rightChild!!.rightChild
        assert(node!!.value==60)
        assert(node.leftChild!!.value==53)

        tree.delete(50)
        node = tree.root!!.rightChild
        assert(node!!.value==53)
    }

    private fun insertArray(array: ArrayList<Int>){
        for (i in array){
            val node = TreeObject.NodeObject(i)
            tree.insert(node)
        }
    }

    private fun showAll(tree: TreeObject<Int>){
        val arr = tree.getList()
        for (node in arr){
            println(node.value)
        }
    }
}