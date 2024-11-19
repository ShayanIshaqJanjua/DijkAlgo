import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dijk {
    public static List<Node> nodes = new ArrayList<Node>();

    public static List<int[]> nodeConnections = new ArrayList<>();
    public static HashSet<Integer> nodesVisited = new HashSet<Integer>();

    public static void main(String[] args) {
        setBoard();
        new Dijk().start(0, 5);
    }

    public static void setBoard() {
        nodes.add(new Node(0.9f,0.1f));
        nodes.add(new Node(7f,0.9f));
        nodes.add(new Node(8f,0.9f));
        nodes.add(new Node(10f,40f));
        nodes.add(new Node(10f,9f));
        nodes.add(new Node(2f,40f));
        nodeConnections.add(new int[]{0, 1});
        nodeConnections.add(new int[]{0, 2});
        nodeConnections.add(new int[]{1, 2});
        nodeConnections.add(new int[]{2, 1});
        nodeConnections.add(new int[]{2, 3});
        nodeConnections.add(new int[]{2, 4});
        nodeConnections.add(new int[]{2, 5});
        nodeConnections.add(new int[]{3, 2});
    }

    public void start(int startNode, int end) {
        nodesVisited.add(0);


    }

}
