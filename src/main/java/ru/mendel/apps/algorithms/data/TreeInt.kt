package ru.mendel.apps.algorithms.data

class TreeInt {

    var root: NodeInt? = null

    fun insert(node: NodeInt){
        if (root==null){
            root = node
            return
        }
        //ищем теперь куда вставить
        var current = root
        var parent = root
        var isLeftChild = false
        while(node.num!=current!!.num){
            parent = current
            current = if (node.num<current.num){
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

    fun find(n: Int): NodeInt?{
        //просто ищем
        var current = root
        while(n!=current!!.num){
            current = if (n<current.num){
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

    fun delete(key: Int){
        //ищем сначала что удалить
        var current = root
        var parent = root
        var isLeftChild = false
        while(key!=current!!.num){
            parent = current
            current = if (key<current.num){
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

    private fun getSuccessor(node: NodeInt):NodeInt{
        var successor = node
        var current : NodeInt? = node.rightChild
        var parent : NodeInt? = node
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

    fun getList():ArrayList<NodeInt>{
        //обход по возрастанию
        val array = arrayListOf<NodeInt>()
        orderStep(root, array)
        return array
    }

    private fun orderStep(node: NodeInt?, array: ArrayList<NodeInt>){
        if (node==null){
            return
        }
        orderStep(node.leftChild, array)
        array.add(node)
        orderStep(node.rightChild, array)
    }

    class NodeInt(val num: Int){
        var leftChild: NodeInt? = null
        var rightChild: NodeInt? = null

        override fun toString(): String {
            val left = if (leftChild==null){
                "null"
            }else{
                leftChild!!.num
            }
            val right = if (rightChild==null){
                "null"
            }else{
                rightChild!!.num
            }
            return "$num ($left;$right)"
        }
    }

}