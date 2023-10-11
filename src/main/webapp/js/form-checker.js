const form = document.getElementById('form');
form.addEventListener("change", () => {
    document.getElementById('btn').disabled = !form.checkValidity()
});
