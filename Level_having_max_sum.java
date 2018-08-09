package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sachin on 7/1/2018.
 */
public class Level_having_max_sum {
    public static void main(String[] args) {
        Node root=new Node(31);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(1,root);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(30,root);
        getLevelSum(root);
    }

    private static void getLevelSum(Node root) {
    if(root ==null) System.out.println("NO SUM BABY!");
        else {
        int l_sum=-1;
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        int level=0;
        int f_level=0;

        while(!q.isEmpty())
        {
            int count=0;
            level++;
            int loop=q.size();//this is important step as queue size will get updated in loop and as a result answer will be wrong
            for (int i = 0; i < loop; i++) {
                Node temp=q.poll();
                count+=temp.getData();

                if(temp.left!=null)q.offer(temp.left);//queue size updates so cant use q.size in loop
                if(temp.right!=null)q.offer(temp.right);
            }
            System.out.println("sum at level " + level + "is " + count);
            if(count >l_sum) {
                l_sum = count;
                f_level = level;
            }

        }

        System.out.println("SO! MAXIMUM SUM IS " + l_sum + " AT LEVEL " + f_level);

    }

    }


}
