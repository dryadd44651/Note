(function main() {
    //let: like the normal declared (block scope)
    //var: global declard (function scope)
    //const: like let, but can't be changed
    let b = 2;//global
    const e = 6;
    function test(){
        //console.log(a);//not defined
        console.log(b);
        console.log(c);
        //console.log(d);//not defined
        console.log(e);
        b = 0;
        c = 0;
        //e = 0;//error
    }
    {
        console.log('Hello World!');
        let a = 1;
        {
            var c = 3;
            var c = 3.5;//can replace
            let d = 4;
            //let d = 5;//error can't replace
            console.log(a);
        }
        console.log(c);
        //console.log(d); //error not defined
        test();    
    }
    
}());
