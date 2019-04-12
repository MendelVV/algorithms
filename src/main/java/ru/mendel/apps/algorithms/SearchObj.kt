package ru.mendel.apps.algorithms

class SearchObj<T>(val compare: (o1: T, o2: T) -> Int) {

    fun search(array: Array<T>, target: T):Int{
        var low = 0
        var high = array.size-1

        while (low <= high){
            val mid = (low+high)/2;
            if (compare(target,array[mid])<0){
                high=mid-1
            }else if(compare(target,array[mid])>0){
                low=mid+1;
            }else{
                return mid
            }
        }
        return -1;
    }

}