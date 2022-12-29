import javax.naming.LinkRef;
import java.util.*;
public class Main {
    public static class Node {
        int data;
        Node next;
    }


    public static class LinkedList {
        Node head;
        Node tail;
        int size;


        public void addFirst(int data) {
            Node node = new Node();
            node.data = data;

            if(this.size == 0) {
                this.head = this.tail = node;
            } else {
                node.next = this.head;
                this.head = node;
            }

            this.size++;
        }

        public void addLast(int data) {
            Node node = new Node();
            node.data = data;
            if(this.size == 0) {
                this.head = this.tail = node;
            } else {
                this.tail.next = node;
                this.tail = node;
            }

            this.size++;
        }

        public void addAt(int idx, int val) {
            if(idx < 0 || idx > this.size) {
                System.out.println("Invalid arguments");
                return;
            }


            if(idx == 0) {
                this.addFirst(val);
                return;
            } else if(idx == this.size) {
                this.addLast(val);
                return;
            } else {
                int counter = idx;
                Node tmp = this.head;
                while(counter != 1 ){
                    tmp = tmp.next;
                    counter --;
                }
                Node nbr = tmp.next;
                
                Node node = new Node();
                node.data = val;
                tmp.next = node;
                node.next = nbr;
                this.size++;

            }
        }

        public void removeFirst() {
            if(this.size==0) {
                System.out.println("List is empty");
                return;
            } else if(this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node hnbr = this.head.next;
                this.head.next = null;
                this.head = hnbr;
            }
            this.size--;
        }

        public void removeLast() {
            if(this.size == 0) {
                System.out.println("List is empty");
                return;
            } else if(this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node tmp = this.head;
                while(tmp.next != tail) {
                    tmp = tmp.next;
                }

                tmp.next = null;
                this.tail = tmp;
            }

            this.size --;
        }

        public void removeAt(int idx) {
            if(idx < 0 || idx >= this.size) {
                System.out.println("Invalid arguments");
                return;
            }

            if(idx == 0) {
                this.removeFirst();
                return;
            } else if(idx == this.size-1) {
                this.removeLast();
                return;
            } else {
                Node tmp = this.head;
                Node pre = null;
                int counter = idx;
                while(counter != 0) {
                    pre = tmp;
                    tmp = tmp.next;
                    counter--;
                }

                Node nbr = tmp.next;
                tmp.next = null;
                pre.next = nbr;
            }
            this.size--;
        }

        public void display() {
            if(this.size == 0) {
                return;
            }


            Node tmp = this.head;
            while(tmp != null) {
                System.out.print(tmp.data + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }

        public int size() {
            return this.size;
        }

        public int getFirst(){
            if(this.size==0) {
                System.out.pritnln("List is empty");
                return -1;
            }
            return this.head.data;
        }
      
        public int getLast(){
            if(this.size == 0 ) {
                System.out.println("List is empty");
                return -1;
            }
            return this.tail.data;
        }
      
        public int getAt(int idx){
            if(idx >= this.size || idx < 0) {
                System.out.println("Invalid arguments");
                return -1;
            }
            
            int counter = idx;
            Node node = this.head;
            while(counter != 0) {
                node = node.next;
                counter --;
            }

            return node.data;
        }

        public void reversePI() {

            if(this.size == 0) {

            }

            Node curr = this.head;
            Node pre = null;

            while(curr != null) {
                Node nbr = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nbr;
            }
            Node tmp = this.head;
            this.head = this.tail;
            this.tail = tmp;
        }

        private Node getNode(int idx) {
            int counter = idx;
            Node node = this.head;

            while(counter != 0) {
                node = node.next;
                counter --;
            }

            return node;

        }
        
        public void reverseDI() {
            int i = 0;
            int j = this.size-1;

            while(i<j) {
                Node temp1 = getNode(i);
                Node temp2 = getNode(j);
                
                int temp = temp1.data;
                temp1.data = temp2.data;
                temp2.data = temp;

                i++;
                j--;

            }
        }
    
        public int kthfromLast(int k) {
            Node slow = this.head;
            Node fast = this.head;
            
            int c = k;
            while(c != 0) {
                fast = fast.next;
            }

            while(fast != this.tail) {
                slow = slow.next;
                fast = fast.next;
            }
        }
    
        public int mid() {
            Node slow = this.head;
            Node fast = this.head;

            while(fast.next != this.tail && fast != this.tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList dummy = new LinkedList();
            
            Node p1 = l1.head;
            Node p2 = l2.head;

            while(p1 != null && p2 != null) {
                if(p1.data < p2.data) {
                    dummy.addLast(p1.data);
                    p1 = p1.next;
                } else {
                    dummy.addLast(p2.data);
                    p2 = p2.next;
                }
            }

            while(p1 != null) {
                dummy.addLast(p1.data);
                p1 = p1.next;
            }

            while(p2 != null) {
                dummy.addLast(p2.data);
                p2 = p2.next;
            }
            return dummy;
        }
    
        public static Node mid(Node head, Node tail) {
            Node f = head;
            Node s = head;

            while(f != tail && f.next != tail) {
                s = s.next;
                f = f.next.next;
            }

            return s;
        }

        public static LinkedList mergeSort(Node head, Node tail) {
            if(head == tail) {
                LinkedList bl = new LinkedList();
                bl.addLast(head.data);
                return b1;
            }

            Node mid = mid(head,tail);
            LinkedList fsl = mergeSort(head, mid);
            LinkedList ssl = mergeSort(mid.next, tail);

            return mergeTwoSortedLists(fsl,ssl);
        }

        public void removeDuplicates(){
            Node p1 = this.head;

            while(p1 != null) {
                Node tmp = p1.next;
                while(tmp != null && tmp.data != p1.data) {
                    tmp = tmp.next;
                }
                if(tmp == null) {
                    p1.next = null;
                    return;
                } else {
                    p1.next = tmp;
                    p1 = p1.next;
                }
            }
        }
    
        public void oddEven(){
            Node odd = new Node();
            Node even = new Node();

            Node p1 = odd;
            Node p2 = even;
            Node p = this.head;

            while(p != null) {
                
                if(p.data % 2 == 0 ) {
                    p2.next = p;
                    p2 = p2.next;
                    p = p.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                    p = p.next;
                }
            }  
            p1.next = null;
            p2.next = null;
            
            p1.next = even.next;
            this.head = odd.next;
            this.tail = p2;

        }

        private void displayReverseHelper(Node node){
            if(node == null) return;

            displayReverseHelper(node.next);
            System.out.print(node.data+" ");
        }
      
        public void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }

        private void reversePRHelper(Node node,int floor){
            if(node == null) return;

            reversePRHelper(node.next,floor+1);

            if(floor >= this.size/2){
                int temp = node.data;
                node.data = lnode.data;
                lnode.data = temp;
    
                lnode = lnode.next;
            }
        }

        Node lnode;

        public void reversePR(){
            lnode = this.head;
            reversePRHelper(this.head,0);
            System.out.println();
        }

        public boolean IsPalindrome() {
            lnode = this.head;
            return IsPalindromeHelper(this.head,0);
        }

        private boolean IsPalindromeHelper(Node node,int floor) {
            if(node == null) return true;

            boolean ans = IsPalindromeHelper(node.next,floor+1);
            if(ans == false) {
                return false;
            }

            if(floor >= this.size/2) {
                if(lnode.data != node.data) return false;
                lnode = lnode.next;
            }
            return true;
        }

        public void fold() {
            lnode = this.head;
            foldHelper(this.head,0);

        }

        private void foldHelper(Node right,int floor) {
            if(right == null) return;

            foldHelper(right.next,floor+1);

            if(floor > this.size/2) {
                Node nbr = lnode.next;
                lnode.next = right;
                right.next = nbr;
                lnode = nbr;
            } else if(floor == this.size/2) {
                this.tail = right;
                tail.next = null;
            }

        }

        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            LinkedList ans = new LinkedList();
            int carry = addTwoHelper(one.head, two.head,one.size,two.size,ans);
            if(carry != 0) {
                ans.addFirst(carry);
            }
            return ans;
        }

        public static int addTwoHelper(Node n1, Node n2, int s1, int s2,LinkedList ans) {
            if(n1 == null && n2 == null) {
                return 0;
            }

            int data = 0;
            if(s1 == s2) {
                int oc = addTwoHelper(n1.next, n2.next,s1-1,s2-1);
                data = n1.data + n2.data + oc;
            } else if(s1 > s2){
                int oc = addTwoHelper(n1.next, n2,s1-1,s2);
                data = n1.data + oc;
            } else if(s2 > s1) {
                int oc = addTwoHelper(n1, n2.next,s1,s2-1);
                data = n2.data + oc;
            }

            int nd = data %10;
            int nc = data /10;

            ans.addFirst(nd);
            return nc;

        }
        
        public static int findIntersection(LinkedList one, LinkedList two){
            Node n1 = one.head;
            Node n2 = two.head;

            if(one.size > two.size) {
                int counter = one.size-two.size;
                while(counter != 0) {
                    n1 = n1.next;
                    counter --;
                }
            } else {
                int counter = two.size-one.size;
                while(counter != 0) {
                    n2 = n2.next;
                    counter --;
                }
            }



            while(n1 != n2){

                n1 = n1.next;
                n2 = n2.next;
                
            }

            return n1.data;
        }

        public void kReverse(int k) {
            
            LinkedList pre = null;

            while(this.size != 0) {
                LinkedList curr = new LinkedList();

                if(this.size >= k) {
                    for(int i=0;i<k;i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                } else {
                    int os = this.size;
                    for(int i=0;i<os;i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }

                if(pre == null) {
                    pre = curr;
                } else {
                    pre.tail.next = curr.head;
                    pre.tail = curr.tail;
                    pre.size += curr.size;
                }
            }

            this.head = pre.head;
            this.tail = pre.tail;
            this.size = pre.size;

        }   
    
    }

    public static class LLToStackAdapter {
        LinkedList<Integer> list;
    
        public LLToStackAdapter() {
          list = new LinkedList<>();
        }
    
    
        int size() {
          return list.size();
        }
    
        void push(int val) {
          list.addFirst(val);
        }
    
        int pop() {
          int val = lit.getFirst();
          list.removeFirst();
          return val;
        }
    
        int top() {
          return list.getFirst();
        }
    }

    public static class LLToQueueAdapter {
        LinkedList<Integer> list;
    
        public LLToQueueAdapter() {
          list = new LinkedList<>();
        }
    
        int size() {
          return list.size();
        }
    
        void add(int val) {
          list.addLast(val);
        }
    
        int remove() {
            if(list.size() > 0) {
              int val = list.getFirst();
              list.removeFirst();
              return val;      
            } else {
                System.out.println("Queue underflow");
                return -1;
            }
          
        }
    
        int peek() {
          if(list.size() > 0) {
              int val = list.getFirst();
              return val;      
            } else {
                System.out.println("Queue underflow");
                return -1;
            }
        }
    }

}