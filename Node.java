public class Node {
    private float xPos;
    private float yPos;
    public Node(float x, float y){
        xPos = x;
        yPos = y;
    }
    public double distTo(Node other){
        float dx = xPos - other.xPos;
        float dy = yPos - other.yPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
