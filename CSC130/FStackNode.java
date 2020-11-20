public class NStack
{
    private Node head;
    private int n;

    private class Node
    {
        int item;
        Node next;
    }

    //constructor
    public Lstack()
    {
        top = null;
        n = 0;
    }

    public void push(int item)
    {
        Node oldTop = head; //save 
        head = new Node();  //
        head.item = item;   //
        head.next = oldTop; //
        n++;
    }

    public int peek()
    {
        if(n==0)
        {
            return -1;
        }
        return top.item;
    }

    public int pop()
    {
        if(n==0)
        {
            return -1;
        }
        int ret = top.item;
        top = top.next;
        n--;
        return ret;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public int size()
    {
        return n;
    }

    
}