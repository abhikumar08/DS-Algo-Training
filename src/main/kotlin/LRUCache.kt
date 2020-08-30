class DoublyLinkedListNode(val key: Int, val value: Int) {
    var prev: DoublyLinkedListNode? = null
    var next: DoublyLinkedListNode? = null
}

class LRUCache(val capacity: Int) {
    private val map = HashMap<Int, DoublyLinkedListNode>()
    private val queue: Queue = Queue(capacity)

    fun get(key: Int): Int {
        map[key]?.let {
            queue.remove(it)
            queue.enque(it)
            return it.value
        } ?: run {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        var nodeToBeEnqued:DoublyLinkedListNode? = null
        map[key]?.let {
            queue.remove(it)
            nodeToBeEnqued = DoublyLinkedListNode(key, value)
            map[key] = nodeToBeEnqued!!
        } ?: run {
            if (map.size == capacity){
                val node = queue.deque()
                map.remove(node?.key)
            }
            nodeToBeEnqued = DoublyLinkedListNode(key, value)
            map[key] = nodeToBeEnqued!!
        }
        queue.enque(nodeToBeEnqued)
    }

}

class Queue(val capacity: Int) {
    var front: DoublyLinkedListNode? = null
    var rear: DoublyLinkedListNode? = null
    var size: Int = 0

    fun remove(node: DoublyLinkedListNode?) {
        if (node == front && node?.next != null) {
            val tempNext = node.next
            node.next = null
            front = tempNext
            front?.prev = null
        } else if (node == rear && node?.prev != null) {
            val tempNext = node.prev
            node.prev = null
            rear = tempNext
            rear?.next = null
        } else {
            val prev = node?.prev
            val next = node?.next
            prev?.next = next
            next?.prev = prev
            node?.prev = null
            node?.next = null
        }
        size--
    }

    fun enque(node: DoublyLinkedListNode?) {
        when {
            isEmpty() -> {
                front = node
                rear = node
            }
            isFull() -> {
                if (size == 1) {
                    front = node
                    rear = node
                } else {
                    deque()
                    rear?.next = node
                    node?.prev = rear
                    rear = node
                    rear?.next = null
                }
            }
            else -> {
                rear?.next = node
                node?.prev = rear
                rear = node
                rear?.next = null
            }
        }
        size++
    }

    fun deque(): DoublyLinkedListNode? {
        return if (!isEmpty()) {
            val toBeDequed = front
            front = toBeDequed?.next
            front?.prev = null
            size--
            toBeDequed?.next = null
            toBeDequed?.prev = null
            toBeDequed
        } else {
            null
        }
    }

    fun isFull(): Boolean {
        return size == capacity
    }

    fun isEmpty(): Boolean {
        return size == 0
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */