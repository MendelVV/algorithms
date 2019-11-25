package ru.mendel.apps.algorithms.data

class TreeObject<T>(val compare: (o1: T, o2: T) -> Int) {

    var root: NodeObject<T>? = null

    fun insert(node: NodeObject<T>){
        if (root==null){
            root = node
            return
        }
        //ищем теперь куда вставить
        var current = root
        var parent = root
        var isLeftChild = false
        while(compare(node.value, current!!.value)!=0){
            parent = current
            current = if (compare(node.value, current.value)<0){
                isLeftChild = true
                current.leftChild
            }else{
                isLeftChild = false
                current.rightChild
            }
            if (current==null){
                if (isLeftChild){
                    parent.leftChild = node
                }else{
                    parent.rightChild = node
                }
                break
            }
        }
    }

    fun find(key: T): NodeObject<T>{
        var current = root
        while(compare(key, current!!.value)!=0){
            current = if (compare(key, current.value)<0){
                current.leftChild
            }else{
                current.rightChild
            }
            if (current==null){
                break
            }
        }
        return current
    }

    fun delete(key: T){
        //ищем сначала что удалить
        var current = root
        var parent = root
        var isLeftChild = false
        while(compare(key, current!!.value)!=0){
            parent = current
            current = if (compare(key, current.value)<0){
                isLeftChild = true
                current.leftChild
            }else{
                isLeftChild = false
                current.rightChild
            }
            if (current==null){
                return
            }
        }
        //знаем теперь и элемент и его родителя
        if (current.leftChild==null && current.rightChild==null){
            //нет подузлов
            if (isLeftChild){
                parent!!.leftChild = null
            }else{
                parent!!.rightChild = null
            }
        }else if(current.leftChild==null){
            if (isLeftChild){
                parent!!.leftChild = current.rightChild
            }else{
                parent!!.rightChild = current.rightChild
            }
        }else if(current.rightChild==null){
            if (isLeftChild){
                parent!!.leftChild = current.leftChild
            }else{
                parent!!.rightChild = current.leftChild
            }
        }else{
            val successor = getSuccessor(current)
            if (current==root){
                root = successor
            }else if(isLeftChild){
                parent!!.leftChild = successor
            }else{
                parent!!.rightChild = successor
            }
            successor.leftChild = current.leftChild
        }
    }

    private fun getSuccessor(node: NodeObject<T>):NodeObject<T>{
        var successor = node
        var current : NodeObject<T>? = node.rightChild
        var parent : NodeObject<T>? = node
        while (current!=null){
            parent = successor
            successor = current
            current = current.leftChild
        }
        if (successor!=node.rightChild){
            parent!!.leftChild = successor.rightChild
            successor.rightChild = node.rightChild
        }
        return successor
    }

    fun getList():ArrayList<NodeObject<T>>{
        //обход по возрастанию
        val array = arrayListOf<NodeObject<T>>()
        orderStep(root, array)
        return array
    }

    private fun orderStep(node: NodeObject<T>?, array: ArrayList<NodeObject<T>>){
        if (node==null){
            return
        }
        orderStep(node.leftChild, array)
        array.add(node)
        orderStep(node.rightChild, array)
    }

    class NodeObject<T> (val value: T){
        var leftChild: NodeObject<T>? = null
        var rightChild: NodeObject<T>? = null
    }
}