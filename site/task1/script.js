let secretNumber;
let attempts;
const maxAttempts = 7;

const guessInput = document.getElementById("guessInput");
const guessButton = document.getElementById("guessButton");
const message = document.getElementById("message");
const attemptsDisplay = document.getElementById("attempts");
const restartButton = document.getElementById("restartButton");

function startGame() {

    secretNumber = Math.floor(Math.random() * 100) + 1;
    attempts = 0;

    attemptsDisplay.textContent = maxAttempts;
    message.textContent = "Start guessing!";
    guessInput.value = "";

    guessInput.disabled = false;
    guessButton.disabled = false;

    restartButton.style.display = "none";

    guessInput.focus();
}

function checkGuess() {

    const guess = Number(guessInput.value);

    if (!guessInput.value) {
        message.textContent = "⚠️ Please enter a number.";
        return;
    }

    if (guess < 1 || guess > 100) {
        message.textContent = "⚠️ Enter a number between 1 and 100.";
        return;
    }

    attempts++;

    const remainingAttempts = maxAttempts - attempts;
    attemptsDisplay.textContent = remainingAttempts;

    if (guess === secretNumber) {

        message.textContent =
            "🎉 Congratulations! You guessed the correct number!";

        endGame();

    } else if (guess < secretNumber) {

        if (remainingAttempts > 0) {
            message.textContent =
                "📈 Too low! Try a higher number.";
        }

    } else {

        if (remainingAttempts > 0) {
            message.textContent =
                "📉 Too high! Try a lower number.";
        }
    }

    if (attempts >= maxAttempts && guess !== secretNumber) {

        message.textContent =
            "❌ Game Over! The correct number was " + secretNumber + ".";

        endGame();
    }

    guessInput.value = "";
    guessInput.focus();
}

function endGame() {

    guessInput.disabled = true;
    guessButton.disabled = true;

    restartButton.style.display = "block";
}

function restartGame() {

    startGame();
}

guessInput.addEventListener("keydown", function(event) {

    if (event.key === "Enter") {
        checkGuess();
    }

});

startGame();