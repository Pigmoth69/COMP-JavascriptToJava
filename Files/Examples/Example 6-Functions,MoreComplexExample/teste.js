function startMandelbulb(x) {

    var mandelbulbCanvas = document.getElementById('mandelbulb');
    cHeight = mandelbulbCanvas.height;
    cWidth = mandelbulbCanvas.width;

    context = mandelbulbCanvas.getContext("2d");
    context.fillRect(0, 0, cWidth, cHeight);


    pixel = (DEPTH_OF_FIELD)/((cHeight+cWidth)/2);
    halfPixel = pixel/2;

    image = context.getImageData(0, 0, cWidth, cHeight);
    imageData = image.data;
    x = x+ pixel;
    animate();
    return x;
}

var iterations = 0;
function rFact(num) {
    iterations++;
    if (num == 0) {
        return 1;
    } else {
        return num * rFact( num - 1 );
    }
}
​startMandelbulb();
console.log(num + "!: "+rFact(5));
console.log("Iterations: " + iterations);