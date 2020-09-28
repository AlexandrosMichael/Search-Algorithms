import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class A1main {


    private static Grid grid;
    private static Frontier frontier;
    private static ArrayList<Node> expandedNodes;
    private static ArrayList<State> exploredStates;
    private static State startingState;
    private static State goalState;
    private static PrintWriter out;
    private static String windDirection;
    private static boolean wind;

    /**
     * Adds the valid search algorithms that can be used
     * Done for parameter validation
     * @param searchAlgorithms the list to which the valid search algorithms will be added
     */
    public static void addValidAlgorithms(List<String> searchAlgorithms) {
        searchAlgorithms.add("BFS");
        searchAlgorithms.add("DFS");
        searchAlgorithms.add("BestF");
        searchAlgorithms.add("AStar");
        searchAlgorithms.add("BiDir");
    }

    public static void addValidWindDirections(List <String> windDirections) {
        windDirections.add("N");
        windDirections.add("S");
        windDirections.add("E");
        windDirections.add("W");
    }


    /**
     * Method which prints out the starting values i.e. the inputs
     * @param searchAlgorithm the search algorithm to be used
     * @param parallels the N size of the planet, number of parallels
     * @param startingState
     * @param goalState
     */
    public static void printInputs(String searchAlgorithm, int parallels, State startingState, State goalState, String windDirection) {
        System.out.println("Inputs are the following\n");
        System.out.println("Search algorithm used: " + searchAlgorithm);
        System.out.println("Number of parallels: " + parallels);
        System.out.println("Starting state: " + startingState.toString());
        System.out.println("Goal state: " + goalState.toString());
        if (wind) {
            System.out.println("Wind direction: " + windDirection);
        }
        System.out.println();
    }

    /**
     * Utility method which prints the frontier nodes
     */
    public static void printFrontier(Frontier frontier) {
        System.out.println("FRONTIER WITH SIZE: " + frontier.getFrontier().size());
        for (Node frontierNode: frontier.getFrontier()) {
            System.out.println(frontierNode.toString());
        }
        System.out.println();
    }

    /**
     * Method which returns the path cost depending on the action of the airplane
     * @param action the move i.e H90 H180 H270 or H360
     * @param diameter the level of the parallel i.e. diameter from pole
     * @return the path cost resulting from a specific action
     */
    @SuppressWarnings("Duplicates")
    public static double findPathCost(String action, int diameter) {
        switch (action) {
            case "H90": {
                if (wind && windDirection.equals("E")) {
                    return ((2 * Math.PI * diameter) / 8)/2;
                }
                else if (wind && windDirection.equals("W")) {
                    return ((2 * Math.PI * diameter) / 8) *2;
                }
                else {
                    return (2 * Math.PI * diameter) / 8;
                }
            }
            case "H180": {
                if (wind && windDirection.equals("S")) {
                    return 1/2;
                }
                else if (wind && windDirection.equals("N")) {
                    return 2;
                }
                else {
                    return 1;
                }
            }
            case "H270": {
                if (wind && windDirection.equals("W")) {
                    return ((2*Math.PI*diameter)/8)/2;
                }
                else if (wind && windDirection.equals("E")) {
                    return ((2 * Math.PI * diameter) / 8) * 2;
                }
                else {
                    return (2 * Math.PI * diameter) / 8;
                }
            }
            case "H360": {
                if (wind && windDirection.equals("N")) {
                    return 1/2;
                }
                else if (wind && windDirection.equals("S")) {
                    return 2;
                }
                else {
                    return 1;
                }
            }
            default: {
                return 0;
            }
        }
    }


    /**
     * Method which prints out the nodes which have been expanded
     */
    public static void printExpandedNodes() {
        System.out.println("EXPANDED NODES WITH SIZE: " + expandedNodes.size());
        for (Node expandedNode: expandedNodes) {
            System.out.print(expandedNode.toString());
            System.out.println(" ");
        }
        System.out.println("--------------------------------------");
        System.out.println();
    }

    /**
     * Method which creates the world in which the AI acts i.e. its environment
     * @param parallels the number of the planet's parallels
     * @param myStartingState the starting state i.e. starting coordinates
     * @param myGoalState the goal state i.e. goal coordinates
     */
    public static void createWorld(int parallels, State myStartingState, State myGoalState) {
        grid = new Grid(parallels);
        startingState = myStartingState;
        goalState = myGoalState;
        frontier = new Frontier();
        frontier.getFrontier().add(makeNode(startingState, null, ""));
        frontier.getPriorityFrontier().add(makeNode(startingState, null, ""));
        expandedNodes = new ArrayList<>();
        exploredStates = new ArrayList<>();
    }

    /**
     * Method which returns the nodes to be added to the frontier. Depending on which action is taken, the resulting node will have a specific state
     * @param currentState the state in which the predecessor is in
     * @param predecessor the predecessor node
     * @param action the action taken by the agen
     * @return Node representing the result of the action given the current state
     */
    public static Node makeNode(State currentState, Node predecessor, String action) {

        switch (action) {
            case "H90": {
                return new Node(grid.getGrid()[currentState.getLevel()-1][((currentState.getBearing()/45)+1)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost() + findPathCost(action, currentState.getLevel()), "H90");
            }
            case "H180": {
                return new Node(grid.getGrid()[currentState.getLevel()][(currentState.getBearing()/45)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost()+ findPathCost(action, currentState.getLevel()), "H180" );
            }
            case "H270": {
                return new Node(grid.getGrid()[currentState.getLevel()-1][((currentState.getBearing()/45)+7)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost()+ findPathCost(action, currentState.getLevel()), "H270" );
            }
            case "H360": {
                return new Node(grid.getGrid()[currentState.getLevel()-2][(currentState.getBearing()/45)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost()+ findPathCost(action, currentState.getLevel()), "H360" );
            }
            default : {
                return new Node(grid.getGrid()[currentState.getLevel()-1][(currentState.getBearing()/45) % 8], null, 0, 0, "");
            }
        }
    }

    /**
     * This is used for the bidirectional search in order to 'reverse' the actions taken from goal -> point of intersection
     * Method which returns the nodes to be added to the frontier. Depending on which action is taken, the resulting node will have a specific state
     * @param currentState the state in which the predecessor is in
     * @param predecessor the predecessor node
     * @param action the action taken by the agen
     * @return Node representing the result of the action given the current state
     */
    public static Node makeReverseNode(State currentState, Node predecessor, String action) {

        switch (action) {
            case "H90": {
                return new Node(grid.getGrid()[currentState.getLevel()-1][((currentState.getBearing()/45)+7)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost() + findPathCost(action, currentState.getLevel()), "H270");
            }
            case "H180": {
                return new Node(grid.getGrid()[currentState.getLevel()-2][(currentState.getBearing()/45)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost()+ findPathCost(action, currentState.getLevel()), "H360" );
            }
            case "H270": {
                return new Node(grid.getGrid()[currentState.getLevel()-1][((currentState.getBearing()/45)+1)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost()+ findPathCost(action, currentState.getLevel()), "H90" );
            }
            case "H360": {
                return new Node(grid.getGrid()[currentState.getLevel()][(currentState.getBearing()/45)% 8], predecessor, predecessor.getDepth()+1, predecessor.getPathCost()+ findPathCost(action, currentState.getLevel()), "H180" );
            }
            default : {
                return new Node(grid.getGrid()[currentState.getLevel()-1][(currentState.getBearing()/45) % 8], null, 0, 0, "");
            }
        }
    }

    /**
     * Method which calls the appropriate search algorithm depending on the command line argument
     * @param searchAlgorithm the search algorithm to be carried out
     * @return The goal node which is in the goal state
     * @throws InvalidArgumentsException
     */
    public static Node performSearch(String searchAlgorithm) throws InvalidArgumentsException {


        switch (searchAlgorithm) {
            case "DFS" : {
                return depthFirstSearch();
            }
            case "BFS" : {
                return breadthFirstSearch();
            }
            case "BestF" : {
                return bestFirstSearch();
            }
            case "AStar" : {
                return aStarSearch();
            }
            case "BiDir" : {
                return bidirectionalSearch();
            }
            default : {
                throw new InvalidArgumentsException("Invalid search algorithm");
            }
        }
    }


    /**
     * Method which checks whether the node is in the goal state
     * @param state to be checked whether it's in the goal state
     * @return true is node is in goal state
     */
    public static boolean isGoal(State state) {

        if (state.getLevel() == goalState.getLevel() && state.getBearing() == goalState.getBearing()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method which expands the frontier. It checks which moves are possible and then if they're not already in the frontier
     * they will be added to the frontier.
     * @param node
     */
    public static List<Node> getPossibleMoves(Node node) {


        State currentState = node.getState();
        // need to assess possible moves --> only four possible
        List<Node> successorNodes = new ArrayList<>();
        // two moves always possible are move east & west
        // move East
        successorNodes.add(makeNode(currentState, node, "H90"));
        // move West
        successorNodes.add(makeNode(currentState, node, "H270"));
        // check if at top or bottom level i.e. if can move north or south
        if (currentState.getLevel() < (grid.getLevels()-1)) {
            successorNodes.add(makeNode(currentState, node, "H180"));
        }
        if (currentState.getLevel() > 1) {
            successorNodes.add(makeNode(currentState, node, "H360"));
        }
        return successorNodes;
    }
    /**
     * Method which carries out breadth first search
     * @return Node which is in the goal state
     */
    @SuppressWarnings("Duplicates")
    public static Node breadthFirstSearch() {
        // if starting is goal
        Node startingNode = frontier.getFrontier().peekFirst();
        if (isGoal(startingNode.getState())) {
            return startingNode;
        }
        while (true) {
            if (frontier.getFrontier().isEmpty()) {
                return null;
            }
            // Get first item on frontier i.e. shallowest node
            Node currentNode = frontier.getFrontier().pollFirst();
            exploredStates.add(currentNode.getState());
            //currentNode.getState().setExplored(true);
            for (Node possibleMove: getPossibleMoves(currentNode)) {
                Node childNode = possibleMove;
                if (!exploredStates.contains(childNode) && !frontier.getFrontier().contains(childNode)){
                    if (isGoal(childNode.getState())) {
                        return childNode;
                    }
                    else {
                        frontier.getFrontier().add(childNode);
                    }
                }
            }
        }
    }



    /**
     * Method which carries out depth first search
     * @return Node which is in the goal state
     */
    @SuppressWarnings("Duplicates")
    public static Node depthFirstSearch() {
        // if starting is goal
        Node startingNode = frontier.getFrontier().peekFirst();
        exploredStates.add(startingNode.getState());
        if (isGoal(startingNode.getState())) {
            return startingNode;
        }
        while (true) {
            if (frontier.getFrontier().isEmpty()) {
                return null;
            }
            Node currentNode = frontier.getFrontier().removeLast();
            exploredStates.add(currentNode.getState());
            if (isGoal(currentNode.getState())) {
                return currentNode;
            } else {
                for (Node possibleMove : getPossibleMoves(currentNode)) {
                    if (!exploredStates.contains(possibleMove.getState()) && !frontier.getFrontier().contains(possibleMove)) {
                        frontier.getFrontier().add(possibleMove);
                    }
                }
            }
        }
    }

    /**
     * Method which carries out best first search
     * @return Node which is in the goal state
     */
    @SuppressWarnings("Duplicates")
    public static Node bestFirstSearch() {
        // if starting is goal
        Node startingNode = frontier.getFrontier().peek();
        exploredStates.add(startingNode.getState());
        if (isGoal(startingNode.getState())) {
            return startingNode;
        }
        while (true) {
            if (frontier.getFrontier().isEmpty()) {
                return null;
            }
            //printFrontier(frontier);
            // calls method which returns node which has the lowest cost according to the heuristic used
            Node currentNode = frontier.getClosestToGoal(goalState);
            frontier.getFrontier().remove(currentNode);
            exploredStates.add(currentNode.getState());
            System.out.println("CURRENT NODE: " + currentNode.toString());
            System.out.println();
            printExpandedNodes();
            // check if current node is in goal state
            if (isGoal(currentNode.getState())) {
                return currentNode;
            }
            else {
                for (Node possibleMove : getPossibleMoves(currentNode)) {
                    if (!exploredStates.contains(possibleMove.getState()) && !frontier.getFrontier().contains(possibleMove)) {
                        frontier.getFrontier().add(possibleMove);
                    }
                }
            }
        }
    }

    /**
     * Method which carriest out A* search
     * TODO check whether Node vs State in explored -> replace same State with lower path cost
     * TODO check how performance affected if data structure used
     * TODO change heuristic? Use another heuristic
     * @return Node that is in the goal state
     */
    @SuppressWarnings("Duplicates")
    public static Node aStarSearch() {
        // if starting is goal
        Node startingNode = frontier.getFrontier().peekFirst();
        exploredStates.add(startingNode.getState());
        if (isGoal(startingNode.getState())) {
            return startingNode;
        }
        while (true) {
            if (frontier.getFrontier().isEmpty()) {
                return null;
            }
            //printFrontier(frontier);
            // calls method which returns node which has the lowest cost according to the heuristic used
            Node currentNode = frontier.getAstarNode(goalState);
            frontier.getFrontier().remove(currentNode);
            exploredStates.add(currentNode.getState());
            //System.out.println("CURRENT NODE: " + currentNode.toString());
            //System.out.println();
            //printExpandedNodes();
            // check if current node is in goal state
            if (isGoal(currentNode.getState())) {
                return currentNode;
            }
            else {
                for (Node possibleMove : getPossibleMoves(currentNode)) {
                    if (!exploredStates.contains(possibleMove.getState()) && !frontier.getFrontier().contains(possibleMove)) {
                        frontier.getFrontier().add(possibleMove);
                    }
                }
            }
        }
    }

    /**
     * Method which carries out breadth first search
     * @return Node which is in the goal state
     */
    @SuppressWarnings("Duplicates")
    public static Node bidirectionalSearch() {
        // if starting is goal
        Frontier reverseFrontier = new Frontier();
        reverseFrontier.getFrontier().add(makeNode(goalState, null, ""));
        Node startingNode = frontier.getFrontier().peekFirst();
        if (isGoal(startingNode.getState())) {
            return startingNode;
        }
        while (true) {
            if (frontier.getFrontier().isEmpty() && !reverseFrontier.getFrontier().isEmpty()) {
                return null;
            }
            // Get first item on frontier i.e. shallowest node
            Node currentNode = frontier.getFrontier().pollFirst();
            exploredStates.add(currentNode.getState());
            // Get first item on reverse frontier
            Node currentReverseNode = reverseFrontier.getFrontier().pollFirst();
            exploredStates.add(currentReverseNode.getState());
            for (Node possibleMove: getPossibleMoves(currentNode)) {
                Node childNode = possibleMove;
                if (!exploredStates.contains(childNode) && !frontier.getFrontier().contains(childNode)){
                    Node intersectionNode = checkIntersection(frontier, reverseFrontier);
                    if (intersectionNode != null) {
                        return intersectionNode;
                    }
                    else {
                        frontier.getFrontier().add(childNode);
                    }
                }
            }
            for (Node possibleMove: getPossibleMoves(currentReverseNode)) {
                Node childNode = possibleMove;
                if (!exploredStates.contains(childNode) && !reverseFrontier.getFrontier().contains(childNode)){
                    Node intersectionNode = checkIntersection(frontier, reverseFrontier);
                    if (intersectionNode != null) {
                        return intersectionNode;
                    }
                    else {
                        reverseFrontier.getFrontier().add(childNode);
                    }
                }
            }

        }
    }


    /**
     * Method which checkrs whether an intersection in the 2 frontiers has been found. After finding it the method
     * will contruct the path from the point of intersection -> goal state meanwhile readjusting the predecessor pointers,
     * the headings, and the states.
     * @param frontier frontier for the start -> goal search
     * @param reverseFrontier frontier for the goal -> start search
     * @return Node which is in the goal state
     */
    public static Node checkIntersection(Frontier frontier, Frontier reverseFrontier) {
        ArrayList<Node> predecessorNodes = new ArrayList<>();
        for (Node node: frontier.getFrontier()) {
            for (Node reverseNode: reverseFrontier.getFrontier()) {
                if (node.getState().equals(reverseNode.getState())) {

                    System.out.println("Node from main Frontier: " + node.toString());
                    System.out.println("Node from reverse Frontier: " + reverseNode.toString());

                    Node predecessorNode = reverseNode;
                    while (predecessorNode != null) {
                        predecessorNodes.add(predecessorNode);
                        predecessorNode = predecessorNode.getPredecessor();
                    }

                    for (Node predecessor: predecessorNodes) {
                        if (predecessor.getPredecessor() == null) {
                            break;
                        }
                        else {
                            Node newNode = makeReverseNode(predecessor.getState(), node, predecessor.getHeading());
                            node = newNode;
                        }
                    }
                    return node;
                }
            }
        }
        return null;
    }


    /**
     * Method which prints out the path from the starting state to the goal state
     * @param node
     */
    public static void printPath(Node node) {
        if (node == null) {
            System.out.println("NULL");
        }
        System.out.println("EXPANDED: " + exploredStates.size() + " States");
        System.out.println("PATH with cost: " + String.format("%.02f", node.getPathCost()));
        Stack<Node> stack = new Stack<>();
        // Nodes pushed in the stack (goal state first)
        while (node != null) {
            stack.push(node);
            node = node.getPredecessor();
        }
        System.out.print("HEADINGS:");
        // Nodes popped from the stack (start state first)
        while (!stack.empty()) {
            System.out.print(stack.pop().getHeading() + " ");
        }
        System.out.println();

    }


    /**
     * Main method
     * @param args <DFS|BFS|AStar|BestF> <N> <d_s,angle_s> <d_g,angle_g>
     * @throws InvalidArgumentsException thrown if invalid arguments passed to the program
     */
    public static void main(String args[]) throws InvalidArgumentsException, ImpossibleFlightException {
        List<String> searchAlgorithms = new ArrayList<>();
        addValidAlgorithms(searchAlgorithms);
        List<String> windDirections = new ArrayList<>();
        addValidWindDirections(windDirections);
        String searchAlgorithm = "";
        int levels;
        State startingState;
        State goalState;
        if (args.length != 4 && args.length != 5) {
            throw new InvalidArgumentsException("Invalid number of arguments");
        }
        else {
            // Get the command line arguments
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("data.txt", true)));
                if (searchAlgorithms.contains(args[0])) {
                    searchAlgorithm = args[0];
                }

                levels = Integer.parseInt(args[1]);
                String[] coordinateComponents = args[2].split(",");
                startingState = new State(Integer.parseInt(coordinateComponents[0]), Integer.parseInt(coordinateComponents[1]));
                coordinateComponents = args[3].split(",");
                goalState = new State(Integer.parseInt(coordinateComponents[0]), Integer.parseInt(coordinateComponents[1]));

                // if there is a wind i.e. N, S, E, W wind
                if (args.length == 5) {
                    wind = true;
                    windDirection = args[4];
                    if (!windDirections.contains(windDirection)) {
                        throw new InvalidArgumentsException("Invalid wind direction");
                    }
                }

                printInputs(searchAlgorithm, levels, startingState, goalState, windDirection);
                createWorld(levels, startingState, goalState);
                if (goalState.getLevel() == 0) {
                    throw  new ImpossibleFlightException("Impossible flight: Can't reach pole.");
                }
                Node finalNode = performSearch(searchAlgorithm);
                out.println(searchAlgorithm + "," + finalNode.getPathCost() + "," + exploredStates.size());
                out.flush();
                out.close();
                printPath(finalNode);
            }
            catch(NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Usage: <DFS|BFS|AStar|BestF> <N> <d_s,angle_s> <d_g,angle_g>");
            }
            catch(IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

    }
}
