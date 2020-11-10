(function main() {
    //template literals
    let val = 5
    let a = 'a: '+val;
    let b = `b: ${val}`
    console.log(a);
    console.log(b);
    //obj constuct
    var c = 1,d=2
    let obj1={c,d}
    let obj2={c:1,d:2}
    console.log(obj1);
    console.log(obj2);
    //obj deconstuct
    var {c,d} = obj2
    console.log(c);
    console.log(d);
}());
