CREATE TABLE todo_list(
	todo_id SERIAL PRIMARY KEY,
	title VARCHAR(150) NOT NULL,
	due_date DATE NOT NULL,
	priority VARCHAR(15) NOT NULL,
	state VARCHAR(15) NOT NULL);

	

INSERT INTO
	todo_list (title, due_date, priority, state)
VALUES
	('Email project report of project2 to client3', '2021-01-25', 'Medium', 'Not Done'),
	('Buy medicine of cold', '2021-01-18', 'High', 'Not Done'),
	('Email to ask for the requirements of the project4 from client5', '2021-01-20', 'High', 'Not Done');



SELECT * FROM todo_list;