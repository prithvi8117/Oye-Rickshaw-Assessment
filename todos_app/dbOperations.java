package todos_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class dbOperations {
	
	dbConnection connect = new dbConnection();
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	
	public void insertTask() throws SQLException {
		
		con = connect.getConnection();
		
		System.out.print("Enter Task's Title (max. 150 words) : ");
		String task_title = sc.nextLine();
		
		System.out.print("Enter its Due Date (YYYY-MM-DD) : ");
		String due_date = sc.nextLine();
		
		String task_priority = "";
		int ch = 0;
		do
		{
			System.out.print("Enter its Priority (Press 1-4):\n1. Very High\n2. High\n3. Medium\n4. Low : ");
			ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch)
			{
				case 1  :	task_priority += "Very High";
							break;
							
				case 2  :	task_priority += "High";
							break;
							
				case 3  :	task_priority += "Medium";
							break;
							
				case 4  :	task_priority += "Low";
							break;
							
				default : 	System.out.println("Please Enter Choice 1 to 4 !!!");
			}
		}while((ch < 1) || (ch > 4));
		
		String insertQuery = "INSERT INTO todo_list(title, due_date, priority, state) VALUES(?,?,?,?);";
		
		PreparedStatement pst = con.prepareStatement(insertQuery);
		pst.setString(1,task_title);
		pst.setString(2,due_date);
		pst.setString(3,task_priority);
		pst.setString(3,"Not Done");
		pst.executeUpdate();
		System.out.println("The Record is Inserted Successfully");
		pst.close();
			
		con.close();
	}
	
	public void removeTask() {

		con = connect.getConnection();
		
		System.out.print("Enter Task ID (todo_id) whose Record has to be deleted : ");
		int Id = sc.nextInt();
		sc.nextLine();
		try
		{
			String deleteQuery = "DELETE FROM todo_list WHERE todo_id=?;";
			
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setInt(1,Id);
			pst.execute();
			System.out.println("The Record is Deleted Successfully");
			pst.close();
			
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("Record Not Found, Maybe Wrong todo_id !!!");
		}
		
	}
	
	public void updateTask() throws SQLException {
		
		con = connect.getConnection();
		
		System.out.print("Enter todo_id whose state has to be Updated : ");
		int Id = sc.nextInt();
		sc.nextLine();
		String searchQuery = "SELECT * FROM todo_list WHERE todo_id=?;";
		
		PreparedStatement pst = con.prepareStatement(searchQuery);
		pst.setInt(1,Id);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			System.out.println("TODO ID: " + rs.getInt(1));
			System.out.println("Title: " + rs.getString(2));
			System.out.println("Date : " + rs.getString(3));
			System.out.println("Priority : " + rs.getString(4));
			System.out.println("State : " + rs.getString(5) + "\n");
		}
		else{
			System.out.println("Record Not Found...");
			return;
		}
		pst.close();
		
		String updatedState = "";
		int ch = 0;
		do
		{
			System.out.println("Now, Tell if this task is Done (Press 1) or Not Done (Press 2) :");
			ch = sc.nextInt();
			sc.nextLine();
			if(ch == 1)
			{
				updatedState += "Done";
			}
			else if(ch == 2)
			{
				updatedState += "Not Done";
			}
			else
			{
				System.out.print("Please Press 1 or 2");
				
			}
		}while((ch != 1) || (ch != 2));
		
		String updateQuery = "UPDATE todo_list SET state=? WHERE todo_id=?";
		PreparedStatement pst2 = con.prepareStatement(updateQuery);
		pst2.setString(1,updatedState);
		pst2.setInt(2,Id);
		pst2.executeUpdate();
		System.out.println("\nThe Record is Updated Succesfully");
		pst2.close();
		
		con.close();
	}
	
	public void displayTask() throws SQLException {
		
		con = connect.getConnection();
		
		String variable = "";
		int ch = 0;
		do
		{
			System.out.println("Searching the TODO by :\n1. Title\n2. Date\n3. Priority\n4. State");
			ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch)
			{
				case 1  :	variable += "title";
							System.out.print("Enter Task's Title whose Record has to be Displayed : ");
							break;
					
				case 2  :	variable += "due_date";
							System.out.print("Enter Date (due_date) of the task according to which, Record(s) has to be Displayed : ");
							break;
					
				case 3  :	variable += "priority";
							System.out.print("Enter the Priority of the task according to which, Record(s) has to be Displayed : ");
							break;
					
				case 4  :	variable += "state";
							System.out.print("Enter the state of the task according to which, Record(s) has to be Displayed : ");
							break;
					
				default :	System.out.println("Please Enter Choice from 1 to 4 !!!");
			}
		}while((ch < 1) || (ch > 4));
		
		String var = sc.nextLine();
		String searchQuery = "SELECT * FROM todo_list WHERE "+variable.toString()+"=?";
		
		PreparedStatement pst = con.prepareStatement(searchQuery);
		pst.setString(1,var);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			do {
				System.out.println("TODO ID: " + rs.getInt(1));
				System.out.println("Title: " + rs.getString(2));
				System.out.println("Date : " + rs.getString(3));
				System.out.println("Priority : " + rs.getString(4));
				System.out.println("State : " + rs.getString(5) + "\n");
			}while(rs.next());
		}
		else{
			System.out.println("Record Not Found...");
		}
		pst.close();
		
		con.close();
	}
	
	public void displayAllTasks() throws SQLException {
		
		con = connect.getConnection();
		
		String displayQuery = "SELECT * FROM todo_list";
		PreparedStatement pst = con.prepareStatement(displayQuery);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			do {
				System.out.println("TODO ID: " + rs.getInt(1));
				System.out.println("Title: " + rs.getString(2));
				System.out.println("Date : " + rs.getString(3));
				System.out.println("Priority : " + rs.getString(4));
				System.out.println("State : " + rs.getString(5) + "\n");
			}while(rs.next());
		}
		else{
			System.out.println("No Records Found...");
		}
		pst.close();
		
		con.close();
	}

}
