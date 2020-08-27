class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val node1 = Node(1)
            val node2 = Node(2)
            val node3 = Node(3)
            val node4 = Node(4)
            val node5 = Node(5)

            val node31 = Node(3)
            val node32 = Node(3)
            val node6 = Node(6)

            node1.next = node2
            node2.prev = node1
            node2.next = node3
            node3.prev = node2
            node3.next = node4
            node4.prev = node3
            node4.next = node5
            node5.prev = node4

            val list = DoublyLinkedList()
            list.setHead(node1)
            list.setTail(node5)

            list.setHead(node4)
            list.setTail(node6)
            list.insertBefore(node6, node3)
            list.insertAfter(node6, node31)
            list.insertAtPosition(1, node32)
            list.removeNodesWithValue(3)
            list.remove(node2)
            list.printList()

        }
    }
}

class Node(value: Int) {
    val value = value
    var prev: Node? = null
    var next: Node? = null
}

class DoublyLinkedList() {

    private var head: Node? = null
    private var tail: Node? = null

    fun printList() {
        var pointer: Node? = head
        while (pointer != null) {
            print(pointer.value.toString() + " ")
            pointer = pointer.next
        }
    }

    fun setHead(node: Node) {
        if (head == null) {
            head = node
        } else if (node.next == null && node.prev == null) {
            head?.prev = node
            node.next = this.head
            head = node
        } else {
            var pointer: Node? = head;
            while (pointer != null) {
                if (pointer == node) {
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

    fun setTail(node: Node) {
        if (tail == null) {
            tail = node
        } else if (node.next == null && node.prev == null) {
            tail?.next = node
            node.prev = tail
            tail = node
        } else {
            var pointer: Node? = head;
            while (pointer != null) {
                if (pointer == node) {
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

    fun insertBefore(node: Node, nodeToInsert: Node) {
        if (node == head)
            setHead(nodeToInsert)
        else if (nodeToInsert.prev == null && nodeToInsert.next == null) {
            val temp = node.prev
            node.prev = nodeToInsert
            nodeToInsert.next = node
            nodeToInsert.prev = temp
            temp?.next = nodeToInsert
        } else {
            remove(nodeToInsert)
            val temp = node.prev
            node.prev = nodeToInsert
            nodeToInsert.next = node
            nodeToInsert.prev = temp
            temp?.next = nodeToInsert
        }

    }

    fun insertAfter(node: Node, nodeToInsert: Node) {
        if (node == tail)
            setTail(nodeToInsert)
        else if (nodeToInsert.next == null && nodeToInsert.prev == null) {
            val temp = node.next
            node.next = nodeToInsert
            nodeToInsert.next = temp
            nodeToInsert.prev = node
            temp?.prev = nodeToInsert
        } else {
            remove(nodeToInsert)
            val temp = node.next
            node.next = nodeToInsert
            nodeToInsert.next = temp
            nodeToInsert.prev = node
            temp?.prev = nodeToInsert
        }

    }

    fun insertAtPosition(position: Int, nodeToInsert: Node) {


        if (nodeToInsert.next != null || nodeToInsert.prev != null) {
            remove(nodeToInsert)
        }
        var pointer: Node? = head;
        val i = 1;
        while (pointer != null) {
            if (position == i) {
                insertBefore(pointer, nodeToInsert)
                break
            }
            pointer = pointer.next
        }
    }

    fun removeNodesWithValue(value: Int) {
        var pointer: Node? = head;
        while (pointer != null) {
            pointer = if (pointer.value == value) {
                val nextNode = pointer.next
                remove(pointer)
                nextNode
            } else {
                pointer.next

            }

        }

    }

    fun remove(node: Node) {
        if (node == head && node.next != null) {
            val tempNext = node.next
            node.next = null
            head = tempNext
            head?.prev = null
        } else if (node == tail && node.prev != null) {
            val tempNext = node.prev
            node.prev = null
            tail = tempNext
            tail?.next = null
        } else {
            val prev = node.prev
            val next = node.next
            prev?.next = next
            next?.prev = prev
            node.prev = null
            node.next = null
        }

    }

    fun containsNodeWithValue(value: Int): Boolean {
        var pointer: Node? = head
        while (pointer != null) {
            if (pointer.value == value) {
                return true
            }
            pointer = pointer.next
        }
        return false
    }

    fun getHead(): Node? {
        return this.head
    }

    fun getTail(): Node? {
        return this.tail
    }
}