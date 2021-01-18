package todos_app;

import java.sql.SQLException;
import java.util.Scanner;

public class main_menu {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		char ch='y';

		System.out.println("\t\tTODO(Tasks) List\n\t\t================");
		do {
			System.out.println("\nEnter Your Choice :");
			System.out.println("1. Add New Task\n2. Remove a Task\n3. Update State of Task\n4. Display any Task\n5. Display All Tasks (TODO List)");
			choice = sc.nextInt();
			sc.nextLine();
			
			dbOperations operations = new dbOperations();
			switch (choice) {
				case 1:
						operations.insertTask();
						break;
	
				case 2:
						operations.removeTask();
						break;
	
				case 3:
						operations.updateTask();
						break;
	
				case 4:
						operations.displayTask();
						break;
	
				case 5:
						operations.displayAllTasks();
						break;
	
				default:
						System.out.println("WRONG ENTRY !!! Please Try Again !!!");

			}
			System.out.println("\nWANT TO CONTINUE (Y/N) ");
			ch = sc.next().charAt(0);
		} while ((ch == 'y') || (ch == 'Y'));
		sc.close();
		
	}

}
