import plotly.express as px
import plotly.graph_objects as go
import numpy as np
import sys


f = open("data.txt", "r")

wind = False
if (len(sys.argv) > 1):
    wind = True


bfs_data = []
bfs_path_cost = []
bfs_expanded_nodes = []

dfs_data = []
dfs_path_cost = []
dfs_expanded_nodes = []


bidir_data = []
bidir_path_cost = []
bidir_expanded_nodes = []

bestf_data = []
bestf_path_cost = []
bestf_expanded_nodes = []

astar_data = []
astar_path_cost = []
astar_expanded_nodes = []

path_costs = []
expanded_nodes = []
algorithms = []


def examine_line(line):
    line.strip('\n')
    split_line = line.split(',')
    if split_line[0] == 'BFS':
        bfs_data.append(
            {
                float(split_line[1]) : float(split_line[2])
            })
        bfs_path_cost.append(float(split_line[1]))
        bfs_expanded_nodes.append(float(split_line[2]))
    elif split_line[0] == 'DFS':
        dfs_data.append(
            {
                float(split_line[1]) : float(split_line[2])
            })
        dfs_path_cost.append(float(split_line[1]))
        dfs_expanded_nodes.append(float(split_line[2]))
    elif split_line[0] == 'BiDir':
        bidir_data.append(
            {
                float(split_line[1]) : float(split_line[2])
            })
        bidir_path_cost.append(float(split_line[1]))
        bidir_expanded_nodes.append(float(split_line[2]))
    elif split_line[0] == 'BestF':
        bestf_data.append(
            {
                float(split_line[1]) : float(split_line[2])
            })
        bestf_path_cost.append(float(split_line[1]))
        bestf_expanded_nodes.append(float(split_line[2]))
    else:
        astar_data.append(
            {
                float(split_line[1]) : float(split_line[2])
            })
        astar_path_cost.append(float(split_line[1]))
        astar_expanded_nodes.append(float(split_line[2]))

def gather_data(line):
    line.strip('\n')
    split_line = line.split(',')
    algorithms.append(split_line[0])
    path_costs.append(float(split_line[1]))
    expanded_nodes.append(float(split_line[2]))


def plot_graph():
    fig = go.Figure()
    fig.add_trace(go.Scatter(y=bfs_expanded_nodes, x=bfs_path_cost,
                        mode='markers',
			marker=dict(
				opacity=0.5,
			),
                        name='BFS'))
    fig.add_trace(go.Scatter(y=dfs_expanded_nodes, x=dfs_path_cost,
                        mode='markers',
			marker=dict(
				opacity=0.5,
			),
                        name='DFS'))
    fig.add_trace(go.Scatter(y=bidir_expanded_nodes, x=bidir_path_cost,
                        mode='markers',
			marker=dict(
				opacity=0.5,
			),
                        name='BiDir'))
    fig.add_trace(go.Scatter(y=bestf_expanded_nodes, x=bestf_path_cost,
                        mode='markers',
			marker=dict(
				opacity=0.5,
			),
                        name='BestF'))
    fig.add_trace(go.Scatter(y=astar_expanded_nodes, x=astar_path_cost,
                        mode='markers',
			marker=dict(
				opacity=0.5,
			),
                        name='AStar'))
    
    # Edit the layout
    fig.update_layout(title='Path cost and number of expanded nodes. ' + "Wind: " + str(wind) ,
                   xaxis_title='Path Cost',
                   yaxis_title='Expanded Nodes',
                   showlegend=True)
    fig.show()


    
lines = f.readlines()
for line in lines:
    examine_line(line)
    gather_data(line)





# astar_nodes_average = np.average(np.array(astar_expanded_nodes))
# print(type(astar_cost_average))
# print(astar_cost_average)
    
plot_graph()

bfs_cost_average = round(np.mean(np.array(bfs_path_cost)), 2)
bfs_nodes_average = round(np.mean(np.array(bfs_expanded_nodes)), 2)

dfs_cost_average = round(np.mean(np.array(dfs_path_cost)), 2)
dfs_nodes_average = round(np.mean(np.array(dfs_expanded_nodes)), 2)

bidir_cost_average = round(np.mean(np.array(bidir_path_cost)), 2)
bidir_nodes_average = round(np.mean(np.array(bidir_expanded_nodes)), 2)

bestf_cost_average = round(np.mean(np.array(bestf_path_cost)), 2)
bestf_nodes_average = round(np.mean(np.array(bestf_expanded_nodes)), 2)

astar_cost_average =  round(np.mean(np.array(astar_path_cost)), 2)
astar_nodes_average = round(np.mean(np.array(astar_expanded_nodes)), 2)

averages = {
    'bfs_cost_average' : bfs_cost_average,
    'bfs_nodes_average' : bfs_nodes_average,
    'dfs_cost_average' : dfs_cost_average,
    'dfs_nodes_average' : dfs_nodes_average,
    'bidir_cost_average' : bidir_cost_average,
    'bidir_nodes_average' : bidir_nodes_average,
    'bestf_cost_average' : bestf_cost_average,
    'bestf_nodes_average' : bestf_nodes_average,
    'astar_cost_average' : astar_cost_average,
    'astar_nodes_average' : astar_nodes_average
}

print('BFS Cost Average: ' + str(averages.get('bfs_cost_average')))
print('DFS Cost Average: ' + str(averages.get('dfs_cost_average')))
print('BiDir Cost Average: ' + str(averages.get('bidir_cost_average')))
print('BestF Cost Average: ' + str(averages.get('bestf_cost_average')))
print('AStar Cost Average: ' + str(averages.get('astar_cost_average')))

print('BFS Nodes Average: ' + str(averages.get('bfs_nodes_average')))
print('DFS Nodes Average: ' + str(averages.get('dfs_nodes_average')))
print('BiDir Nodes Average: ' + str(averages.get('bidir_nodes_average')))
print('BestF Nodes Average: ' + str(averages.get('bestf_nodes_average')))
print('AStar Nodes Average: ' + str(averages.get('astar_nodes_average')))



