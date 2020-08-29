class DoublyLinkedNode(value: Int) {
    val value = value
    var prev: DoublyLinkedNode? = null
    var next: DoublyLinkedNode? = null
}

class DoublyLinkedList() {

    private var head: DoublyLinkedNode? = null
    private var tail: DoublyLinkedNode? = null

    fun setHead(DoublyLinkedNode: DoublyLinkedNode) {
        if (head == null) {
            head = DoublyLinkedNode
        } else if (DoublyLinkedNode.next == null && DoublyLinkedNode.prev == null) {
            head?.prev = DoublyLinkedNode
            DoublyLinkedNode.next = this.head
            head = DoublyLinkedNode
        } else {
            var pointer: DoublyLinkedNode? = head;
            while (pointer != null) {
                if (pointer == DoublyLinkedNode) {
                    remove(pointer)
                    this.head?.prev = pointer
                    pointer.next = this.head
                    this.head = pointer
                    break
                }
                pointer = pointer.next
            }
        }
    }

    fun setTail(DoublyLinkedNode: DoublyLinkedNode) {
        if (tail == null) {
            tail = DoublyLinkedNode
        } else if (DoublyLinkedNode.next == null && DoublyLinkedNode.prev == null) {
            tail?.next = DoublyLinkedNode
            DoublyLinkedNode.prev = tail
            tail = DoublyLinkedNode
        } else {
            var pointer: DoublyLinkedNode? = head;
            while (pointer != null) {
                if (pointer == DoublyLinkedNode) {
                    remove(pointer)
                    this.tail?.next = pointer
                    pointer.prev = this.tail
                    this.tail = pointer
                    break
                }
                pointer = pointer.next
            }
        }
    }

    fun insertBefore(DoublyLinkedNode: DoublyLinkedNode, DoublyLinkedNodeToInsert: DoublyLinkedNode) {
        if (DoublyLinkedNode == head)
            setHead(DoublyLinkedNodeToInsert)
        else if (DoublyLinkedNodeToInsert.prev == null && DoublyLinkedNodeToInsert.next == null) {
            val temp = DoublyLinkedNode.prev
            DoublyLinkedNode.prev = DoublyLinkedNodeToInsert
            DoublyLinkedNodeToInsert.next = DoublyLinkedNode
            DoublyLinkedNodeToInsert.prev = temp
            temp?.next = DoublyLinkedNodeToInsert
        } else {
            remove(DoublyLinkedNodeToInsert)
            val temp = DoublyLinkedNode.prev
            DoublyLinkedNode.prev = DoublyLinkedNodeToInsert
            DoublyLinkedNodeToInsert.next = DoublyLinkedNode
            DoublyLinkedNodeToInsert.prev = temp
            temp?.next = DoublyLinkedNodeToInsert
        }

    }

    fun insertAfter(DoublyLinkedNode: DoublyLinkedNode, DoublyLinkedNodeToInsert: DoublyLinkedNode) {
        if (DoublyLinkedNode == tail)
            setTail(DoublyLinkedNodeToInsert)
        else if (DoublyLinkedNodeToInsert.next == null && DoublyLinkedNodeToInsert.prev == null) {
            val temp = DoublyLinkedNode.next
            DoublyLinkedNode.next = DoublyLinkedNodeToInsert
            DoublyLinkedNodeToInsert.next = temp
            DoublyLinkedNodeToInsert.prev = DoublyLinkedNode
            temp?.prev = DoublyLinkedNodeToInsert
        } else {
            remove(DoublyLinkedNodeToInsert)
            val temp = DoublyLinkedNode.next
            DoublyLinkedNode.next = DoublyLinkedNodeToInsert
            DoublyLinkedNodeToInsert.next = temp
            DoublyLinkedNodeToInsert.prev = DoublyLinkedNode
            temp?.prev = DoublyLinkedNodeToInsert
        }

    }

    fun insertAtPosition(position: Int, DoublyLinkedNodeToInsert: DoublyLinkedNode) {


        if (DoublyLinkedNodeToInsert.next != null || DoublyLinkedNodeToInsert.prev != null) {
            remove(DoublyLinkedNodeToInsert)
        }
        var pointer: DoublyLinkedNode? = head;
        val i = 1;
        while (pointer != null) {
            if (position == i) {
                insertBefore(pointer, DoublyLinkedNodeToInsert)
                break
            }
            pointer = pointer.next
        }
    }

    fun removeDoublyLinkedNodesWithValue(value: Int) {
        var pointer: DoublyLinkedNode? = head;
        while (pointer != null) {
            pointer = if (pointer.value == value) {
                val nextDoublyLinkedNode = pointer.next
                remove(pointer)
                nextDoublyLinkedNode
            } else {
                pointer.next

            }

        }

    }

    fun remove(DoublyLinkedNode: DoublyLinkedNode) {
        if (DoublyLinkedNode == head && DoublyLinkedNode.next != null) {
            val tempNext = DoublyLinkedNode.next
            DoublyLinkedNode.next = null
            head = tempNext
            head?.prev = null
        } else if (DoublyLinkedNode == tail && DoublyLinkedNode.prev != null) {
            val tempNext = DoublyLinkedNode.prev
            DoublyLinkedNode.prev = null
            tail = tempNext
            tail?.next = null
        } else {
            val prev = DoublyLinkedNode.prev
            val next = DoublyLinkedNode.next
            prev?.next = next
            next?.prev = prev
            DoublyLinkedNode.prev = null
            DoublyLinkedNode.next = null
        }

    }

    fun containsDoublyLinkedNodeWithValue(value: Int): Boolean {
        var pointer: DoublyLinkedNode? = head
        while (pointer != null) {
            if (pointer.value == value) {
                return true
            }
            pointer = pointer.next
        }
        return false
    }

    fun getHead(): DoublyLinkedNode? {
        return this.head
    }

    fun getTail(): DoublyLinkedNode? {
        return this.tail
    }
}