var cars = ["BMW", "Volvo", "Saab", "Ford"];
var i = 0;
var text = "";

while (cars[i]) {
    text += cars[i] + "<br>";
    i++;
}

var text2 = "";
var i2 = 0;
do {
    if(i.equals(i2)){
        console.log("it matches!")
    }
    text2 += "The number is " + i2;
    i2++;
}
while (i2 < 5);