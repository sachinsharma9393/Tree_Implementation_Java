package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sachin on 12/19/2017.
 */
class Node
{
    int data;
    Node right,left;

    public Node(int i) {
        data=i;
        right=null;left=null;
    }
}
public class Sample_Tree {
    int size;
    Vector<Node>tree;
    Sample_Tree(int  size)
    {
        this.size=size;
        tree=new Vector<>();
        for (int i = 0; i <size ; i++) {
            tree.add(new Node(i));
        }
        double loop=Math.ceil(size/2)-1;
        System.out.println(Math.ceil(loop));
        for (int i = 0; i <=Math.ceil(loop) ; i++) {
            tree.get(i).left=tree.get(2*i+1);
            if(2*i+2>size-1)//condition when index start from 0 and last element can be a problem
                break;
            tree.get(i).right=tree.get(2*i+2);
        }
        bfs_tree(loop);
        System.out.println("pre_order_traversal of your tree ");
        pre_order(tree.get(0));
        System.out.println("in_order_traversal of your tree ");
       in_order(tree.get(0));
        System.out.println("post_order_traversal of your tree ");
        post_order(tree.get(0));


    }

    private int find_size_through_program() {

        ArrayList<Node>queue=new ArrayList<>();
        queue.add(tree.get(0));int count=1;
        while (!queue.isEmpty())
        {
            Node d=queue.get(0);
            queue.remove(0);
            if(d.left!=null)
            {
                queue.add(d.left);
                count++;
            }
            if(d.right!=null)
            {
                queue.add(d.right);
                count++;
            }
        }


        return count;
    }
    public void post_order(Node node) {
       //recursive
        if(node!=null)
        {
            post_order(node.left);
            post_order(node.right);
            System.out.println(node.data);
        }

    }

    public void in_order(Node node) {
        //recursive
        if(node!=null)
        {
            in_order(node.left);
            System.out.println(node.data);
            in_order(node.right);
        }

    }


    public void pre_order(Node node) {
        //recursive
        if(node!=null)
       {
           System.out.println(node.data);
           pre_order(node.left);
           pre_order(node.right);

       }


    }

    private void bfs_tree(double loop) {
        System.out.println("retrieval of nodes just like bfs traversal of tree");
        System.out.println(tree.get(0).data);
        for (int i = 0; i <=Math.ceil(loop) ; i++) {
            System.out.println(tree.get(2 * i + 1).data);
            if(2*i+2>size-1)//condition when index start from 0 and last element can be a problem
                break;
            else System.out.println(tree.get(2 * i + 2).data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of Binary treee");
        int size= Integer.parseInt(br.readLine());
        Sample_Tree st=new Sample_Tree(size);
       int size_p= st.find_size_through_program();
        System.out.println("size finding through program is " + size_p);
        //reverse level order_traversal
        st.find_reverse_level_order();

    }

    private void find_reverse_level_order() {

//logic is to take a stack and queue and in queue place right child first rather than left
        Stack<Node>stack=new Stack<>();//or an array and print reverse
        ArrayList<Node>queue=new ArrayList<>();
        queue.add(tree.get(0));
        stack.add(tree.get(0));
        while (!queue.isEmpty())
        {
            Node n=queue.get(0);
            queue.remove(0);
            if(n.right!=null){
                queue.add(n.right);
                stack.add(n.right);
            }
            if(n.left!=null)
            {
                queue.add(n.left);
                stack.add(n.left);
            }

        }
        System.out.println("now here we go for level order traversal");
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop().data);
        }

    }


}
