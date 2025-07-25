function greeting() {
    alert("Hello Spring Developer!!");
}

function greet() {
    alert("Greetings Pravin");
}

function thing() {
    let str1
    str1 =  "A Full Stack Developer";
}

function myinput(){
    var name = prompt("Enter Your Name:");

    if (name == null || name === "") {
        document.getElementById("msg").innerHTML = "You did not enter anything. Please enter your name again";
    }
    else
    {
        document.getElementById("msg").innerHTML = "You entered: " + name;
    }
}




