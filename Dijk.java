import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Dijk {
    public static List<Node> nodes = new ArrayList<Node>();
    public static HashSet<Node> nodesVisited = new HashSet<Node>();
    public static void main(String[] args) {
        setBoard();
    }

    public static void setBoard() {
        nodes.add(new Node(0.9f,0.1f));
        nodes.add(new Node(7f,0.9f));
        nodes.add(new Node(8f,0.9f));
        nodes.add(new Node(10f,40f));
        nodes.add(new Node(10f,9f));
        nodes.add(new Node(2f,40f));
    }
}
