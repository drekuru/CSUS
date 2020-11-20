public class Lqueue
{
    private Node head;
    private Node tail;
    private int n;

    private class Node
    {
        int item;
        Node next;
    }

    //constructor
    public Lqueue()
    {
        head = null;
        tail = null;
        n = 0;
    }

    public void enqueue(int item)
    {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if(isEmpty())
        {
            head = tail;
        }
        else
        {
            oldTail.next = tail;
        }
        n++;
    }

    public int dequeue()
    {
        if(n==0)
        {
            return -1;
        }
        int ret = head.item;
        head = head.next;
        if(isEmpty())
        {
            tail = null;
        }
        n--;
        return ret;
    }

    public int peek()
    {
        if(n == 0)
        {
            return -1;
        }
        return head.item;
    }

    public boolean isEmpty()
    {
        return head==null;
    }

    public void clear()
    {
        head = tail = null;
        n = 0;
    }
}



public class Fqueue
{
    //FIELDS
    private int [] a;
    private int head;
    private int tail;
    private int n;

    //CONSTRUCTOR
    public Fqueue()
    {
        q = new int[256];
        head = tail = n = 0;
    }

    public void enqueue(int item)
    {
        if(size()==a.length)
        {
            return;
        }
        if(tail >= a.length)
        {
            tail = 0;
        }
        a[tail] = item;
        tail++;
        n++;
    }

    public int dequeue()
    {
        if(isEmpty())
        {
            return -1;
        }
        int ret = a[head];
        head++;
        n--;
        if(head>=a.length)
        {
            head = 0;
        }
        return ret;
    }

    public int peek()
    {
        if(isEmpty())
        {
            return -1;
        }
        return a[head];
    }

    public boolean isEmpty()
    {
        return size() == 0;
        //return head == tail;        
    }

    public int size()
    {
        return n;
    }
}