import java.util.*
import kotlin.math.min

//https://leetcode.com/problems/merge-k-sorted-lists/
class MergeKSortedList {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        val pointers: MutableList<ListNode?> = mutableListOf()
        lists.map {
            if (it!=null){
                pointers.add(it)
            }
        }
        if (pointers.isEmpty()){
            return null
        }
        val minHeap = MinHeapLinkedList(pointers.toMutableList())


        var sortedListHead: ListNode? = null
        var sortedListPointer: ListNode? = null
        while (!minHeap.isEmpty()) {
            val node = minHeap.remove()
            if (sortedListHead == null) {
                sortedListHead = node
                sortedListPointer = node
            } else {
                sortedListPointer?.next = node
                sortedListPointer = sortedListPointer?.next
            }
            node?.next?.let {
                minHeap.insert(it)
            }
        }

        return sortedListHead
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val headNode1: ListNode? = ListNode(1)
            headNode1?.next = ListNode(4)
            headNode1?.next?.next = ListNode(5)

            val headNode2: ListNode? = ListNode(1)
            headNode2?.next = ListNode(3)
            headNode2?.next?.next = ListNode(4)

            val headNode3: ListNode? = ListNode(2)
            headNode3?.next = ListNode(6)
            val array = arrayOf(headNode1, headNode2, headNode3)
            val sortedList = MergeKSortedList().mergeKLists(array)

            var pointer = sortedList
            while (pointer != null) {
                print("${pointer.value} ")
                pointer = pointer.next
            }
        }
    }

}

open class MinHeapLinkedList(array: MutableList<ListNode?>) {
    var heap = this.buildHeap(array)

    fun buildHeap(array: MutableList<ListNode?>): MutableList<ListNode?> {
        val lastParentIndex = (array.size - 1) / 2
        for (index in lastParentIndex downTo 0) {
            siftDown(index, array.size - 1, array)
        }
        return array
    }

    fun siftDown(currentIdx: Int, endIdx: Int, heap: MutableList<ListNode?>) {
        var index = currentIdx

        while (index <= endIdx) {
            var i = index
            val leftChildIndex = 2 * i + 1
            val rightChildIndex = leftChildIndex + 1
            if (heap[i] != null) {
                if (leftChildIndex <= endIdx && heap[leftChildIndex] != null && heap[i]?.value!! > heap[leftChildIndex]?.value!!) {
                    i = leftChildIndex
                }
                if (rightChildIndex <= endIdx && heap[rightChildIndex] != null && heap[i]?.value!! > heap[rightChildIndex]?.value!!) {
                    i = rightChildIndex
                }
                if (i == index) {
                    return;
                }
            }
            Collections.swap(heap, i, index)
            index = i
        }

    }

    fun siftUp(currentIdx: Int, heap: MutableList<ListNode?>) {
        if (heap[currentIdx] == null) {
            return
        }
        val parentIndex = (currentIdx - 1) / 2
        if (heap[parentIndex] == null) {
            return
        }
        if (currentIdx > 0 && currentIdx < heap.size && heap[parentIndex]?.value!! > heap[currentIdx]?.value!!) {
            Collections.swap(heap, parentIndex, currentIdx)
            siftUp(parentIndex, heap)
        }
    }

    fun peek(): ListNode? {
        return heap[0]
    }

    fun remove(): ListNode? {
        if (heap.isEmpty())
            return null
        val lastItem = heap.last()
        val itemToBeRemoved = heap[0]
        heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()){
            heap[0] = lastItem
            siftDown(0, heap.size - 1, heap)
        }
        return itemToBeRemoved
    }

    fun isEmpty(): Boolean {
        return heap.isEmpty()
    }

    fun insert(value: ListNode?) {
        heap.add(value)
        siftUp(heap.size - 1, heap)
    }

    fun print() {
        heap.map {
            print("${it?.value} ")
        }
        print("\n")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arrayNodes = mutableListOf<ListNode?>()
            val array = intArrayOf(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)
            array.map {
                arrayNodes.add(ListNode(it))
            }
            val minHeap = MinHeapLinkedList(arrayNodes)
            minHeap.print()
            minHeap.insert(ListNode(76))
            minHeap.print()
            println(minHeap.peek()?.value)
            println(minHeap.remove()?.value)
            minHeap.print()
            println(minHeap.peek()?.value)
            println(minHeap.remove()?.value)
            minHeap.print()
            println(minHeap.peek()?.value)
            minHeap.insert(ListNode(87))
            minHeap.print()
        }
    }
}