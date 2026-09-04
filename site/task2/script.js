function generatePattern() {

    const rowsInput = document.getElementById("rows");
    const patternType = document.getElementById("pattern").value;

    const output = document.getElementById("output");
    const message = document.getElementById("message");

    const rows = Number(rowsInput.value);

    if (!rows || rows < 1 || rows > 20) {

        message.textContent =
            "Please enter a number of rows between 1 and 20.";

        output.textContent =
            "Your generated pattern will appear here.";

        return;
    }

    let pattern = "";

    if (patternType === "pyramid") {

        for (let i = 1; i <= rows; i++) {

            for (let space = 1; space <= rows - i; space++) {
                pattern += " ";
            }

            for (let j = 1; j <= i; j++) {
                pattern += j + " ";
            }

            pattern += "\n";
        }
    }

    else if (patternType === "triangle") {

        for (let i = 1; i <= rows; i++) {

            for (let j = 1; j <= i; j++) {
                pattern += j + " ";
            }

            pattern += "\n";
        }
    }

    else if (patternType === "square") {

        for (let i = 1; i <= rows; i++) {

            for (let j = 1; j <= rows; j++) {
                pattern += j + " ";
            }

            pattern += "\n";
        }
    }

    output.textContent = pattern;

    message.textContent =
        "Pattern generated successfully!";
}


function clearPattern() {

    document.getElementById("rows").value = "";

    document.getElementById("pattern").value =
        "pyramid";

    document.getElementById("output").textContent =
        "Your generated pattern will appear here.";

    document.getElementById("message").textContent = "";
}