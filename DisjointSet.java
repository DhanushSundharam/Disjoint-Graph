import java.io.*;
import java.util.*;

public class DisjointSet {
    int[] rank ;
    int[] parent ;
    
   
    DisjointSet (int n){

        this.rank = new int[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            
            rank[i] = 0 ;
            parent[i] = i ;
            
        }


    }


    public int findUltimateParent (int node){
        if (node == parent[node]){
            return node ;
        }

      
        
        return  parent[node] = findUltimateParent(parent[node]);
    }

    public void unionByRank (int first , int second){
        int f1 = findUltimateParent(first);
        int s2 = findUltimateParent(second);

        if (rank[f1] > rank[s2]){
            parent[f1] = s2 ; 

        }
        else if (rank[f1] < rank[s2]){
            parent[s2] = f1 ;
        }else {
            parent[f1] = s2 ;
            rank[f1]++;
        }

    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.findUltimateParent(6) == ds.findUltimateParent(7)){
            System.out.println("Same");

        }
        else{
            System.out.println("Not same");
        }
    }
    
    
}
