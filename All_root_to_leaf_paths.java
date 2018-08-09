package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sachin on 7/1/2018.
 */
public class All_root_to_leaf_paths {
    public static void main(String[] args) {
      Node root=new Node(1);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(17,root);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(30,root);
        LinkedList<Node>l=new LinkedList<>();
        find_all_root_to_leaf_paths(root,l,0);

    }


    private static void print_paths(LinkedList<Node> l) {
        for (int i = 0; i <l.size() ; i++) {
            System.out.print(l.get(i).data+"\t");
        }
        System.out.println();
    }

    private static void find_all_root_to_leaf_paths(Node root, LinkedList<Node> l, int index_path) {

            if(root==null) System.out.println("NO PATHS !");
            else {

                //do a variant of pre order store root in list/stack then see left and right subtree
                l.add(index_path,root);
                index_path++;
                if(root.left==null&& root.right==null)
                {System.out.println("root to leaf of " + root.data + " is " ); print(l,index_path);

                }
                else {
                    if(root.left!=null)find_all_root_to_leaf_paths(root.left, l, index_path);
                    if(root.right!=null) find_all_root_to_leaf_paths(root.right, l, index_path);
                }


            }

    }

    private static void print(LinkedList<Node> l, int index_path) {
    //here we will print complete path

        for (int i = 0; i <index_path ; i++) {
            System.out.print(l.get(i).data+"\t");
        }
        System.out.println();
    }
}
