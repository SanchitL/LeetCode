package com.luthra.solutions;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

import com.luthra.util.ListNode;

public class MergeSortedLists {
    public static ListNode mergeTwoSortedLists (ListNode l1, ListNode l2) {

        ListNode resultHead = null;
        ListNode resultCurrent = resultHead;

        while (l1 != null && l2 != null) {
            int toAdd;
            if (l1.val > l2.val) {
                toAdd = l2.val;
                l2 = l2.next;
            } else if (l2.val > l1.val) {
                toAdd = l1.val;
                l1 = l1.next;
            } else {
                // Add both to list as they are equal
                toAdd = -1;
            }

            if (toAdd >= 0) {
                resultCurrent = new ListNode(toAdd);
            } else {
                resultCurrent = new ListNode(l1.val);
                resultCurrent.next = new ListNode(l2.val);
                resultCurrent = resultCurrent.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            resultCurrent = resultCurrent.next;
        }

        if (l2 != null) {
            while (l2 != null) {
                resultCurrent = new ListNode(l2.val);
                l2 = l2.next;
                resultCurrent = resultCurrent.next;
            }
        } else if (l1 != null) {
            while (l1 != null) {
                resultCurrent = new ListNode(l1.val);
                l1 = l1.next;
                resultCurrent = resultCurrent.next;
            }
        }

        return resultHead;
    }
}