class ListNode(var value: Int) {
    var next: ListNode? = null
}

class LinkedListCycleDetection {
    fun hasCycle(head: ListNode?): ListNode? {
        head?.let {
            var pointer: ListNode? = it
            var fastPointer: ListNode? = it
            while (pointer?.next != null && fastPointer?.next?.next !=null) {
                pointer = pointer.next
                fastPointer = fastPointer.next?.next
                if (pointer == fastPointer) {
                    fastPointer = head
                    while(pointer!=fastPointer){
                        pointer = pointer?.next
                        fastPointer = fastPointer?.next
                    }
                    return pointer
                }

            }
            return null
        }
        return null
    }
}