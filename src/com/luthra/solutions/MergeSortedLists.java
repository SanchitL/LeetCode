package com.luthra.solutions;

import java.util.ArrayList;
import java.util.List;
import com.luthra.util.ListNode;

public class MergeSortedLists {
    public static ListNode mergeTwoSortedLists (ListNode l1, ListNode l2) {

        List<ListNode> merged = new ArrayList<>();

        while (l1 != null && l2 != null) {
            int toAdd;
            if (l1.val >= l2.val) {
                toAdd = l2.val;
                l2 = l2.next;
            } else {
                toAdd = l1.val;
                l1 = l1.next;
            }
            merged.add(new ListNode(toAdd));
        }        

        if (l2 != null) {
            while (l2 != null) {
                merged.add(new ListNode(l2.val));
                l2 = l2.next;
            }
        } else if (l1 != null) {
            while (l1 != null) {
                merged.add(new ListNode(l1.val));
                l1 = l1.next;
            }
        }

        if (merged.size() == 0)
            return null;

        ListNode resultHead = merged.get(0);
        ListNode resultCurrent = resultHead;

        for (int i = 1; i < merged.size(); i++) {
            resultCurrent.next = merged.get(i);
            resultCurrent = resultCurrent.next;
        }

        return resultHead;
    }
}