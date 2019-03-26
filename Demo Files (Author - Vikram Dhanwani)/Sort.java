import java.util.Scanner;
import java.io.*;
class Node{
	String MIS;
	String first, last, dept, category;
	double cgpa;
	Node next;
}
/*
	1. IT 2. Instru 3. Mech 4.Elec 5.ENTC 6. Meta 7.Prod 8. Comp 9. Civil 10. Plan
*/

class List{
	Node[] d = new Node[10];
	void linit() {
		int i =0 ;
		for(i = 0; i < 10; i++) {
			d[i] = null;
		}		
	}
	void linsert(String sn) {
		Node temp = new Node();
		Node x = temp;
		String parts[] = sn.split(",", 6);
		int i = 0;
		/*for(i = 0; i < 	parts.length; i++) {
			//System.out.print(parts[i] + " ");
		
			
		}	
		System.out.print("\n");*/
		
		temp.MIS = parts[0];
		temp.first = parts[1];
		temp.last = parts[2];
		temp.category = parts[3];
		temp.dept = parts[4];
		temp.cgpa = Double.parseDouble(parts[5]);
		temp.next = null;
		if(temp.dept.charAt(0) == 'I') {
			if(temp.dept.charAt(1) == 'T') {
				x = d[0];
					
			}
			else if(temp.dept.charAt(1) == 'n'){
				x = d[1];
				
			}
		}
		else if(temp.dept.charAt(0) == 'E') {
			if(temp.dept.charAt(1) == 'l') {
				x = d[3];
					
			}
			else if(temp.dept.charAt(1) == 'N'){
				x = d[4];
				
			}
		}
		else if(temp.dept.charAt(1) == 'M') {
			if(temp.dept.charAt(2) == 't') {
				x = d[5];
					
			}
			else if(temp.dept.charAt(2) == 'c'){
				x = d[2];
				
			}
		}
		else if(temp.dept.charAt(0) == 'P') {
			if(temp.dept.charAt(1) == 'r') {
				x = d[6];
					
			}
			else if(temp.dept.charAt(1) == 'l'){
				x = d[9];
				
			}
		}
		else if(temp.dept.charAt(0) == 'C') {
			if(temp.dept.charAt(1) == 'i') {
				x = d[8];
					
			}
			else if(temp.dept.charAt(1) == 'o'){
				x = d[7];
				
			}
		}
		if(x == null) {
			x = temp;
			x.next = null;
			return;
		}
		while(x.next != null) {
			x = x.next;
		}
		x.next = temp;
		
	}
	/*
	1. IT 2. Instru 3. Mech 4.Elec 5.ENTC 6. Meta 7.Prod 8. Comp 9. Civil 10. Plan
*/
	void print_deptwise() {
		Node x;
		x = d[0];
		System.out.print("IT : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");
	
		x = d[1];
		System.out.print("Instru : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

		x = d[2];
		System.out.print("Mech : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

		x = d[3];
		System.out.print("Elec : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

		x = d[4];
		System.out.print("ENTC : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

		x = d[5];
		System.out.print("Meta : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

		x = d[6];
		System.out.print("Prod : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

		x = d[7];
		System.out.print("Comp : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

		x = d[8];
		System.out.print("Civil : ");
		while(x != null){
			System.out.print(x.first + " ");
		}
		System.out.print("\n");

	}
	
}
class Sort{
	public static void main(String args[]) {
		try {
			String filename = "data.csv";
			File fp = new File("/home/vicky/Desktop/data.csv");
			Scanner sc = new Scanner(fp);
			String s;
			List l = new List();
			l.linit();
		
			while(sc.hasNextLine()) {
				l.linsert(sc.nextLine());
				//System.out.println(sc.nextLine());
			}
			sc.close();
			l.print_deptwise();
		}
		catch(IOException ex) {
			throw new RuntimeException("NOt Found", ex);
		}
		
	}
}

