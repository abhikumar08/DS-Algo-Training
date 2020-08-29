class Node(value: Int) {
    val value = value
    var next: Node? = null
}

class RemoveNthNodeFromEnd {

    fun removeNthFromEnd(head: Node?, n: Int): Node? {
        var len = 0
        var pointer = head
        if (head != null)
            len++
        while (pointer?.next != null) {
            len++
            pointer = pointer.next
        }
        var i = 1
        pointer = head
        while (pointer != null) {
            if (len - i == n) {
                pointer.next = pointer.next.next
                return head
            } else if (n == len) {
                val temp = pointer.next
                pointer = null
                return temp
            }
            pointer = pointer.next
            i++
        }
        return head
    }
}

