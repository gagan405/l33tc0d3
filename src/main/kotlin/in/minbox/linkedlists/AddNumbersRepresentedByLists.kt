package `in`.minbox.linkedlists

object AddNumbersRepresentedByLists {

    // LeetCode problem 2
    // https://leetcode.com/problems/add-two-numbers/description/
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        return addTwoNodes(l1, l2, 0)
    }

    private fun addTwoNodes(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        if (l1 == null && l2 == null) {
            return if (carry != 0)
                ListNode(carry)
            else null
        }

        var sum = 0
        var karry = 0

        if (l1 != null && l2 != null) {
            sum = (l1.`val`+ l2.`val` + carry) % 10
            karry = (l1.`val`+ l2.`val` + carry) / 10
        } else {
            val value = l1?.`val` ?: l2!!.`val`
            sum = (value + carry) % 10
            karry = (value + carry) / 10
        }

        val result = ListNode(sum)
        result.next = addTwoNodes(l1?.next, l2?.next, karry)
        return result
    }
}