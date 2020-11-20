//package main;

public class Llist
{
    private Node head;
    private int n;

    private class Node
    {
        String item;
        Node next;
    }
    //Constructor

    public Llist()
    {
        head = null;
        n = 0;
    }

    public void add(int index, String item)
    {
        Node X = new Node();
        X.item = item;
        X.next = null;

        if(head == null)
        {
            if(index != 0)
            {
                return;
            }
            else
            {
                head = X;
                n++;
                return;
            }
        }
        else if(head != null && index == 0)
        {
            X.next =head;
            head = X;
            n++;
            return;
        }
        if(index > n)
        {
            return;
        }

        Node current = head;
        Node previous = null;
        int i = 0;

        while (i<index)
        {
            previous = current;
            current = current.next;
            if(current == null)
            {
                break;
            }
            i++;
        }
        X.next = current;
        previous.next = X;
        n++;
    }

    public boolean contains(String item)
    {
        for(int i = 0; i < n; i++)
        {
            if(get(i).equals(item))
            {
                return true;
            }
            return false;
        }
    }

    public String peek()
    {
        if(head!= null)
        {
            return head.item;
        }
        return "null";
    }

    public String get(int index)
    {
        if(index > n- 1)
        {
            return "Invalid Index";
        }

        if(index == 0)
        {
            return head.item;
            Node cur = head;
            int i = 0;
            while ( i < index)
            {
                cur = cur.next;
                i++;
            }
            return cur.item;
        }
    }

    public void clear()
    {
        head = null;
        n = 0;
    }

    public void remove(int index)
    {
        if(index > n - 1)
        {
            return;
        }
        if(head != null && index == 0)
        {
            head = head.next;
            n--;
            return;
        }

        //else
        Node current = head;
        Node previous = null;
        int i = 0;

        while( i < index)
        {
            previous = current;
            current = current.next;
            if(current == null)
            {
                break;
            }
            i++;
        }
        previous.next = current.next;
        n--;
    }

}//end of class