package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sachin on 7/1/2018.
 */
public class Width {


    public static void main(String[] args) {
        Node root=new Node(20);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(31,root);
        Node.insert(12,root);
        Node.insert(34,root);
        Node.insert(2,root);
        Node.insert(1,root);
        Node.insert(3,root);

        System.out.println("WIDTH IS " + width(root));
    }

    private static int width(Node root) {
        if(root==null)return 0;

        else {
            Queue<Node>q=new LinkedList<>();q.offer(root);
            int width=-1;
            while(!q.isEmpty())
            {
                System.out.println(q.size());
                width=Math.max(width,q.size());
                //here q.size is actually tells number of nodes at that level
                    int loop=q.size();//this has to be stored otherwise if i<st.size in loop will cause havoc
                //as queue size is updated in loop
                for(int i=0;i<loop;i++)
                {
                    Node temp=q.remove();
                    if(temp.left!=null)q.offer(temp.left);//queue size updated thats why if i<q.size() will give incorrect
                    if(temp.right!=null)q.offer(temp.right);


                }

            }
            return width;
        }


    }
}
