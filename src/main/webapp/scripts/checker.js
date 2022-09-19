let ifRadiusChosen=false;
let radius;
function checkForm(el) {
    let y = el.y.value;
    let x = el.x.value;
    if (checkX(x) & checkY(y) & checkR()) {
        el.y.value = y.replace(",",".");
        el.time.value = new Date().getTimezoneOffset();
        return true;
    }
    return false;

}

function printErr(text,id) {
    document.getElementById(id).innerHTML = text;
    document.getElementById(id).style.color='red';
}

function checkY(y) {
    y = y.replace(",",".");
    if (y == '') {
        printErr('Fill in the field','yError');
        return false;
    }else if (new RegExp(/^-?[0-2](\.[0-9]*)?$/).test(y)) {
        document.getElementById('yError').innerHTML = '';
        return true;
    }else {
        printErr('Incorrect value','yError');
        return false;
    }
}

function checkX(x) {
    if (x == '') {
        printErr('Fill in the field','xError');
        return false;
    }
    else {
        document.getElementById('xError').innerHTML = '';
        return true;
    }
}

function checkR() {
    const params = document.getElementsByClassName("param");
    let empty = true;
    for (let i = 0; i < params.length; i++) {
        if(params[i].checked) {
            empty = false;
            break;
        }
    }
    if (empty) {
        printErr('Fill in the field','rError');
        return false;
    }
    else {
        document.getElementById('rError').innerHTML = '';
        return true;
    }
}
function checkOnlyOne(b){

    const x = document.getElementsByClassName('param');
    for (let i = 0; i < x.length; i++) {
        if(x[i].value != b) x[i].checked = false;
    }
    let empty = true;
    for (let i = 0; i < x.length; i++) {
        if(x[i].checked) {
            empty = false;
            break;
        }
    }
    if (empty) {
        clearCanv();
        draw();
        ifRadiusChosen = false;
    }
    else {
        ifRadiusChosen=true;
        radius=b;
        drawGraph(b);
    }
}

function send(x,y) {
    if ((x>=-5 & x<=3) & (y>-3&y<3)) {
        let send = new XMLHttpRequest();
        send.open("GET", "/lab2-1.0-SNAPSHOT/?x=" + x + "&y=" + y + "&r=" + radius);
        send.send(null);
        setTimeout(function(){
            location.reload();
            // let table = document.getElementById("table1");
            // let tr = document.createElement("tr");
            // tr.innerHTML='<td>'+x+'</td><td>'+y+'</td><td>'+radius+'</td><td></td>'
            // table.appendChild(tr);
        }, 500);
    }

}

// function reestablish(r) {
//     alert("good");
//     const p = document.getElementsByClassName('param');
//     for (let i = 0; i < p.length; i++) {
//         if(p[i].value == r) {
//             p[i].checked = true;
//             break;
//         }
//     }
//     drawGraph(r);
// }

function getCursorPosition(canvas,event) {
    if (ifRadiusChosen) {
        let pos = canvas.getBoundingClientRect();
        let x = ((event.clientX - pos.left -200)/50).toFixed(2);
        let y = ((200 - (event.clientY - pos.top))/50).toFixed(2);
        send(x,y);
    }
    else {
        alert("Select radius");
    }
}

function addEventListenerToCanvas() {
    const canvas = document.querySelector('canvas');
    canvas.addEventListener("mousedown", function (e) {
        getCursorPosition(canvas,e);
    })
}

