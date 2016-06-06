/*var a = 0, b = 2;

if (a > b) {
    a = a + 1;
} else {
    b++;
}

for (var i = 0; i < 5; i++) {
    a = a + i;
}*/

//var NUL = [a,2,3,4];
//console.log("olasas"+2);
//coisas = ["danoe",1,2,3]
//window.onload(call);
/*var i = 0;
while (i != "daniel") {
    console.log("The number is "+i);
    i++;
}*/

/*var i = 0;
do{
    text = "THe number is: "+i
    i++;
}while(i < 10)*/
/*
var x = 3;
switch (x) {
    case 6:
        text = "Today is Saturday";
        break;
    case 0:
        text = "Today is Sunday";
        x++;
        break;
    case 22:
        break;
    default:
        text = "Looking forward to the Weekend";
}*/
/*function crossProduct(v1, v2) {
    var oldX = v1[0];
    var oldY = v1[1];
    v1[0] = v2[1] * v1[2] - v2[2] * oldY;
    v1[1] = v2[2] * oldX - v2[0] * v1[2];
    v1[2] = v2[0] * oldY - v2[1] * oldX;
    return v1;
}*/


/*
    if (num === 0)
    { 1; }
    else
    {  num * rFact( num - 1 ); }
*/

//https://developer.mozilla.org/pt-PT/docs/Web/JavaScript/Reference/Statements/try...catch  --> TESTE IMPORTANTE!!
/*try {
    console.log("try");
}
catch(err) {
    console.log("catch");
}*/
/*try {
    try {
        //throw new Error("oops");
        console.log("try");
    }catch (e){
        console.log("cenas");
    }
}
catch (ex) {
    console.error("outer", ex.message);
}*/
/*
try {
    throw new Error();
}catch (e){
    console.log("cenas");
}*/
/*
try {
    myroutine(); // may throw three types of exceptions
} catch (e if e instanceof TypeError) {
    // statements to handle TypeError exceptions
} catch (e if e instanceof RangeError) {
    // statements to handle RangeError exceptions
} catch (e if e instanceof EvalError) {
    // statements to handle EvalError exceptions
} catch (e) {
    // statements to handle any unspecified exceptions
    logMyErrors(e); // pass exception object to error handler
}*/
try {
    myroutine(); // may throw three types of exceptions
} catch (e if e instanceof TypeError) {
    console.log("cenas");
} catch (e) {
    // statements to handle any unspecified exceptions
    logMyErrors(e); // pass exception object to error handler
}