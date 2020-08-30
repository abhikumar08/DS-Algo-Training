class MergeTwoSortedList {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var pointer1: ListNode? = l1 ?: return l2
        var pointer2: ListNode? = l2 ?: return l1
        val newHead: ListNode?
        if (pointer1?.value!! < pointer2?.value!!) {
            newHead = pointer1
            pointer1 = pointer1.next
        } else {
            newHead = pointer2
            pointer2 = pointer2.next
        }
        var newListPointer = newHead
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == null){
                newListPointer?.next = pointer2
                pointer2 = pointer2?.next
                newListPointer = newListPointer?.next
                continue
            } else if (pointer2 == null){
                newListPointer?.next = pointer1
                pointer1 = pointer1.next
                newListPointer = newListPointer?.next
                continue
            }else if (pointer1.value < pointer2.value) {
                newListPointer?.next = pointer1
                pointer1 = pointer1.next
                newListPointer = newListPointer?.next
            } else {
                newListPointer?.next = pointer2
                pointer2 = pointer2.next
                newListPointer = newListPointer?.next
            }

        }
        return newHead
    }
}