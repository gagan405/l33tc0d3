package `in`.minbox.linkedlists

import org.junit.jupiter.api.Test

class GeneralLinkedListProblemsTest {

    @Test
    fun swapPairs() {
        val list1 = ListNode(1)
        list1.next = ListNode(2)
        list1.next!!.next = ListNode(3)

        GeneralLinkedListProblems.swapPairs(list1)
    }

    @Test
    fun swapPairsRecursive() {
        val list1 = ListNode(1)
        list1.next = ListNode(2)
        list1.next!!.next = ListNode(3)

        GeneralLinkedListProblems.swapPairsRecursive(list1)
    }
}