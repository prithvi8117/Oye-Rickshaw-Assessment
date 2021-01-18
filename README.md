# Oye-Rickshaw-Assessment
Assessment Given by the company Oye! Rickshaw

'TO DO' APPLICATION :

todo Application is an application in which a user can do following things:
1. The user is able to create/read/update/delete todos (that is to create and modifies the Tasks List).
2. The user is able to search an existing todo(task) by title/date/priority/state.
3. The user is also able to prioritize the todos(tasks).

Software Requirement:
- Java-1.8.0_241 : https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html
- PostgreSQL-13.1-1 : https://www.postgresql.org/download/
- Eclipse Workspace : https://www.eclipse.org/downloads/packages/release/2020-09/r
- PostgreSQL JDBC driver (JDBC-4.2) : https://jdbc.postgresql.org/download.html

I have uploaded 3 Java Class files (Source code files), 1 sql file and 1 text file showing todo_list table schema result:
- main_menu.class : This class is giving an interface of main menu with create/read/update/delete (CRUD) todos options for the user. 
- dbConnection.class : This class file is for the connection of java application with the PostgreSQL Database Server.
- dbOperations.class : This class file contains the code to provide the CRUD operations functionality to the application.
- todo_list.sql : This sql file is just a reference to work in PostgreSQL Database (Create table and insert into it)
- todo_list_showResult.txt : This text file is just showing the todo_list table created and modified after some dry run of the application.

The todo_list table is a having 5 attributes:
- todo_id : This attribute auto-generates (a unique number) with every new entry in the table.
- title : Title can be a string upto 150 letters, describing the task(todo).
- due_date : Due Date is the last date, before which the task should be done.
- priority : Priority can be : Very High / High / Medium / Low, that defines how important, is that task is.
- state : State can be Done / Not Done.
