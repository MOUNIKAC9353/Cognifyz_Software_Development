function convertTemperature() {

    const temperatureInput =
        document.getElementById("temperature");

    const conversion =
        document.getElementById("conversion").value;

    const result =
        document.getElementById("result");

    const temperature =
        parseFloat(temperatureInput.value);

    if (isNaN(temperature)) {

        result.textContent =
            "Please enter a valid temperature.";

        return;
    }

    let convertedTemperature;

    if (conversion === "cToF") {

        convertedTemperature =
            (temperature * 9 / 5) + 32;

        result.textContent =
            temperature.toFixed(2) +
            " °C = " +
            convertedTemperature.toFixed(2) +
            " °F";

    } else {

        convertedTemperature =
            (temperature - 32) * 5 / 9;

        result.textContent =
            temperature.toFixed(2) +
            " °F = " +
            convertedTemperature.toFixed(2) +
            " °C";
    }
}


function clearResult() {

    document.getElementById("temperature").value = "";

    document.getElementById("result").textContent = "";
}