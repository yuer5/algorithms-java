package ashley.learning.algorithm.graph.dijkstra;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuer5 on 16/5/18.
 */
public class GVNode {

    private String name;

    private Map<GVNode,Integer> neighbor = new HashMap<GVNode,Integer>();    //edge with weight;

    private int distance;

    private GVNode piNode;

    public GVNode(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<GVNode, Integer> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(Map<GVNode, Integer> neighbor) {
        this.neighbor = neighbor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public GVNode getPiNode() {
        return piNode;
    }

    public void setPiNode(GVNode piNode) {
        this.piNode = piNode;
    }
}
