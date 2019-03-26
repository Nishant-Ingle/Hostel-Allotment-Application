import java.util.*;
import java.io.*;
class Seats {
	int total_seats = 25;
	int open = 12;
	int obc = 5;
	int sc = 3, st = 2, vjnt1 = 1, nt2nt3 = 1, nri = 1;
}
class Node{
	String MIS;
	String first, last, dept, category;
	double cgpa;
	int status;
	Node next;
}
/*0. Civil 1. Computer 2. Electrical 3. ENTC 4. Instru 5. IT 6. Plan 7.Prod 8. Mech 9. Meta*/
class List {
	private Node[] d = new Node[10];
	public void linit() {
		int i = 0;
		for(i = 0; i < 10; i++) {
			d[i] = null;
		}
	}
	public int getIndexFromDepartment(String s) {
		if(s.charAt(0) == 'C') {
			if(s.charAt(1) == 'i') {
				return 0; 
			}
			else if(s.charAt(1) == 'o') {
				return 1;
			}
		}
		else if(s.charAt(0) == 'E') {
			if(s.charAt(1) == 'l') {
				return 2; 
			}
			else if(s.charAt(1) == 'N') {
				return 3;
			}
		}
		else if(s.charAt(0) == 'I') {
			if(s.charAt(1) == 'n') {
				return 4; 
			}
			else if(s.charAt(1) == 'T') {
				return 5;
			}
		}
		else if(s.charAt(0) == 'P') {
			if(s.charAt(1) == 'l') {
				return 6; 
			}
			else if(s.charAt(1) == 'r') {
				return 7;
			}
		}
		else if(s.charAt(0) == 'M') {
			if(s.charAt(2) == 'c') {
				return 8; 
			}
			else if(s.charAt(2) == 't') {
				return 9;
			}
		}
		return -1;	
	}
	
	public void linsert(String record) {
		String[] parts = record.split(",", 6);
		int index = getIndexFromDepartment(parts[4]);		
		Node temp = new Node();
		Node x = null, y = null;;
		temp.MIS = parts[0];
		temp.first = parts[1];
		temp.last = parts[2];
		temp.category = parts[3];
		temp.dept = parts[4];
		temp.cgpa = Double.parseDouble(parts[5]);
		temp.status = 0;
		temp.next = null;
		if(index == -1) {
			System.out.println("No such Department as " + parts[4]);
			return;
		}
		
		/*x = d[index];
		while(x.next != null) {
			x = x.next;
		}
		x.next = temp;
		*/
		if(d[index] == null) {
			//System.out.println("Case 1");
			d[index] = temp;
			temp.next = null;
			return;
			
		}
		else if(d[index].cgpa < temp.cgpa) {
			//System.out.println("Case 2");
			
			x = d[index];
			d[index] = temp;
			temp.next = x;
			return;
		}
		else{	
			//System.out.println("Case 3");
			x = d[index];
			while((temp.cgpa < x.cgpa) && (x.next != null)){
				//System.out.println("Comparing +" + temp.cgpa + " " + x.cgpa);
				y = x;
				x = x.next;
			}
			if(x.next == null) {
				if(temp.cgpa > x.cgpa) {
					y.next = temp;
					temp.next = x;	
				}
				else {
					x.next = temp;
					temp.next = null;
					return;
				}
			}
			y.next = temp;
			temp.next = x;
		}
	}
	void print_deptwise() {
		Node x;
		x = d[0];
		System.out.print("Civil : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");
	
		x = d[1];
		System.out.print("Computer : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");

		x = d[2];
		System.out.print("Electrical : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");

		x = d[3];
		System.out.print("ENTC : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");

		x = d[4];
		System.out.print("Instru : ");
		while(x != null){	
			System.out.print(x.first + " ");
			x = x.next;
		
		}
		System.out.print("\n");

		x = d[5];
		System.out.print("IT : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");

		x = d[6];
		System.out.print("Planning : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");

		x = d[7];
		System.out.print("Prod : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");

		x = d[8];
		System.out.print("Mechanical : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");
		x = d[9];
		System.out.print("Metallurgy : ");
		while(x != null){
			System.out.print(x.first + " ");
			x = x.next;
		}
		System.out.print("\n");

	}
	public void write_to_file() {
		try {	
			Seats n = new Seats();
			
			PrintWriter pw = new PrintWriter(new FileWriter("/home/vicky/Desktop/output.csv"));
			pw.printf("MIS,FirstName,LastName,Category,Department,CGPA\n");
			Node x = d[0];
			Node y = d[0];
			int i = 0, j = 0, s;
			for(i = 0; i < 10; i++) {
				x = d[i];
				s = n.open;
				for(j = 0; j < s; j++) {
					if(x == null) {
						break;
					}
						pw.printf("%s,%s,%s,%s,%s,%f,OPEN-%d\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa, j);
						x.status = 1;
					
					y = x;
					x = x.next;
				}
				x = y;
				j = n.obc;
				while(x != null && j > 0) {
					if(x.category.equals("OBC") && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,OBC - %d\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa,n.obc - j + 1);
						x.status = 1;
						j--;
						
					}
					x = x.next;
				}
				if(j > 0) {
					x = y;
					while((x != null) && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f, OBC - %d\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa, n.obc - j + 1);
						x.status = 1;
						j--;
					}
				}
				x = y;
				j = n.sc;
				while(x != null && j != 0) {
					if(x.category.equals("SC") && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,SC\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
						
					}
					x = x.next;
				}
				if(j != 0) {
					x = y;
					while((x != null) && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,SC\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
					}
				}
				x = y;
				j = n.st;
				while(x != null && j != 0) {
					if(x.category.equals("ST") && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,ST\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
						
					}
					x = x.next;
				}
				if(j != 0) {
					x = y;
					while((x != null) && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,ST\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
					}
				}
				x = y;
				j = n.vjnt1;
				while(x != null && j != 0) {
					if(x.category.equals("VJ") && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,VJ/NT1\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
						
					}
					x = x.next;
				}
				if(j != 0) {
					x = y;
					while((x != null) && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,VJ/NT1\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
					}
				}
				x = y;
				j = n.nt2nt3;
				while(x != null && j != 0) {
					if(x.category.equals("NT") && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,NT2/NT3\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
						
					}
					x = x.next;
				}
				if(j != 0) {
					x = y;
					while((x != null) && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,NT2/NT3\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
					}
				}
				x = y;
				j = n.nri;
				while(x != null && j != 0) {
					if(x.category.equals("NRI") && (x.status == 0)) {
						pw.printf("%s,%s,%s,%s,%s,%f,NRI\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
						
					}
					x = x.next;
				}
				if(j != 0) {
					x = y;
					while((x != null) && (x.status == 0)) {
					pw.printf("%s,%s,%s,%s,%s,%f,NRI\n", x.MIS, x.first, x.last, x.category, x.dept, x.cgpa);
						x.status = 1;
						j--;
				}
					}

				
			}
			
			pw.close();
		}
		catch (IOException ex) {
			throw new RuntimeException("Not found", ex);
		}
	}
}

class GetData {
	int mis;
	String firstName, lastName;
	String Category, Gender, Department;
	double CGPA;
	
	public void getInputFromUser() {
		int choice;
		Scanner ss = new Scanner(System.in);
		System.out.print("Enter MIS: ");
		mis = ss.nextInt();
		System.out.print("Enter First Name: ");
		firstName = ss.nextLine();
		System.out.print("Enter Last Name: ");
		lastName = ss.nextLine();
		System.out.println("Select Gender from the Following\n1. MALE\t2. FEMALE\t3. OTHER");
		choice = ss.nextInt();
		switch(choice) {
			case 1: Gender = "MALE"; break;
			case 2: Gender = "FEMALE"; break;
			case 3: Gender = "OTHER"; break;
			default: System.out.println("Invalid Choice. Can't ENter Date in records. Enter again");
				getInputFromUser();
		}
		System.out.println("Select Category from the Following\n1. OPEN\t2. OBC\t3. NT\n4. SC\t5. ST\t6. VJ");
		choice = ss.nextInt();
		switch(choice) {
			case 1: Category = "OPEN"; break;
			case 2: Category = "OBC"; break;
			case 3: Category = "NT"; break;
			case 4: Category = "SC"; break;
			case 5: Category = "ST"; break;
			case 6: Category = "VJ"; break;
			default: System.out.println("Invalid Choice. Can't ENter Date in records. Enter again");
				getInputFromUser();
		}
		/*0. Civil 1. Computer 2. Electrical 3. ENTC 4. Instru 5. IT 6. Plan 7.Prod 8. Mech 9. Meta*/
		System.out.println("Select Department from the Following");
		System.out.println("1. Civil\t2. Computer\t3. Electrical\n4. ENTC\t5. Instru\t6. IT");
		System.out.println("7. Plan\t8. Prod\t9. Mech\t10. Meta");
		choice = ss.nextInt();
		switch(choice) {
			case 1: Department = "Civil"; break;
			case 2: Department = "Computer"; break;
			case 3: Department = "Electrical"; break;
			case 4: Department = "ENTC"; break;
			case 5: Department = "Instru"; break;
			case 6: Department = "IT"; break;
			case 7: Department = "Plan"; break;
			case 8: Department = "Prod"; break;
			case 9: Department = "Mech"; break;
			case 10: Department = "Meta"; break;
			default: System.out.println("Invalid Choice. Can't ENter Date in records. Enter again");
				getInputFromUser();
		}
		System.out.print("Enter Last CGPA: ");
		CGPA = ss.nextDouble();
	}
	public void storeToFile(){
		
		try {
		    PrintWriter pw = new PrintWriter(new FileWriter("/home/vicky/Desktop/output.csv"));
		    pw.printf("%d,%s,%s,%s,%s,%lf\n",mis, firstName, lastName, Category, Department, CGPA);
		    pw.close();   
		} catch (IOException e) {
			throw new RuntimeException("Not found", e);	
		}
	}
}
class New {
	public static void main(String args[]) {
		try {
			File fp = new File("/home/vicky/Desktop/data.csv");
			Scanner sc = new Scanner(fp);
			Scanner sq = new Scanner(System.in);
			int choice;
			String s;
			List l = new List();
			GetData gd = new GetData();
			System.out.println("Enter data in the records");
			System.out.println("1. YES\t\t2. NO");
			choice = sq.nextInt();
			if(choice == 1) {
				gd.getInputFromUser();
				gd.storeToFile();
			}
			l.linit();
			while(sc.hasNextLine() == true) {
				l.linsert(sc.nextLine());
			}
			l.print_deptwise();
			l.write_to_file();
			sc.close();
		}
		catch (IOException ex) {
			throw new RuntimeException("Not found", ex);
		}
	}
} 
