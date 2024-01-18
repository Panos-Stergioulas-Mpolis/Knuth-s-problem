import java.math.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Node> list = new ArrayList<Node>();
		int m = 1;
		Scanner  console = new Scanner(System.in);
		boolean flag = true;
		double isWhole = 0.000000001;
		int alg = -1;
		double want = -1;
		long depth = 0;
		long StartTime = 0;
		long StopTime =0;
		boolean found = true;
		while(true) {
			System.out.print("which number are you interested in finding? ");
			want = console.nextDouble();	
			if(want > 0) {
				break;
			}
			else {
				System.out.print("\nChoose a positive number!\n\n");
			}
		}
		
		while(true) {
			System.out.print("Press 1 for bfs, Pres 2 for dfs: ");
			alg = console.nextInt();
			
			if(alg == 1 || alg == 2) {
				break;
			}
			else {
				System.out.println("\nChoose 1 or 2!\n");
			}
		}
		
		
		Node current = new Node(4);
	
		
		if(alg == 1) {
			StartTime = System.currentTimeMillis();
			while(true) {
				if(current.getval()== want) {
					StopTime = System.currentTimeMillis();
					found = true;
					break;
				}
				
				if(System.currentTimeMillis() - StartTime >= 60000)
				{
					found = false;
					System.out.println("\nCant find the ans for " + want);
					break;
				}
				
				if( (current.getval() <= 170) && (current.getval() - (Math.floor(current.getval()))< isWhole) && (current.getval() !=4 || flag == true) && (Math.floor(current.getval()) != 1) && (Math.floor(current.getval()) != 2)) {
							
					double ans = 1;		
							
					for(int i =1; i<= current.getval(); i++) {
								ans = ans * i;
					}
					current.setLeft(new Node(ans));
					current.getLeft().setParent(current);
					current.getLeft().setOp("Factorial");
					current.getLeft().setDepth(current.getDepth() + 1);
					list.add(current.getLeft());
					
				}
				
				
				if(current.getval() - Math.floor(current.getval()) > isWhole && current.getval() != 4 && !current.getOp().equals("Floor") && !current.getOp().equals("Factorial") ) {
					current.setMid(new Node(Math.floor(current.getval())));
					current.getMid().setParent(current);
					current.getMid().setOp("Floor");
					current.getMid().setDepth(current.getDepth() + 1);
					list.add(current.getMid());
				}
					
					
				if((current.getval() !=4 || flag == true)  && (Math.floor(current.getval()) != 1)) {
					flag = false;
					current.setRight(new Node(Math.sqrt(current.getval())));
					current.getRight().setParent(current);
					current.getRight().setOp("Root");
					current.getRight().setDepth(current.getDepth() + 1);
					list.add(current.getRight());
				}
					
				
				current = list.remove(0);
				m++;
				
				
				
			}
		
				
		}else {
			StartTime = System.currentTimeMillis();
			while(true) {
				
				if(current.getval()== want) {
					StopTime = System.currentTimeMillis();
					found = true;
					break;
				}

				if(m == 70000000)
				{
					found = false;
					System.out.println("\nCant find the ans for " + want);
					break;
				}
				
				if(current.getval() <= 170 && (current.getval() - Math.floor(current.getval()) < isWhole) && (current.getval() !=4 || flag == true) && (Math.floor(current.getval()) != 1) && (Math.floor(current.getval()) != 2) && current.getDepth() < depth) {
					
					double ans = 1;		
					
					for(int i =1; i<= current.getval(); i++) {
								ans = ans * i;
					}
					
			
					current.setLeft(new Node(ans));
					current.getLeft().setParent(current);
					current.getLeft().setOp("Factorial");
					current.getLeft().setDepth(current.getDepth() + 1);
					list.add(current.getLeft());
					
				}
				
				if(current.getval() - Math.floor(current.getval()) > isWhole && current.getval() != 4 && !current.getOp().equals("Floor") && !current.getOp().equals("Factorial") && current.getDepth() < depth) {
					current.setMid(new Node(Math.floor(current.getval())));
					current.getMid().setParent(current);
					current.getMid().setOp("Floor");
					current.getMid().setDepth(current.getDepth() + 1);
					list.add(current.getMid());
				}
				
				
				if((current.getval() !=4 || flag == true)  && (Math.floor(current.getval()) != 1) && current.getDepth() < depth) {
					flag = false;
					current.setRight(new Node(Math.sqrt(current.getval())));
					current.getRight().setParent(current);
					current.getRight().setOp("Root");
					current.getRight().setDepth(current.getDepth() + 1);
					list.add(current.getRight());
				}
				
				if(list.isEmpty()) {
					depth++;
					current = new Node(4);
					flag = true;
				}
				else {
					current = list.remove(list.size() - 1);
					
					m++;
				}

				
				
			}
		}
		
		if(found) {
		System.out.print("\n" + current.getval()); 
		System.out.println( "\nSteps: " + m + " Depth: " + current.getDepth() + " Time: " + (StopTime - StartTime) + "ms"+"\n");
		Node newcurrent = current;
		ArrayList<String> ops = new ArrayList<String>();
		while(true) {
			if(newcurrent.getParent() == null) {
				break;
			}
			else {
				ops.add(newcurrent.getOp());
				newcurrent = newcurrent.getParent();
			}
		}
		
		for(int j = ops.size()- 1; 0 <= j; j--) {
			System.out.println(ops.get(j));
		}
		}else
			System.out.println( "\nSteps: " + m + " Depth: -" +  " Time: -" +  "\n");
		{
			
		}
		
			
		}
		
}

	



