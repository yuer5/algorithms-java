package ashley.learning.algorithm.graph.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuer5 on 16/5/18.
 */
public class AlgDijkstra {

    //源点集合
    public Set<GVNode> sNodes;
    //最小距离优先队列 V[G]
    Map<GVNode,Integer> qDistance;

    public GVNode sourceNode = null;

    public Set<GVNode> nodes = null;

    public void Do(){

        nodes = new GraphBuilder().GenerateGraph();
        for(GVNode n : nodes) {
            if (n.getName() == "A")
                sourceNode = n;
        }

        sNodes = new HashSet<>();
        qDistance = this.initDistance(nodes, sourceNode);

        while (qDistance.size() > 0) {
            GVNode newNode = ExtractMin(qDistance);
            if(newNode != null) {
                qDistance.remove(newNode);
                sNodes.add(newNode);
                Relax(newNode, qDistance);
            }
        }

        System.out.println(nodes.size());
    }


    //初始化最小距离优先队列 V[G]
    private Map<GVNode,Integer> initDistance(Set<GVNode> nodes, GVNode s){
        Map<GVNode,Integer> qDistance = new HashMap<GVNode,Integer>();
        for (GVNode node : nodes) {
            if(s == node)
                qDistance.put(node, 0);
            else
                qDistance.put(node, Integer.MAX_VALUE);
        }
        return qDistance;
    }

    private GVNode ExtractMin(Map<GVNode,Integer> qDistance){

        GVNode MinNode = null;
        int MinDistance = Integer.MAX_VALUE;
        for (Map.Entry<GVNode, Integer> entry : qDistance.entrySet()) {
            if(MinDistance > entry.getValue()){
                MinDistance = entry.getValue();
                MinNode = entry.getKey();
            }
        }
        return MinNode;
    }

    private void Relax(GVNode sourceNode, Map<GVNode,Integer> distance) {

        Map<GVNode,Integer> neighbor = sourceNode.getNeighbor();

        for (GVNode n : sourceNode.getNeighbor().keySet()) {
            if(distance.keySet().contains(n)) {
                Integer newCompute = sourceNode.getDistance() + sourceNode.getNeighbor().get(n);
                if(distance.get(n) > newCompute) {
                    distance.put(n, newCompute);
                    n.setPiNode(sourceNode);
                    n.setDistance(newCompute);
                }
            }
        }

    }
}
