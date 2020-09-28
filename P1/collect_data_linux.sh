#!/bin/bash

rm data.txt

java -cp out/production/P1 A1main BFS  5 2,0 2,135 > bfs_run.txt
java -cp out/production/P1 A1main BFS  5 1,180 4,180 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  5 1,315 4,45 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  5 3,90 0,0 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  8 1,135 5,315 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  8 4,270 7,90 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  8 6,270 0,45 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  10 9,225 2,45 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  10 2,45 9,225 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  10 7,270 7,90 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  12 4,0 1,90 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  12 5,225 4,270 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  12 3,0 11,45 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  15 13,90 6,0 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  15 11,270 5,315 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  15 9,225 1,90 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  15 14,270 14,270 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  18 2,225 12,45 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  18 5,270 11,0 >> bfs_run.txt
java -cp out/production/P1 A1main BFS  18 4,270 13,0 >> bfs_run.txt

java -cp out/production/P1 A1main DFS  5 2,0 2,135 > dfs_run.txt
java -cp out/production/P1 A1main DFS  5 1,180 4,180 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  5 1,315 4,45 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  5 3,90 0,0 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  8 1,135 5,315 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  8 4,270 7,90 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  8 6,270 0,45 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  10 9,225 2,45 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  10 2,45 9,225 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  10 7,270 7,90 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  12 4,0 1,90 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  12 5,225 4,270 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  12 3,0 11,45 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  15 13,90 6,0 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  15 11,270 5,315 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  15 9,225 1,90 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  15 14,270 14,270 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  18 2,225 12,45 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  18 5,270 11,0 >> dfs_run.txt
java -cp out/production/P1 A1main DFS  18 4,270 13,0 >> dfs_run.txt


java -cp out/production/P1 A1main BiDir  5 2,0 2,135 > bidir_run.txt
java -cp out/production/P1 A1main BiDir  5 1,180 4,180 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  5 1,315 4,45 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  5 3,90 0,0 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  8 1,135 5,315 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  8 4,270 7,90 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  8 6,270 0,45 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  10 9,225 2,45 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  10 2,45 9,225 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  10 7,270 7,90 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  12 4,0 1,90 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  12 5,225 4,270 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  12 3,0 11,45 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  15 13,90 6,0 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  15 11,270 5,315 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  15 9,225 1,90 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  15 14,270 14,270 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  18 2,225 12,45 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  18 5,270 11,0 >> bidir_run.txt
java -cp out/production/P1 A1main BiDir  18 4,270 13,0 >> bidir_run.txt


java -cp out/production/P1 A1main BestF  5 2,0 2,135 > bestf_run.txt
java -cp out/production/P1 A1main BestF  5 1,180 4,180 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  5 1,315 4,45 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  5 3,90 0,0 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  8 1,135 5,315 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  8 4,270 7,90 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  8 6,270 0,45 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  10 9,225 2,45 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  10 2,45 9,225 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  10 7,270 7,90 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  12 4,0 1,90 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  12 5,225 4,270 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  12 3,0 11,45 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  15 13,90 6,0 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  15 11,270 5,315 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  15 9,225 1,90 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  15 14,270 14,270 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  18 2,225 12,45 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  18 5,270 11,0 >> bestf_run.txt
java -cp out/production/P1 A1main BestF  18 4,270 13,0 >> bestf_run.txt

java -cp out/production/P1 A1main AStar  5 2,0 2,135 > astar_run.txt
java -cp out/production/P1 A1main AStar  5 1,180 4,180 >> astar_run.txt
java -cp out/production/P1 A1main AStar  5 1,315 4,45 >> astar_run.txt
java -cp out/production/P1 A1main AStar  5 3,90 0,0 >> astar_run.txt
java -cp out/production/P1 A1main AStar  8 1,135 5,315 >> astar_run.txt
java -cp out/production/P1 A1main AStar  8 4,270 7,90 >> astar_run.txt
java -cp out/production/P1 A1main AStar  8 6,270 0,45 >> astar_run.txt
java -cp out/production/P1 A1main AStar  10 9,225 2,45 >> astar_run.txt
java -cp out/production/P1 A1main AStar  10 2,45 9,225 >> astar_run.txt
java -cp out/production/P1 A1main AStar  10 7,270 7,90 >> astar_run.txt
java -cp out/production/P1 A1main AStar  12 4,0 1,90 >> astar_run.txt
java -cp out/production/P1 A1main AStar  12 5,225 4,270 >> astar_run.txt
java -cp out/production/P1 A1main AStar  12 3,0 11,45 >> astar_run.txt
java -cp out/production/P1 A1main AStar  15 13,90 6,0 >> astar_run.txt
java -cp out/production/P1 A1main AStar  15 11,270 5,315 >> astar_run.txt
java -cp out/production/P1 A1main AStar  15 9,225 1,90 >> astar_run.txt
java -cp out/production/P1 A1main AStar  15 14,270 14,270 >> astar_run.txt
java -cp out/production/P1 A1main AStar  18 2,225 12,45 >> astar_run.txt
java -cp out/production/P1 A1main AStar  18 5,270 11,0 >> astar_run.txt
java -cp out/production/P1 A1main AStar  18 4,270 13,0 >> astar_run.txt

python3 -m venv env
source env/bin/activate
pip3 install -r requirements.txt
python3 visualise_data.py > results.txt
