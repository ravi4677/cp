package Questions800;

import java.util.Scanner;

public class Spring {
public static void main(String[] args) {
	Scanner Scan=new Scanner(System.in);
	int t=Scan.nextInt();
	while(t-->0) {
		int a=Scan.nextInt();
		int b=Scan.nextInt();
		int c=Scan.nextInt();
		long m=Scan.nextLong();
		water(a,b,c,m);
	}
			
}
public static void water(int a,int b,int c,long m) {
	long a_count=m/a;
	long b_count=m/b;
	long c_count=m/c;
	long all=m/lcm(a,b,c);
	long a_b=m/lcm(a,b);
	long a_c=m/lcm(a,c);
	long b_c=m/lcm(b,c);
//	long rem_all=m/all;
	long rem_a_b=a_b-all;
	long rem_a_c=a_c-all;
	long rem_b_c=b_c-all;
	long rem_a=a_count-(all+rem_a_b+rem_a_c);
	long rem_b=b_count-(all+rem_b_c+rem_a_b);
	long rem_c=c_count-(all+rem_a_c+rem_b_c);
	long sum_a=all*2+(rem_a_b+rem_a_c)*3+rem_a*6;
	long sum_b=all*2+(rem_a_b+rem_b_c)*3+rem_b*6;
	long sum_c=all*2+(rem_b_c+rem_a_c)*3+rem_c*6;
	System.out.println(sum_a+" "+sum_b+" "+sum_c);
//	long sum_a=(m/all)*2+((m/a_b)-(m/all))*3+((m/a_c)-(m/all))*3+(a_count-(((m/a_b)-(m/all))
}
public static long gcd(long a,long b) {
	a=Math.abs(a);
	b=Math.abs(b);
	while(b!=0) {
		long temp=b;
		b=a%b;
		a=temp;
	}
	return a;
}
public static long lcm(long a,long b) {
	return a/gcd(a,b)*b;
}
public static long lcm(long a,long b,long c) {
	return lcm(lcm(a,b),c);
}
}
