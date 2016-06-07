public final class JS2Java {
    public static void main(String[] args) {
    }

    public static void startMandelbulb() {
        String mandelbulbCanvas = document.getElementById('mandelbulb');
        cHeight = mandelbulbCanvas.height;
        cWidth = mandelbulbCanvas.width;
        context = mandelbulbCanvas.getContext("2d");
        context.fillRect(0, 0, cWidth, cHeight);
        pixel = (DEPTH_OF_FIELD) / ((cHeight + cWidth) / 2);
        halfPixel = pixel / 2;
        image = context.getImageData(0, 0, cWidth, cHeight);
        imageData = image.data;
        animate();
    }
}
