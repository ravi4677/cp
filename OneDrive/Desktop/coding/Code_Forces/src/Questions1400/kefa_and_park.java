package Questions1400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class kefa_and_park {
	static int ans=0;
public static void main(String[] args) {
	Scanner Scan=new Scanner(System.in);
	int n=Scan.nextInt();
	int m=Scan.nextInt();
	int[]arr=new int[n+1];
	for(int i=1;i<=n;i++) {
		arr[i]=Scan.nextInt();
	}
	HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
	for(int i=1;i<=n;i++) {
		map.put(i, new HashSet<>());
	}
	for(int i=1;i<n;i++) {
		int u=Scan.nextInt();
		int v=Scan.nextInt();
        map.get(u).add(v);
		map.get(v).add(u);
		
		
	}
	leaves(map,arr,m);
      
}
public static void leaves(HashMap<Integer,HashSet<Integer>>map,int[]arr,int m) {
	HashSet<Integer>visited=new HashSet<>();
	visited.add(1);
	int a=dfs(1,map,arr,visited,m,arr[1]);
	System.out.println(a);
	
}
public static int dfs(int src,HashMap<Integer,HashSet<Integer>>map,int[]arr,HashSet<Integer>visited,int m,int count) {
	if(count>m) {
		return ans;
	}
	boolean leaf=true;
	for(int nbrs:map.get(src)) {
		if(!visited.contains(nbrs)) {
			visited.add(nbrs);
			leaf=false;
			int newcats=arr[nbrs]==1?count+1:0;
			dfs(nbrs,map,arr,visited,m,newcats);
		}
	
	}
	if(leaf&&src!=1) {
		ans++;
	}
	return ans;
}
}
