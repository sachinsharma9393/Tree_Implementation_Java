package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by sachin on 1/9/2018.
 */

class Nodes
{
    int data;
    Nodes right;
    Nodes left;

    public Nodes(int i) {
        data=i;
        right=null;left=null;
    }
}
public class Diameter_Tree {
    int size;
    Vector<Nodes> tree;
    public Diameter_Tree(int size) {


            this.size=size;
            tree=new Vector<>();
            for (int i = 0; i <size ; i++) {
                tree.add(new Nodes(i));
            }
            double loop=Math.ceil(size/2)-1;
            System.out.println(Math.ceil(loop));
            for (int i = 0; i <=Math.ceil(loop) ; i++) {
                tree.get(i).left=tree.get(2*i+1);
                if(2*i+2>size-1)//condition when index start from 0 and last element can be a problem
                    break;
                tree.get(i).right=tree.get(2*i+2);
            }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of Binary treee");
        int size= Integer.parseInt(br.readLine());
        Diameter_Tree st= new Diameter_Tree(size);
        st.find_Diameter();
    }

    private void find_Diameter() {
        //divide the tree into left and right subtrees
        //deepest left sub tree + deepest right sub tree
        int diameter=1+subtree_length(tree.get(0).left)+subtree_length(tree.get(0).right);
        System.out.println("DIAMETER OF TREE IS " + diameter);
    }

    private int subtree_length(Nodes temp) {
        int l=1;
        //perform bfs/level order traversal
        ArrayList<Nodes> queue=new ArrayList<>();
        queue.add(temp);
        while (!queue.isEmpty())
        {
            Nodes n=queue.remove(0);
            if(n.left!=null)queue.add(n.left);
            if(n.right!=null)queue.add(n.right);
            if(n.right!=null|n.left!=null )l++;
        }
        return l;
    }

}
