package trees;

/**
 * Created by sachin on 7/3/2018.
 */
public class Finding_Ancestor_of_node {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(17,root);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(30,root);
        find_Ancestor(root,17);
        find_Ancestor(root,4);
        find_Ancestor(root,30);
    }

    private static boolean find_Ancestor(Node root, int i) {
             /*   if(root==null)return false;
        else {
                    if(root.left.data==i||root.right.data==i||find_Ancestor(root.left,i)||find_Ancestor(root.right,i))
                    {
                        System.out.println(root.data);
                        return true;
                    }
                }

    return false;*/

        //concept similar to root to leaf paths
        int[]v=new int[256];
        boolean b=find(i,root,0,v);
        if(b)return true;
        else return false;
    }

    private static boolean find(int data, Node root, int index,int[]v) {
            if(root==null)return false;
        else {
                v[index++]=root.data;
                if(root.data==data)
                {
                    System.out.println("ANCESTORES OF " + data+"are");
                    print_ancestors(v,index);
                }
                else
                    find(data,root.left,index,v);
                    find(data,root.right,index,v);
            }

    return false;
    }

    private static void print_ancestors(int[] v, int index) {

        for (int i = 0; i <index ; i++) {
            System.out.print(v[i]+"\t");
        }
        System.out.println();}
}
