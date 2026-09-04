let tasks = [];

let nextId = 1;

function addTask() {

    const title =
        document.getElementById("title").value.trim();

    const description =
        document.getElementById("description").value.trim();

    const status =
        document.getElementById("status").value;

    const message =
        document.getElementById("message");

    if (!title || !description) {

        message.textContent =
            "Please enter both title and description.";

        return;
    }

    const task = {

        id: nextId++,

        title: title,

        description: description,

        status: status
    };

    tasks.push(task);

    document.getElementById("title").value = "";

    document.getElementById("description").value = "";

    message.textContent =
        "Task created successfully!";

    displayTasks();
}


function displayTasks() {

    const taskList =
        document.getElementById("taskList");

    if (tasks.length === 0) {

        taskList.innerHTML =
            '<p class="empty">No tasks available.</p>';

        return;
    }

    taskList.innerHTML = "";

    tasks.forEach(function(task) {

        const taskElement =
            document.createElement("div");

        taskElement.className = "task";

        taskElement.innerHTML = `

            <h3>${task.id}. ${task.title}</h3>

            <p>${task.description}</p>

            <p class="status">
                Status: ${task.status}
            </p>

            <div class="actions">

                <button onclick="updateTask(${task.id})">
                    ✏️ Update
                </button>

                <button
                    class="delete"
                    onclick="deleteTask(${task.id})">
                    🗑️ Delete
                </button>

            </div>
        `;

        taskList.appendChild(taskElement);
    });
}


function updateTask(id) {

    const task =
        tasks.find(function(item) {
            return item.id === id;
        });

    if (!task) {
        return;
    }

    const newTitle =
        prompt("Enter new task title:", task.title);

    if (newTitle === null) {
        return;
    }

    const newDescription =
        prompt(
            "Enter new description:",
            task.description
        );

    if (newDescription === null) {
        return;
    }

    const newStatus =
        prompt(
            "Enter status:",
            task.status
        );

    if (newStatus === null) {
        return;
    }

    task.title = newTitle;

    task.description = newDescription;

    task.status = newStatus;

    document.getElementById("message").textContent =
        "Task updated successfully!";

    displayTasks();
}


function deleteTask(id) {

    const confirmed =
        confirm("Are you sure you want to delete this task?");

    if (!confirmed) {
        return;
    }

    tasks =
        tasks.filter(function(task) {
            return task.id !== id;
        });

    document.getElementById("message").textContent =
        "Task deleted successfully!";

    displayTasks();
}


displayTasks();