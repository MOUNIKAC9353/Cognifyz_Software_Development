let tasks = JSON.parse(localStorage.getItem("cognifyzTasks")) || [];

function saveTasks() {
    localStorage.setItem(
        "cognifyzTasks",
        JSON.stringify(tasks)
    );
}

function addTask() {

    const title =
        document.getElementById("title").value.trim();

    const description =
        document.getElementById("description").value.trim();

    const status =
        document.getElementById("status").value;

    if (title === "" || description === "") {

        alert("Please enter both title and description.");

        return;
    }

    const task = {

        id: Date.now(),

        title: title,

        description: description,

        status: status
    };

    tasks.push(task);

    saveTasks();

    clearForm();

    displayTasks();
}

function displayTasks() {

    const taskList =
        document.getElementById("taskList");

    taskList.innerHTML = "";

    if (tasks.length === 0) {

        taskList.innerHTML =
            '<div class="empty">No tasks available.</div>';

        return;
    }

    tasks.forEach(function(task) {

        const div =
            document.createElement("div");

        div.className = "task";

        div.innerHTML = `
            <h3>${escapeHTML(task.title)}</h3>

            <p>
                <strong>Description:</strong>
                ${escapeHTML(task.description)}
            </p>

            <p>
                <strong>Status:</strong>
                ${escapeHTML(task.status)}
            </p>

            <button onclick="editTask(${task.id})">
                Update
            </button>

            <button
                class="delete"
                onclick="deleteTask(${task.id})"
            >
                Delete
            </button>
        `;

        taskList.appendChild(div);
    });
}

function editTask(id) {

    const task =
        tasks.find(function(item) {
            return item.id === id;
        });

    if (!task) {
        return;
    }

    const newTitle =
        prompt("Enter new title:", task.title);

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
            "Enter new status:",
            task.status
        );

    if (newStatus === null) {
        return;
    }

    task.title = newTitle.trim();

    task.description = newDescription.trim();

    task.status = newStatus.trim();

    saveTasks();

    displayTasks();
}

function deleteTask(id) {

    if (!confirm("Delete this task?")) {
        return;
    }

    tasks =
        tasks.filter(function(task) {
            return task.id !== id;
        });

    saveTasks();

    displayTasks();
}

function clearForm() {

    document.getElementById("title").value = "";

    document.getElementById("description").value = "";

    document.getElementById("status").value = "Pending";
}

function escapeHTML(value) {

    return value
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}

displayTasks();