import java.util.*;

public class Dijk {
    public static List<Node> nodes = new ArrayList<Node>();

    public static HashMap<Integer, int[]> nodeConnections = new HashMap<>();
    public static HashSet<Integer> nodesVisited = new HashSet<Integer>();

    public static void main(String[] args) {
        setBoard();
        new Dijk().start(0, 5);
        new Dijk().start(5, 0);
        new Dijk().start(1, 4);

    }

    public static void setBoard() {
        nodes.add(new Node(0.9f,0.1f));
        nodes.add(new Node(7f,0.9f));
        nodes.add(new Node(8f,0.9f));
        nodes.add(new Node(10f,40f));
        nodes.add(new Node(10f,9f));
        nodes.add(new Node(2f,40f));
        nodeConnections.put(0, new int[]{1, 2});
        nodeConnections.put(1,new int[]{3, 0,});
        nodeConnections.put(2,new int[]{1, 2, 4});
        nodeConnections.put(3,new int[]{ 1,5});
        nodeConnections.put(4,new int[]{2,5});
        nodeConnections.put(5,new int[]{4,3});
    }

    public void resetVisited() {
        nodesVisited.add(0);
        nodesVisited.add(1);
        nodesVisited.add(2);
        nodesVisited.add(3);
        nodesVisited.add(4);
        nodesVisited.add(5);
    }

    public void start(int startNode, int end) {
        resetVisited();
        nodesVisited.remove(startNode);
        int currNode = startNode;
        double[] distances = new double[6];
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        int[] prev = new int[nodes.size()];
        distances[startNode] = 0.0;
        while(!nodesVisited.isEmpty()) {
            Node currAccNode = nodes.get(currNode);
            int[] currentConnect = nodeConnections.get(currNode);
            for(int node : currentConnect) {
                double dist = currAccNode.distTo(nodes.get(node)) + distances[currNode];
                if(dist < distances[node]) {
                    distances[node] = dist;
                    prev[node] = currNode;
                }
            }
            double lowestDif = Double.POSITIVE_INFINITY;
            int nextNode = 0;
            for(int i = 0; i < nodes.size(); i++) {
                if(distances[i] < lowestDif && nodesVisited.contains(i)) {
                    lowestDif = distances[i];
                    nextNode = i;
                }
            }
            currNode=nextNode;
            nodesVisited.remove(currNode);
        }

        System.out.println("\n\nThe distance from the start to end node is : " + distances[end]);

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
