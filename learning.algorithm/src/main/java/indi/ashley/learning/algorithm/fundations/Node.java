package indi.ashley.learning.algorithm.fundations;

/**
 * Created by yuer5 on 16/5/19.
 */
public class Node {

    private int nodeValue;
    private Node piNode;

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Node getPiNode() {
        return piNode;
    }

    public void setPiNode(Node piNode) {
        this.piNode = piNode;
    }

    public Node(){
    }

    public Node(int nodeValue){
        this.nodeValue = nodeValue;
    }
}
