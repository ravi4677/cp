package Questions1400;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class Path_queries {
public static class Disjoint{
	
	class Node{
		int val;
	
		int rank;
		int size;
		Node parent;
	}
	private HashMap<Integer,Node>map=new HashMap<>();
	public void createDisjoint(int v) {
		Node nn=new Node();
		nn.val=v;
		nn.rank=0;
		nn.size=1;
		nn.parent=nn;
		map.put(v, nn);
	}
	public int find(int v) {
		Node nn=map.get(v);
		return find(nn).val;
	}
	public Node find(Node nn) {
		if(nn.parent==nn) {
			return nn;
		}
		Node rn=find(nn.parent);
		nn.parent=rn;
		return rn;
	}
	public long union(int v1,int v2) {
		Node n1=map.get(v1);
		Node n2=map.get(v2);
		Node rn1=find(n1);
		Node rn2=find(n2);
		if(rn1==rn2) {
			return 0;
		}
		  long pairs = 1L * rn1.size * rn2.size;
		if(rn1.rank==rn2.rank) {
			rn2.parent=rn1;
			rn1.rank++;
			rn1.size+=rn2.size;
		}
		else if(rn1.rank>rn2.rank) {
			rn2.parent=rn1;
			rn1.size+=rn2.size;
		}
		else {
			rn1.parent=rn2;
			rn2.size+=rn1.size;
		}
		return pairs;
	}
}
public static class Edge{
	int u;
	int v;
	int w;
	Edge(int u,int v,int w){
		this.u=u;
		this.v=v;
		this.w=w;
	}
}
public static class Query{
	int q;
	int idx;
	Query(int q,int idx){
		this.q=q;
		this.idx=idx;
	}
}
public static void main(String[] args) {
	Scanner Scan=new Scanner(System.in) ;
		int n=Scan.nextInt();
		int m=Scan.nextInt();
		Edge[]edges=new Edge[n-1];
		for(int i=0;i<n-1;i++) {
			int u=Scan.nextInt();
			int v=Scan.nextInt();
			int w=Scan.nextInt();
			edges[i]=new Edge(u,v,w);
		}
		Query []queries=new Query[m];
		for(int i=0;i<m;i++) {
			int a=Scan.nextInt();
			queries[i]=new Query(a,i);
		}
		Arrays.sort(edges,new Comparator<Edge>() {
			@Override
			public int compare(Edge o1,Edge o2) {
				return o1.w-o2.w;
			}
				
		});
		Arrays.sort(queries,new Comparator<Query>() {
			@Override
			public int compare(Query o1,Query o2) {
				return o1.q-o2.q;
			}
		});
		long []ans=new long[m];
		Disjoint dj=new Disjoint();
		for(int i=1;i<=n;i++) {
			dj.createDisjoint(i);
		}
		long pairs=0;
		int j=0;
		for(Query queri:queries) {
			while(j<edges.length&&edges[j].w<=queri.q) {
				pairs+=dj.union(edges[j].u, edges[j].v);
				j++;
			}
			ans[queri.idx]=pairs;
		}
		  for (long x : ans) {
	            System.out.print(x + " ");
	        }
	
}
}
