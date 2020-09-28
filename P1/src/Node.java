/**
 * Class representing a node in the search tree
 */
public class Node implements Comparable<Node> {

    private State state;
    private Node predecessor;
    private int depth;
    private double pathCost;
    private String heading;


    public Node (State state, Node predecessor, int depth, double pathCost, String heading) {
        this.state = state;
        this.predecessor = predecessor;
        this.depth = depth;
        this.pathCost = pathCost;
        this.heading = heading;
    }

    public State getState() {
        return state;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public int getDepth() {
        return depth;
    }

    public double getPathCost() {
        return pathCost;
    }

    public String getHeading() {
        return heading;
    }

    /**
     * A node is equal to another when their state and their predecessor states are the same
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        if (predecessor != null && node.predecessor != null) {
            return state.equals(node.state) && predecessor.state.equals(node.predecessor.state);
        }
        else {
            return state.equals(node.state);
        }
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }


    @Override
    public String toString() {
        if (predecessor != null) {
            return ("State: " + state.toString() + " Predecessor state: " + predecessor.getState().toString() + " Depth: " + depth + " Path Cost: " + String.format("%.02f", pathCost));
        }
        else {
            return ("State: " + state.toString() + " Root node " + " Depth: " + depth + " Path Cost: " + String.format("%.02f", pathCost));
        }
    }

    @Override
    public int compareTo(Node node) {
        if(this.getPathCost() > node.getPathCost()) {
            return 1;
        } else if (this.getPathCost() < node.getPathCost()) {
            return -1;
        } else {
            return 0;
        }
    }
}

