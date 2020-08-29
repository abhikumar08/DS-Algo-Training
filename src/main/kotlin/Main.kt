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

