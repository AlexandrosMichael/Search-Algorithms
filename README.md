# Search Algorithms - Flight Route Planner

This is an mplementation of a simplified flight route planner to navigate the imaginary constellation of Oedipus. Each of these planets is a circular grid, consisting of 8 meridians, one every 45 degrees, and a fixed number of parallels indicating the size of the planet. An intelligent agent is given a starting point and a goal point on this grid and it makes use of search algorithms to identify a route for an aircraft. The search algorithms implemented are:
* Depth First Search
* Breadth First Search
* Best First Search
* A* Search

## Installation and Usage

The base directory is the P1 directory. The source code (.java files) can be found in the P1/A1src directory while the class files (.class files) may be found in the P1/out/production/P1 directory. To run the flight route planner with your own parameters navigate to the base directory and run the command:

```bash
java -cp out/production/P1/A1main <DFS|BFS|AStar|BestF|BiDir> <N><d s,angle s><d g,angle g>[N|S|E|W]
```
However one may also navigate to the source code directory, P1/A1src, compile the .java files using: javac *.java and then run the program as required by the specification using:
```bash
java A1main <DFS|BFS|AStar|BestF|BiDir><N><d s,angle s><d g,angle g>[N|S|E|W]
```

Example: 
```bash
java A1main BFS 5 2,45 3,225 N
```
To execute the scripts automating the run, navigate to the base directory /P1 and run the command:

```bash
 ./collect_data_linux.sh
 ```
for running the program 20 times for each search algorithm without the wind feature, and run 
```bash
./collect_data_wind_linux.sh
```
for running the program 20 times for each search algorithm with the wind feature. The above scripts will redirect their output to text files so one may carefully examine and compare how different search algorithms carry out search. For example the route planner using the BFS algorithm, without the wind feature will redirect its output in a file called bfs run.txt and the route planner using the BFS algorithm, with the wind feature will redirect its output in a file called bfs wind wind.txt. Running the script also automatically runs the Python script which reads its data from the data.txt file which contains the results of each search algorithm’s performance. In turn, this python script will produce an interactive visulisation as well as a text file called results.txt or results wind.txt containing the average path cost and average of nodes expanded for each search algorithm. Note that the bash scripts and the Python file may need to be given execution privileges using: 

```bash
chmod +x <file>
```
## Report

See CS5011_P1.pdf for a complete report, containing installation and usage instructions.

