#!/bin/bash

rm data.txt

java -cp out/production/P1 A1main BFS  5 2,0 2,135 N > bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  5 1,180 4,180 N >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  5 1,315 4,45 N >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  5 3,90 0,0 N >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  8 1,135 5,315 N >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  8 4,270 7,90 S >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  8 6,270 0,45 S >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  10 9,225 2,45 S >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  10 2,45 9,225 S >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  10 7,270 7,90 S >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  12 4,0 1,90 E >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  12 5,225 4,270 E >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  12 3,0 11,45 E >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  15 13,90 6,0 E >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  15 11,270 5,315 E >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  15 9,225 1,90 W >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  15 14,270 14,270 W >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  18 2,225 12,45 W >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  18 5,270 11,0 W >> bfs_wind_run.txt
java -cp out/production/P1 A1main BFS  18 4,270 13,0 W >> bfs_wind_run.txt

java -cp out/production/P1 A1main DFS  5 2,0 2,135 N > dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  5 1,180 4,180 N >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  5 1,315 4,45 N >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  5 3,90 0,0 N >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  8 1,135 5,315 N >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  8 4,270 7,90 S >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  8 6,270 0,45 S >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  10 9,225 2,45 S >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  10 2,45 9,225 S >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  10 7,270 7,90 S >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  12 4,0 1,90 E >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  12 5,225 4,270 E >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  12 3,0 11,45 E >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  15 13,90 6,0 E >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  15 11,270 5,315 E >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  15 9,225 1,90 W >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  15 14,270 14,270 W >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  18 2,225 12,45 W >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  18 5,270 11,0 W >> dfs_wind_run.txt
java -cp out/production/P1 A1main DFS  18 4,270 13,0 W >> dfs_wind_run.txt


java -cp out/production/P1 A1main BiDir  5 2,0 2,135 N > bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  5 1,180 4,180 N >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  5 1,315 4,45 N >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  5 3,90 0,0 N >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  8 1,135 5,315 N >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  8 4,270 7,90 S >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  8 6,270 0,45 S >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  10 9,225 2,45 S >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  10 2,45 9,225 S >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  10 7,270 7,90 S >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  12 4,0 1,90 E >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  12 5,225 4,270 E >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  12 3,0 11,45 E >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  15 13,90 6,0 E >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  15 11,270 5,315 E >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  15 9,225 1,90 W >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  15 14,270 14,270 W >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  18 2,225 12,45 W >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  18 5,270 11,0 W >> bidir_wind_run.txt
java -cp out/production/P1 A1main BiDir  18 4,270 13,0 W >> bidir_wind_run.txt

java -cp out/production/P1 A1main BestF  5 2,0 2,135 E > bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  5 1,180 4,180 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  5 1,315 4,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  5 3,90 0,0 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  8 1,135 5,315 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  8 4,270 7,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  8 6,270 0,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  10 9,225 2,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  10 2,45 9,225 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  10 7,270 7,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  12 4,0 1,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  12 5,225 4,270 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  12 3,0 11,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  15 13,90 6,0 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  15 11,270 5,315 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  15 9,225 1,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  15 14,270 14,270 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  18 2,225 12,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  18 5,270 11,0 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main BestF  18 4,270 13,0 E >> bestf_wind_run.txt

java -cp out/production/P1 A1main AStar  5 2,0 2,135 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  5 1,180 4,180 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  5 1,315 4,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  5 3,90 0,0 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  8 1,135 5,315 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  8 4,270 7,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  8 6,270 0,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  10 9,225 2,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  10 2,45 9,225 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  10 7,270 7,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  12 4,0 1,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  12 5,225 4,270 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  12 3,0 11,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  15 13,90 6,0 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  15 11,270 5,315 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  15 9,225 1,90 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  15 14,270 14,270 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  18 2,225 12,45 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  18 5,270 11,0 E >> bestf_wind_run.txt
java -cp out/production/P1 A1main AStar  18 4,270 13,0 E >> bestf_wind_run.txt

python3 -m venv env
source env/bin/activate
pip3 install -r requirements.txt
python3 visualise_data.py wind > results_wind.txt
