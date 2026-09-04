# Task 5 - Persistent Task Manager

## Cognifyz Technologies Software Development Internship

### Objective

Enhance the Task Manager application by implementing persistent storage using file I/O.

### Features

- Create tasks
- View tasks
- Update tasks
- Delete tasks
- Persistent task storage
- Load tasks automatically when the application starts
- Save changes automatically
- File I/O exception handling
- Input validation

### Technologies Used

- Java
- ArrayList
- File I/O
- BufferedReader
- BufferedWriter
- Git
- GitHub

### Persistence

Task information is stored in `tasks.txt`.

When the application starts, previously saved tasks are loaded from the file.

When a task is created, updated or deleted, the changes are saved automatically.

### Testing

The application was tested by:

1. Creating a task.
2. Saving the task to the file.
3. Exiting the application.
4. Starting the application again.
5. Loading the previously saved task.
6. Viewing the saved task.

### Learning Outcomes

- File handling in Java
- Reading and writing text files
- Exception handling
- Persistent data storage
- CRUD operations
- Java collections
- Input validation