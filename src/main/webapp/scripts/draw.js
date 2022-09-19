var canvas=document.getElementById('canv');
var ctx=canvas.getContext('2d');
function draw()
{
    for (let x = 50;x<=350;x+=50) {
        ctx.moveTo(x, 0);
        ctx.lineTo(x, 400);
    }
    for (let y = 50;y<=350;y+=50) {
        ctx.moveTo(0, y);
        ctx.lineTo(400, y);
    }
    ctx.strokeStyle = "#333";
    ctx.stroke();

}

function clearCanv() {
    ctx.clearRect(0,0,canvas.width,canvas.height);
}

function drawGraph(r) {
    clearCanv();
    ctx.fillStyle = 'rgb(35, 184, 253)';

    //rectangle
    ctx.rect(200, 200, r * 50, r * 50);
    ctx.fill();
    //ctx.fillRect(200, 200, r * 50, r * 50);

    //circle
    ctx.moveTo(200, 200);
    ctx.arc(200, 200, r * 50, Math.PI/2, Math.PI);
    ctx.fill();

    //triangle
    ctx.moveTo(200, 200);
    ctx.lineTo(200, 200-r*25);
    ctx.lineTo(200+r*50, 200);
    ctx.fill();

    draw();
    ctx.beginPath();

}
