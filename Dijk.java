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
        nodeConnections.add(new int[]{1, 2});
        nodeConnections.add(new int[]{3, 0,});
        nodeConnections.add(new int[]{1, 2, 4});
        nodeConnections.add(new int[]{ 1,5});
        nodeConnections.add(new int[]{2,5});
        nodeConnections.add(new int[]{4,3});
        nodesVisited.add(0);
        nodesVisited.add(1);
        nodesVisited.add(2);
        nodesVisited.add(3);
        nodesVisited.add(4);
        nodesVisited.add(5);
    }

    public void start(int startNode, int end) {
        nodesVisited.remove(startNode);
        int currNode = startNode;
        Double[] distances = {Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY};
        int[] prev = new int[nodes.size()];
        distances[startNode] = 0.0;
        Double cumulativeDist = 0.0;
        while(!nodesVisited.isEmpty()) {
            Node currAccNode = nodes.get(currNode);
            int[] currentConnect = nodeConnections.get(currNode);
            for(int node : currentConnect) {
                double dist = currAccNode.distTo(nodes.get(node)) + cumulativeDist;
                if(dist < distances[node]) {
                    distances[node] = dist;
                    prev[node] = currNode;
                }
            }
            Double lowestDif = Double.POSITIVE_INFINITY;
            int nextNode = 0;
            for(int i = 0; i < nodes.size(); i++) {
                if(distances[i] < lowestDif && nodesVisited.contains(i)) {
                    lowestDif = distances[i];
                    nextNode = i;
                }
            }
            cumulativeDist += lowestDif;
            currNode=nextNode;
            nodesVisited.remove(currNode);
        }
        System.out.println(distances[end]);

        int n = end;
        System.out.print("The shortest path between node " + startNode + " and node " + n + " is ");
        /*for(int node :prev){
            System.out.print(node+" ");
        }
        for(Double node : distances){
            System.out.print(node+" ");
        }*/

       while(n!= startNode) {
           System.out.print(n + ", ");
           n = prev[n];
       }
        System.out.print(startNode);

    }




}
