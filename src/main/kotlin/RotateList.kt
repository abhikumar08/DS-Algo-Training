import kotlin.math.abs

class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var len = 1
        var pointer = head
        while (pointer.next != null) {
            len++
            pointer = pointer.next
        }
        val effectiveShift:Int = if (abs(k) > len) {
            k%len
        } else{
            k
        }
        val breakPoint = if (effectiveShift> 0) {
            len - effectiveShift
        } else {
            abs(effectiveShift)
        }
        var steps = 0
        pointer = head
        while (pointer != null) {
            steps++
            if (breakPoint == steps) {
                val newHead = pointer.next
                pointer.next = null
                var pointer1 = newHead
                while (pointer1 != null) {
                    if (pointer1.next == null) {
                        pointer1.next = head
                        return newHead
                    }
                    pointer1 = pointer1.next
                }
            }
            pointer = pointer.next
        }
        return head
    }
}