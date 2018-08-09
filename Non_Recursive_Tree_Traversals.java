package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sachin on 7/2/2018.
 */
public class Non_Recursive_Tree_Traversals {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(17,root);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(30,root);
        System.out.println("PREORDER TRAVERSAL OF GIVEN TREE\t");
        non_preorder(root);
        System.out.println("\nINORDER TRAVERSAL OF GIVEN TREE\t");
        non_inorder(root);
        System.out.println("\nPOSTORDER TRAVERSAL OF GIVEN TREE\t");
        non_postorder(root);
        System.out.println("\nLEVEL ORDER TRAVERSAL OF GIVEN TREE\t");
        level(root);
        System.out.println("\n INORDER SECOND EASY WAY ");
        new_inorder(root);
    }

    private static void new_inorder(Node root) {
        if(root==null)return;
        Stack<Node>s=new Stack<>();
        Node c=root;
        while (!s.isEmpty() ||c!=null)
        {
            if(c!=null)
            {
                s.push(c);
                c=c.left;
            }
            else
            {
                Node f=s.pop();
                System.out.print(f.data+" ");
                c=f.right;
            }

        }
    }

    public static void level(Node root) {
        if(root==null) System.out.println("no such tree node");
        else {

            Queue<Node> q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty())
            {
                Node temp=q.poll();
                System.out.print(temp.data+"\t");
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);

            }

        }
    }

    private static void non_postorder(Node root) {
        if (root==null)return;
        Stack<Node>st=new Stack<>();
        st.push(root);
        Node c=root;
        while(!st.isEmpty() || c!=null)
        {
            if(c!=null)
            {
                st.push(c);
                st.push(c.right);
                c=c.left;
            }
            else {
                Node f=st.pop();
               
                /*if(g.right!=null)
                c=g.right;
                System.out.println(g.data);*/
            }
        }

    }

    private static void non_inorder(Node root) {
        if(root==null) System.out.println("no such tree");

        else {
            Boolean complete =false;
            Stack<Node>st=new Stack<>();
           Node live_node=root;
           while(!complete)
           {

               if(live_node!=null)
               {
                   st.push(live_node);
                   live_node=live_node.left;

               }
               else {
                   //now 2 condition either after getting live_node as null we can have our process complete means empty stack
                   //or there might be no left nodes then we will pop 1 node means parent and go to its right side
                   //and see its left children

                   if(st.isEmpty())complete=true;
                   else {
                       live_node = st.pop();
                       System.out.print(live_node.data+"\t");
                       live_node=live_node.right;
                   }
               }
           }
        }

    }

    private static void non_preorder(Node root) {
        if(root==null) System.out.println("no such tree");

        else {
            Stack<Node>st=new Stack<>();
            st.push(root);
            while(!st.isEmpty())
            {
                Node temp=st.pop();
                System.out.print(temp.data+"\t");
                //see whether it has right child
                if(temp.right!=null)
                    st.push(temp.right);
                if(temp.left!=null)
                    st.push(temp.left);
            }
        }

    }
}
