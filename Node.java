package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sachin on 7/1/2018.
 */
public class Node
{
   public int data;
    public Node left,right;
    public Node(int data)
    {
        this.data=data;
        left=null;right=null;
    }
    public int  getData()
    {
        return data;
    }
    public void setData(int data)
    {
        this.data=data;
    }
    public Node getLeft() {
        return this.left;
    }
    public void  setLeft(Node node)
    {
         this.left=left;
    }
    public Node getRight()
    {
        return this.right;
    }
    public void setRight(Node node)
    {
        this.right=right;
    }

    public static Node insert(int i, Node root) {
        if(root ==null)return new Node(i);
        else {

            Queue<Node>q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty())
            {
                    Node temp=q.poll();
                if(temp.left==null)
                {
                    temp.left=new Node(i);
                    return root;
                }
                else q.offer(temp.left);

                if(temp.right==null)
                {
                    temp.right=new Node(i);
                    return temp;
                }

                else q.offer(temp.right);
            }
        }
           return root;
    }
}
