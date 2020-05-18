import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {
        return x.data - y.data;
    }
}
public class Main {
    public static void PhoneNumber(HuffmanNode root, String s)
    {
        if (root.left
                == null
                && root.right
                == null
                && Character.isLetter(root.c)) {

            // c is the character in the node
            System.out.println(root.c + ":" + s);

            return;
        }
        Random random=new Random();
        int ans=random.nextInt(9);  // if we go to left then add "the random number " to the code.
        int ans2=random.nextInt(9);   // if we go to the right add"another random number" to the code.

        PhoneNumber(root.left, s + ans);
        PhoneNumber(root.right, s + ans2);
    }
    // main function
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        // number of characters.
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter number  of service");
        int  Max= scanner.nextInt();
        char service[]=new char[Max];
        System.out.println("enter service");
        String inp=scanner.next();
        for (int i=0;i<Max;i++){
            service[i] = inp.charAt(i);
        }
        int[] freq =new int[Max];
        System.out.println("enter freq");
        for (int i=0;i<Max;i++){
            freq[i]=scanner.nextInt();
        }
        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>(Max, new MyComparator());

        for (int i = 0; i < Max; i++) {
            // add it to the priority queue.
            HuffmanNode huffmanNode = new HuffmanNode();

            huffmanNode.c = service[i];
            huffmanNode.data = freq[i];

            huffmanNode.left = null;
            huffmanNode.right = null;
            q.add(huffmanNode);
        }

        // create a root node
        HuffmanNode root = null;
        // all the nodes are extracted.
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        // print the codes by traversing the tree
        PhoneNumber(root, "");
    }
}

