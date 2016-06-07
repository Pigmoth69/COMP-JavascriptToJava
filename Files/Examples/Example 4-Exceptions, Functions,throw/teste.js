try {
    myroutine(); // may throw three types of exceptions
} catch (e if e instanceof TypeError) {
    // statements to handle TypeError exceptions
    console.log("TypeError");
} catch (e if e instanceof RangeError) {
    // statements to handle RangeError exceptions
    console.log("RangeError");
} catch (e if e instanceof EvalError) {
    // statements to handle EvalError exceptions
    console.log("EvalError");
} catch (e) {
    // statements to handle any unspecified exceptions
    throw new logMyErrors(e); // pass exception object to error handler
}

function myroutine(){
    console.log("myroutine");
    var y = 2;
}
function logMyErrors(e){
    console.log("e");
}