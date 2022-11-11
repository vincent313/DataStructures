

public class SingleLinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public SingleLinkedList() {
        head=null;
        tail=null;
        size=0;
    }

    //insert node
    public void insert(int index,String value){
        ListNode node=new ListNode(index,value);
        if (size==0){
            this.head=node;
            this.tail=node;
            size++;
        }else{
            this.tail.addNext(node);
            this.tail=node;
            size++;
        }
    }
// find node and insert new node
    public void insert(int insertNode,int index, String value){
        //list is empty
        if (size==0){
            System.out.println("linked list is empty,cant find insert node: "+insertNode);
            return;
        }
        ListNode newNode=new ListNode(index,value);
        ListNode current=head;
        while(current!=null){
            //insert node
            if(current.index==insertNode){
                //if its the last node
                if (current.nextIsNull()){
                    tail=newNode;
                }
                current.addNext(newNode);
                size++;
                return;
            } else{
                current=current.next;
            }
        }

        System.out.println("cant find insert node :"+insertNode);

    }

    public void deleteByIndex(int index){
        if(size==0){
            System.out.println("delete fail ,list is empty");
            return;
        }
        //if delete node is the head
        ListNode current=head;
        if (current.index==index){
            if (size==1){
                size--;
                head=null;
                tail=null;
                return;
            }
            head=current.next;
            size--;
        }

        while(current.next!=null){
            if(current.next.index==index){
                if(current.next==tail){
                    tail=current;
                }
                current.deleteNext();
                size--;
                return;
            }else{
                current=current.next;
            }
        }

        System.out.println("cant find delete node");
        return;

    }

    public String query(int index){
        ListNode node=iterateList(index);

        if (node==null){
            return "node not found";
        }else{
            return node.toString();
        }
    }

    public boolean update(int index,String str){
        ListNode node=iterateList(index);
        if (node==null){
            return false;
        }else{
            node.value=str;
            return true;
        }
    }

    public ListNode iterateList(int index){
        ListNode current=head;
        while(current!=tail){
            if(index== current.index){
                return current;
            }
            current=current.next;
        }
        if (current==head){return current;}
        return null;
    }

    public int getSize(){

        return size;
    }

    public String getHead(){
        if (head==null){
            return "head node not found";
        }
        return head.toString();
    }

    public String getTail(){
        if(tail==null){
            return "tail node not found";
        }
        return tail.toString();
    }

    public void showList(){
        ListNode current=head;
        while(current!=tail){
            System.out.println(current.toString());
            current=current.next;
        }
        System.out.println(current.toString());
        System.out.println("current size "+ getSize());
    }
    private class ListNode{
        private int index;
        private String value;
        private ListNode next;

         ListNode(int index,String value) {
            this.index = index;
            this.value=value;
        }


        boolean nextIsNull(){
             if (next==null){
                 return true;
             }else{
                 return false;
             }
        }

        void addNext(ListNode node){
             if (nextIsNull()){
                 next=node;
             }else {
                 node.next=this.next;
                 this.next=node;
             }
        }

        void deleteNext(){
             if (next.nextIsNull()){
                 this.next=null;
             }else{
                 this.next=next.next;
             }
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "index=" + index +
                    ", value='" + value + '\'' +
                    '}';
        }
    }


}
