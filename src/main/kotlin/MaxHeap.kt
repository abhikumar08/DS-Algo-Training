import java.util.Collections.swap

open class MaxHeap(array: MutableList<Int>) {
    val heap = this.buildHeap(array)

    fun buildHeap(array: MutableList<Int>): MutableList<Int> {
        val lastParentIndex = (array.size - 1) / 2
        for (index in lastParentIndex downTo 0) {
            siftDown(index, array.size - 1, array)
        }
        return array
    }

    fun siftDown(currentIdx: Int, endIdx: Int, heap: MutableList<Int>) {
        var index = currentIdx
        while (index<= endIdx){
            var i = index
            val leftChildIndex = 2*i+1
            val rightChildIndex = leftChildIndex+1
            if (leftChildIndex<= endIdx && heap[i]< heap[leftChildIndex]){
                i = leftChildIndex
            }
            if (rightChildIndex<=endIdx && heap[i]<heap[rightChildIndex]){
                i = rightChildIndex
            }
            if (i==index){
                return
            }
            swap(heap, i, index)
            index = i
        }
    }

    fun siftUp(currentIdx: Int, heap: MutableList<Int>) {
        val parentIndex = (currentIdx - 1) / 2
        if (currentIdx > 0 && currentIdx < heap.size && heap[parentIndex] < heap[currentIdx]) {
            swap(heap, parentIndex, currentIdx)
            siftUp(parentIndex, heap)
        }
    }

    fun peek(): Int? {
        return if (heap.isNotEmpty())
            heap[0]
        else null
    }

    fun remove(): Int? {
        val lastItem = heap.last()
        heap.removeAt(heap.size - 1)
        val itemToBeRemoved = heap[0]
        heap[0] = lastItem
        siftDown(0, heap.size-1, heap)
        return itemToBeRemoved
    }

    fun insert(value: Int) {
        heap.add(value)
        siftUp(heap.size - 1, heap)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array = intArrayOf(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)
            val maxHeap = MaxHeap(array.toMutableList())
            maxHeap.print()
            maxHeap.insert(76)
            maxHeap.print()
            println(maxHeap.peek())
            println(maxHeap.remove())
            maxHeap.print()
            println(maxHeap.peek())
            println(maxHeap.remove())
            maxHeap.print()
            println(maxHeap.peek())
            maxHeap.insert(87)
            maxHeap.print()
        }
    }

    fun print() {
        heap.map {
            print("$it ")
        }
        print("\n")
    }
}