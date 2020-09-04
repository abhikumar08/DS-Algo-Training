//https://leetcode.com/problems/find-median-from-data-stream/
class MedianFromDataStream {
    val lowerHalf: MaxHeap = MaxHeap(mutableListOf())
    val upperHalf: MinHeap = MinHeap(mutableListOf())

    fun addNum(num: Int) {
        when {
            lowerHalf.heap.isEmpty() -> {
                lowerHalf.insert(num)
            }
            num > lowerHalf.peek()!! -> {
                upperHalf.insert(num)
            }
            else -> {
                lowerHalf.insert(num)
            }
        }

        if (upperHalf.heap.size - lowerHalf.heap.size == 2) {
            val toBeMoved = upperHalf.remove()
            toBeMoved?.let { lowerHalf.insert(it) }
        } else if (lowerHalf.heap.size - upperHalf.heap.size == 2) {
            val toBeMoved = lowerHalf.remove()
            toBeMoved?.let { upperHalf.insert(it) }
        }
    }

    fun findMedian(): Double {
        return when {
            lowerHalf.heap.size == upperHalf.heap.size -> {
                ((lowerHalf.peek() ?: 0) + (upperHalf.peek() ?: 0)) / 2.0
            }
            lowerHalf.heap.size> upperHalf.heap.size -> {
                lowerHalf.peek()!!.toDouble()
            }
            else -> {
                upperHalf.peek()!!.toDouble()
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val medianStream = MedianFromDataStream()
            medianStream.addNum(6)
            println(medianStream.findMedian())
            medianStream.addNum(10)
            println(medianStream.findMedian())
            medianStream.addNum(2)
            println(medianStream.findMedian())
            medianStream.addNum(6)
            println(medianStream.findMedian())
            medianStream.addNum(5)
            println(medianStream.findMedian())
            medianStream.addNum(0)
            println(medianStream.findMedian())
            medianStream.addNum(6)
        }
    }
}
//
//["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
//[[],[78],[],[14],[],[50],[],[20],[],[13],[],[9],[],[25],[],[8],[],[13],[],[37],[],[29],[],[33],[],[55],[],[52],[],[6],[],[17],[],[65],[],[23],[],[74],[],[43],[],[5],[],[29],[],[29],[],[72],[],[7],[],[13],[],[56],[],[21],[],[31],[],[66],[],[69],[],[69],[],[74],[],[12],[],[77],[],[23],[],[10],[],[6],[],[27],[],[63],[],[77],[],[21],[],[40],[],[10],[],[19],[],[59],[],[35],[],[40],[],[44],[],[4],[],[15],[],[29],[],[63],[],[27],[],[46],[],[56],[],[0],[],[60],[],[72],[],[35],[],[54],[],[50],[],[14],[],[29],[],[62],[],[24],[],[18],[],[79],[],[16],[],[19],[],[8],[],[77],[],[10],[],[21],[],[66],[],[42],[],[76],[],[14],[],[58],[],[20],[],[0],[]]