package `in`.minbox.linkedlists

object GeneralLinkedListProblems {
    // 1 -> 2 -> 3 -> 4 becomes 2 -> 1 -> 4 -> 3
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head

        var prev = head
        var cur = head.next;
        val newHead = head.next

        var tail: ListNode? = null

        while(cur != null) {
            val tmp = cur.next
            prev!!.next = cur.next
            cur.next = prev

            tail = prev

            if (tmp != null) {
                prev = tmp
                cur = tmp.next
            } else {
                break
            }

            if (cur != null)
                tail.next = cur
        }
        return newHead
    }


    fun swapPairsRecursive(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val nextSwap = head.next!!.next
        val newHead = head.next

        newHead!!.next = head
        head.next = swapPairsRecursive(nextSwap)
        return newHead
    }
}