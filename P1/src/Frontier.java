import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class representing the frontier
 */
public class Frontier {

    private PriorityQueue<Node> priorityFrontier;
    private LinkedList<Node> frontier;
    public Frontier() {
        this.frontier = new LinkedList<>();
        this.priorityFrontier = new PriorityQueue<>();
    }

    public LinkedList<Node> getFrontier() {
        return frontier;
    }

    public PriorityQueue<Node> getPriorityFrontier() {
        return priorityFrontier;
    }

    /**
     * Returns the Euclidian between two points on a polar coordinate plane
     * @param a point on the plane
     * @param b point ont he plane
     * @return the Euclidian between two points on a polar coordinate plane
     */
    //return sqrt(d_a^2 + d_b^2 - 2d_a*d_b*cos(a_b - a_a)))
    public double calculateDistance(State a, State b) {
        double tmp = ((a.getLevel()*a.getLevel()) + (b.getLevel()*b.getLevel())) - 2*(a.getLevel()*b.getLevel()*Math.cos(Math.toRadians(b.getBearing()) - Math.toRadians(a.getBearing())));
        return Math.sqrt(tmp);
    }

    /**
     * Used in the best first search algorithm
     * @param goal goal state
     * @return the Node which, by the heuristic used by the best first search algorithm, is closest to the goal
     */
    public Node getClosestToGoal(State goal) {
        Node closestToGoal = frontier.peekFirst();
        double smallestDistance = calculateDistance(closestToGoal.getState(), goal);
        for (int i = 0; i < frontier.size(); i++) {
            Node currentNode = frontier.get(i);
            //System.out.println("From: " + currentNode.getState().toString() + " Distance to goal: " + goal.toString() + " " + calculateDistance(currentNode.getState(), goal));
            if (calculateDistance(currentNode.getState(), goal) < smallestDistance) {
                closestToGoal = currentNode;
                smallestDistance = calculateDistance(closestToGoal.getState(), goal);
            }
        }
        System.out.println("Closest to goal is: " + closestToGoal.getState().toString());
        return closestToGoal ;
    }

    /**
     * Used in the A* search algorithm
     * @param goal goal state
     * @return the Node which, by the heuristic used by the A* search algorithm, is closest to the goal
     */
    public Node getAstarNode(State goal) {
        Node aStarNode = frontier.peekFirst();
        double distanceToNode = aStarNode.getPathCost();
        double distanceToGoal = calculateDistance(aStarNode.getState(), goal);
        double smallestDistance = distanceToGoal + distanceToNode;
        for (int i = 0; i < frontier.size(); i++) {
            Node currentNode = frontier.get(i);
            //System.out.println("From: " + currentNode.getState().toString() + " Distance to goal: " + goal.toString() + " " + calculateDistance(currentNode.getState(), goal));
            //System.out.println("Current node: " + currentNode.getState().toString() + " path cost: " + String.format("%.02f",currentNode.getPathCost()) + " total heuristic distance: " + String.format("%.02f", calculateDistance(currentNode.getState(), goal) + currentNode.getPathCost()));
            if ((calculateDistance(currentNode.getState(), goal) + currentNode.getPathCost()) < smallestDistance) {
                aStarNode = currentNode;
                smallestDistance = calculateDistance(currentNode.getState(), goal) + currentNode.getPathCost();
            }
        }
        if (aStarNode.getPredecessor() != null) {
            //System.out.println("A* node is: " + aStarNode.getState().toString() + " heuristic cost: " + String.format("%.02f", smallestDistance));
        }
        return aStarNode ;
    }
}
