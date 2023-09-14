const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
});


document.getElementById("Esubmit").addEventListener("submit", (e) => {
    e.preventDefault();
    let password = document.getElementById("Epassword").value;
    let username = document.getElementById("Ename").value;
    if (password === "1234" && username === "Ishika") {
        window.location.href = "employee-page.html";
    } else {
        if (password === undefined || password === "") {
            alert("Please Enter the Password");
        } else {
            if (username === undefined || username === "") {
                alert("Please Enter the Username");
            } else {
                alert("Invalid credentials. Please try again.");
            }
        }
    }
});

document.getElementById("Csubmit").addEventListener("submit", (e) => {
    e.preventDefault();
    let password = document.getElementById("Cpassword").value;
    let username = document.getElementById("Cname").value;
    if (password === "1234" && username === "Ishika") {
        window.location.href = "customer-page.html";
    } else {
        if (password === undefined || password === "") {
            alert("Please Enter the Password");
        } else {
            if (username === undefined || username === "") {
                alert("Please Enter the Username");
            } else {
                alert("Invalid credentials. Please try again.");
            }
        }

    }
});