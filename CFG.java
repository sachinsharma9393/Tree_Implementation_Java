package trees;

/**
 * Created by sachin on 7/14/2018.
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) throws IOException
    {
        //code
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        String ta[]= new String[t];
        for(int i=0;i<t;i++)
        {
            int s=Integer.parseInt(br.readLine());
            Integer pre[]= new Integer[s];
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<s;j++)
            {
                pre[j]=Integer.parseInt(st.nextToken());
            }
            Integer in[]=Arrays.copyOf(pre,pre.length);
            Arrays.sort(in);
          ta[i]=  print(pre,in);
        }
        for (int i = 0; i <t ; i++) {
            System.out.println(ta[i]);
        }

    }

    private static String print(Integer[] pre, Integer[] in) {
        int k=pre[0];
       int index=-1;
        for(int i=0;i<in.length;i++)
        {
            if(k==in[i])
            {
                index=i;
            }
        }

        //now we see property of bst that root value is greater than left subtree
        //so in preorder array check pre[1] to pre[index] should be less than pre[0] otherwise bst cannot be formed

        for (int i = 1; i <=index ; i++) {
            if(pre[0]<pre[i])return "NO";
        }
        Arrays.sort(in, 0, index,Collections.reverseOrder());

        Arrays.sort(in, index , in.length, Collections.reverseOrder());
        String s="";
        for (int i = 0; i <in.length ; i++) {
            if(i==in.length-1)
            s+=in[i];
            else s+=in[i]+" ";
        }
        return s;
    }

}