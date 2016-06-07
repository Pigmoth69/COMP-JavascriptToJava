//Variables declaration as seen before
var a = 0, b = 2;
var i = 0;

//IfStatement
if (a > b) {
    a = a + 1;
} else {
    //InfixOperator
    b++;
}

//for cicle with declared var inside loop
for (var i = 0; i < 5; i++) {
    a = a + i;
}
//for cicle without var initialization
for (i = 0; i < 5; i++) {
    a = b + i;
}
//for cicle without initializator
for (; i < 5; i++) {
    b = a + i;
}
