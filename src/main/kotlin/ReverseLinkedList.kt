class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        return if (head?.next == null){
            head
        }else {
            val newHead = reverseList(head.next)
            head.next?.next = head
            head.next = null
            newHead
        }
    }
}