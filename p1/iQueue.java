//Mark Garrett
//CSCI 433
//PA1
//
public class iQueue{
        public element tail;
        public element head;
        public int size;
        iQueue(){
            tail=null;
            head=null;
            size=0;
        }
        public void add(int item){
            element e = new element(item);
            if(head==null){
                head=e;
            }
            if(tail!=null){
                tail.setNext(e);
            }
            tail=e;
            size++;
        }
        public boolean NotEmpty(){
            return size>=1;
        }
        public int remove(){
            int out = head.getValue();
            head = head.getNext();
            size--;
            if(size==0){
                tail=null;
            }
            return out; 
        }
        public class element{
            element next;
            int value;
            element(int val){
                next=null;
                value=val;
            }
            void setNext(element e){
                next=e;
            }
            element getNext(){
                return next;
            }
            void setValue(int val){
                value=val;
            }
            int getValue(){
                return value;
            }
        }
    }