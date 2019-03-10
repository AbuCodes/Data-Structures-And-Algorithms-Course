import java.util.Scanner;

/**
 * This Demo class its the user prompt controller and demos the solution to the
 * user by showing the functionality of the different methods in our program.
 **/

public class Demo 
{
	public static void main(String[] args) 
	{
		int choice, data, x;
		Scanner scan = new Scanner(System.in);
		
		DoubleLinkedList List = new DoubleLinkedList();
		List.createList();
		
		while (true) 
		{
			System.out.println("1. Display");
			System.out.println("2. Swap");
			System.out.println("3. Quit");
			choice = scan.nextInt();
			
			if(choice == 3) 
			{
				break;
			}
			
			switch(choice) 
			{
				case 1:
					System.out.println("Display the list");
					List.displayList();
					break;
				
				case 2:
					System.out.println("Enter element to be swapped");
					x = scan.nextInt();
					List.swapElement(x);
					break;
					
				default:
					System.out.println("Choice is invalid.");	
			}
		}
		scan.close();
	}
}
