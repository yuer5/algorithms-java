package ashley.learning.algorithm.graph.dijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuer5 on 16/5/18.
 */
public class GraphBuilder {
    public Set<GVNode> GenerateGraph(){

        GVNode nodeA=new GVNode("A");
        GVNode nodeB=new GVNode("B");
        GVNode nodeC=new GVNode("C");
        GVNode nodeD=new GVNode("D");
        GVNode nodeE=new GVNode("E");
        GVNode nodeF=new GVNode("F");
        GVNode nodeG=new GVNode("G");
        GVNode nodeH=new GVNode("H");
        GVNode nodeI=new GVNode("I");
        GVNode nodeJ=new GVNode("J");
        GVNode nodeK=new GVNode("K");
        GVNode nodeL=new GVNode("L");
        GVNode nodeM=new GVNode("M");

        nodeA.getNeighbor().put(nodeB, 3);
        nodeA.getNeighbor().put(nodeH, 5);

        nodeB.getNeighbor().put(nodeA, 3);
        nodeB.getNeighbor().put(nodeC, 5);
        nodeB.getNeighbor().put(nodeD, 3);

        nodeC.getNeighbor().put(nodeB, 5);
        nodeC.getNeighbor().put(nodeF, 3);

        nodeD.getNeighbor().put(nodeB, 3);
        nodeD.getNeighbor().put(nodeE, 2);

        nodeE.getNeighbor().put(nodeD, 2);
        nodeE.getNeighbor().put(nodeF, 3);
        nodeE.getNeighbor().put(nodeI, 2);

        nodeF.getNeighbor().put(nodeC, 3);
        nodeF.getNeighbor().put(nodeE, 3);
        nodeF.getNeighbor().put(nodeG, 2);
        nodeF.getNeighbor().put(nodeJ, 2);

        nodeG.getNeighbor().put(nodeF, 2);

        nodeH.getNeighbor().put(nodeA, 5);
        nodeH.getNeighbor().put(nodeI, 5);

        nodeI.getNeighbor().put(nodeE, 2);
        nodeI.getNeighbor().put(nodeH, 5);
        nodeI.getNeighbor().put(nodeL, 3);

        nodeJ.getNeighbor().put(nodeF, 2);
        nodeJ.getNeighbor().put(nodeK, 1);

        nodeK.getNeighbor().put(nodeJ, 1);
        nodeK.getNeighbor().put(nodeM, 3);

        nodeL.getNeighbor().put(nodeI, 3);
        nodeL.getNeighbor().put(nodeM, 4);

        nodeM.getNeighbor().put(nodeL, 4);
        nodeM.getNeighbor().put(nodeK, 3);

        Set<GVNode> nodes = new HashSet<GVNode>();
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);
        nodes.add(nodeE);
        nodes.add(nodeF);
        nodes.add(nodeG);
        nodes.add(nodeH);
        nodes.add(nodeI);
        nodes.add(nodeJ);
        nodes.add(nodeK);
        nodes.add(nodeL);
        nodes.add(nodeM);

        return nodes;

    }
}
