#include <stdio.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <fstream>
#include <ctime>
using namespace std;

typedef vector<int> VInt;
typedef vector<VInt> VVInt;
typedef VInt::iterator VIter;
typedef pair<int, int> PInt;
typedef vector<PInt> VPInt;
typedef vector<VPInt> VVPInt;
typedef VPInt::iterator VPIter;

VVInt graph;
VInt colors, parents, enter, leave, low, bcc;
int myTime = 0;
int newIndex = 0;

void visitLow(int u) {
   colors[u] = 1;
   low[u] = enter[u] = ++myTime;
   
   for(VIter it = graph[u].begin(); it != graph[u].end(); it++)
      if(colors[*it] == 0) {
         parents[*it] = u;
         visitLow(*it);
         low[u] = min(low[u], low[*it]);
      } else if(colors[*it] == 1 && *it != parents[u]) {
         low[u] = min(low[u], enter[*it]);
      }
   
   colors[u] = 2;
   leave[u] = ++myTime;      
}

void visitBCC(int u) {
   for(VIter it = graph[u].begin(); it != graph[u].end(); it++)
      if(parents[*it] == u) {
         bcc[*it] = (low[*it] < enter[u]) ? bcc[u] :         
                    (low[*it] > enter[u]) ? -1 :             
                    (newIndex++);                            
         visitBCC(*it);         
      }
}

 int getBCC(int u, int v) {
    return bcc[(enter[u] > enter[v]) ? u : v];
 }


int main() {
	unsigned int start_time =  clock();
	setlocale(LC_ALL, "rus");
    char buff[50];
    
    
   int n, m, i, s;
   printf("Введите способ ввода: (1-матрица смежности, 2 - метод задания ребер)");
   scanf("%d",&s);
   if (s==2) {
   	ifstream fin("hinput.txt");
	   //scanf("%d%d", &n, &m);
	   n = 8;
	   m = 8;
	   graph.resize(n);
	   while(m--) {
		  int from, to;
		  //scanf("%d%d", &from, &to);
		  fin>>from>>to;
		  //cout<<from<<to;
		  graph[from - 1].push_back(to - 1);
		  graph[to - 1].push_back(from - 1);
	   }
	   fin.close();
   } else {
	   if (s==1) {
	   	ifstream fin("input.txt");
	       //scanf("%d", &n);
	       n=8;
		   graph.resize(n);
	       int val;
		   for (int j=0 ; j<n; j++) {
		       for (int k = 0; k<n; k++) {
		       		fin >> val;
		           if (val!=0 && k>j) {
		                graph[k].push_back(j);
		                graph[j].push_back(k);
		                }
		           }
		       }
	   }
   }
   
   colors.assign(n, 0);
   parents.assign(n, -1);
   enter.resize(n);
   leave.resize(n);
   low.resize(n);
   for(i = 0; i < n; i++)
      if(colors[i] == 0)
         visitLow(i);
         
   bcc.assign(n, -1);
   for(i = 0; i < n; i++)
      if(parents[i] == -1)
         visitBCC(i);   

   VPInt bridges;
   VVPInt comps(newIndex);
   for(i = 0; i < n; i++)
      for(VIter it = graph[i].begin(); it != graph[i].end(); it++)
         if(i < *it) {
            int id = getBCC(i, *it);
            ((id == -1) ? bridges : comps[id]).push_back(PInt(i, *it));
         }
   
   //printf("Сomponent: ");
   //for(VPIter bridge = bridges.begin(); bridge != bridges.end(); bridge++)
   //   printf("(%d, %d) ", bridge->first + 1, bridge->second + 1);
   //printf("\n\n\n\n");
   
   for(i = 0; i < newIndex ; i++) {
      printf("Component %d: ", i);
      for(VPIter edge = comps[i].begin(); edge != comps[i].end(); edge++)
            printf("(%d, %d) ", edge->first + 1, edge->second + 1);
    	printf("\n");
   }
      for(VPIter bridge = bridges.begin(); bridge != bridges.end(); bridge++) {
      		printf("Component %d: ", i);
      	    printf("(%d, %d) \n", bridge->first + 1, bridge->second + 1);
			i++;      
        }
   
   
    
   
   unsigned int end_time = clock(); 
   unsigned int search_time = end_time - start_time;
   cout<<"Время работы "<<search_time;
}
