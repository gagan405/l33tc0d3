package `in`.minbox.linkedlists

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AddNumbersRepresentedByListsTest {

    @Test
    fun addTwoNumbers() {
        val list1 = ListNode(2)
        list1.next = ListNode(4)
        list1.next!!.next = ListNode(3)

        val list2 = ListNode(5)
        list2.next = ListNode(6)
        list2.next!!.next = ListNode(4)

        val sum = AddNumbersRepresentedByLists.addTwoNumbers(list1, list2)
        assertNotNull(sum)
        assertEquals(7, sum!!.`val`)
        assertEquals(0, sum.next!!.`val`)
        assertEquals(8, sum.next!!.next!!.`val`)
        assertNull(sum.next!!.next!!.next)
    }
}