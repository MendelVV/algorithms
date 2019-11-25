package ru.mendel.apps.algorithms

import org.junit.Test
import ru.mendel.apps.algorithms.data.TreeInt


class TreeIntTest {

    @Test
    fun insertTest(){
        val tree = TreeInt()
        val node1 = TreeInt.NodeInt(50)
        tree.insert(node1)
        assert(tree.root==node1)

        val node2 = TreeInt.NodeInt(55)
        tree.insert(node2)

        val node3 = TreeInt.NodeInt(52)
        tree.insert(node3)
        assert(tree.root!!.rightChild!!.leftChild==node3)

        val node4 = TreeInt.NodeInt(20)
        tree.insert(node4)
        assert(tree.root!!.leftChild==node4)

    }

    @Test
    fun findTest(){
        val tree = TreeInt()
        val node1 = TreeInt.NodeInt(50)
        tree.insert(node1)

        val node2 = TreeInt.NodeInt(55)
        tree.insert(node2)

        val node3 = TreeInt.NodeInt(52)
        tree.insert(node3)

        val node = tree.find(55)
        assert(node==node2)
    }

    @Test
    fun orderInTest(){
        val tree = TreeInt()
        val node1 = TreeInt.NodeInt(50)
        tree.insert(node1)

        val node2 = TreeInt.NodeInt(55)
        tree.insert(node2)

        val node3 = TreeInt.NodeInt(52)
        tree.insert(node3)

        val node4 = TreeInt.NodeInt(20)
        tree.insert(node4)

        val arr = tree.getList()
        assert(arr.size==4)
/*        for (node in arr){
            println(node)
        }*/
    }

    @Test
    fun delete(){
        val tree = TreeInt()
        insertArray(tree, arrayListOf(20, 10, 15, 50, 55, 40, 25, 45, 30, 53, 54, 60, 65, 62))

        tree.delete(10)
        var node = tree.root!!.leftChild
        assert(node!!.num==15)

        tree.delete(55)
        node = tree.root!!.rightChild!!.rightChild
        assert(node!!.num==60)
        assert(node.leftChild!!.num==53)

        tree.delete(50)
        node = tree.root!!.rightChild
        assert(node!!.num==53)
    }

    private fun insertArray(tree: TreeInt, array: ArrayList<Int>){
        for (i in array){
            val node = TreeInt.NodeInt(i)
            tree.insert(node)
        }
    }

    private fun showAll(tree: TreeInt){
        val arr = tree.getList()
        for (node in arr){
            println(node)
        }
    }
}