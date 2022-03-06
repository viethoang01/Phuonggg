function detailing() {
    document.getElementById('detailing-content').style.display = 'block';
    document.getElementById('process-content').style.display = 'none';
    document.getElementById('detailing').style.borderBottom = '2px solid #2C72C6';
    document.getElementById('detailing').style.color = '#2C72C6';
    document.getElementById('process').style.borderBottom = '1px solid gray';
    document.getElementById('process').style.color = 'gray';
}
function process() {
    document.getElementById('process-content').style.display = 'block';
    document.getElementById('detailing-content').style.display = 'none';
    document.getElementById('process').style.borderBottom = '2px solid #2C72C6';
    document.getElementById('process').style.color = '#2C72C6';
    document.getElementById('detailing').style.borderBottom = '1px solid gray';
    document.getElementById('detailing').style.color = 'gray';
}
function dichvu_enter() {
    document.getElementById('dichvu_content').style.width = "100%";

}
function dichvu_leave() {
    document.getElementById('dichvu_content').style.width = "0";

}
function submit() {
    var pass = document.getElementById('pass').value;
    var repass = document.getElementById('repass').value;
    alert("pass");
    if (pass !== (repass)) {
        alert('hello');
        document.getElementById('repass').style.borderBottom = '1px solid red';
    }
}




const form = document.querySelector("form");
eField = form.querySelector(".email"),
        eInput = eField.querySelector("input"),
        pField = form.querySelector(".password"),
        pInput = pField.querySelector("input");
form.onsubmit = (e) => {
    e.preventDefault(); //preventing from form submitting
    //if email and password is blank then add shake class in it else call specified function
    (eInput.value == "") ? eField.classList.add("shake", "error") : checkEmail();
    (pInput.value == "") ? pField.classList.add("shake", "error") : checkPass();
    setTimeout(() => { //remove shake class after 500ms
        eField.classList.remove("shake");
        pField.classList.remove("shake");
    }, 500);
    eInput.onkeyup = () => {
        checkEmail();
    } //calling checkEmail function on email input keyup
    pInput.onkeyup = () => {
        checkPass();
    } //calling checkPassword function on pass input keyup
    function checkEmail() { //checkEmail function
        let pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/; //pattern for validate email
        if (!eInput.value.match(pattern)) { //if pattern not matched then add error and remove valid class
            eField.classList.add("error");
            eField.classList.remove("valid");
            let errorTxt = eField.querySelector(".error-txt");
            //if email value is not empty then show please enter valid email else show Email can't be blank
            (eInput.value != "") ? errorTxt.innerText = "Enter a valid email address" : errorTxt.innerText = "Email can't be blank";
        } else { //if pattern matched then remove error and add valid class
            eField.classList.remove("error");
            eField.classList.add("valid");
        }
    }
    function checkPass() { //checkPass function
        if (pInput.value == "") { //if pass is empty then add error and remove valid class
            pField.classList.add("error");
            pField.classList.remove("valid");
        } else { //if pass is empty then remove error and add valid class
            pField.classList.remove("error");
            pField.classList.add("valid");
        }
    }
    //if eField and pField doesn't contains error class that mean user filled details properly
    if (!eField.classList.contains("error") && !pField.classList.contains("error")) {
        window.location.href = form.getAttribute("action"); //redirecting user to the specified url which is inside action attribute of form tag
    }
}


var slideIndex = [1, 1];
var slideId = ["mySlides1", "mySlides2"]
showSlides(1, 0);
showSlides(1, 1);

function plusSlides(n, no) {
    showSlides(slideIndex[no] += n, no);
}

function showSlides(n, no) {
    var i;
    var x = document.getElementsByClassName(slideId[no]);
    if (n > x.length) {
        slideIndex[no] = 1;
    }
    if (n < 1) {
        slideIndex[no] = x.length;
    }
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    x[slideIndex[no] - 1].style.display = "block";
}

function enterNumber() {
    var input = document.getElementById('enterNumber').value;
    if (isNaN(input) || input.length > 11) {
        document.getElementById('enterNumber').value = input.substring(input.length-1,0);
    } 
    
}
function  enterText(){
    var input = document.getElementById('enterText').value;
    var splitInput = Array.from(input);
    for (let i = 0; i < splitInput.length; i++) {
        if(!isNaN(splitInput[i]) && splitInput[i] !== ' '){
            document.getElementById('enterText').value = input.substring(splitInput.length-1,0);
        }
        var char = splitInput[i]+splitInput[i-1]
        if(char === "  "){
            document.getElementById('enterText').value = input.substring(splitInput.length-1,0);
        }
    }
    
}