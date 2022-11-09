
 
class ListNode 
{
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Driver 
{
    public static void display(ListNode n)
    {
        for(ListNode ln = n; ln != null; ln = ln.next)
        {
            System.out.print(ln.val + ", ");
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode HEAD = new ListNode();
        ListNode n = HEAD;

        int num = 0;
        while(l1 != null || l2 != null)
        {
            if(l1 != null)
            {
                num += l1.val;
                l1 = l1.next;
            }

            if(l2 != null)
            {
                num +=  l2.val;
                l2 = l2.next;
            }

            n.val = num % 10;
            num = (num >= 10) ? 1 : 0;

            if(l1 != null || l2 != null)
            {
                n.next = new ListNode(0);
                n = n.next;
            }
        }

        if(num != 0)
        {
            n.next = new ListNode(num);
        }

        return HEAD;
    }

    public static void main(String[] args) 
    {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        display(l1);
        display(l2);
        display(addTwoNumbers(l1, l2));
        // Explanation: 342 + 465 = 807.    
    }
}