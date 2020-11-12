//JavaScript is a synchronous, blocking, single-threaded language
(async function main() {
const sleep = m => new Promise(r => setTimeout(r, m))
    //async example
    async function abc()
    {
        //setTimeout(() => { console.log("World!"); }, 5);
        console.time("Slept for")
        await sleep(2)//sleep for 2ms
        console.timeEnd("Slept for")
        console.log('abc');
    }
    async function xyz()
    {
       await abc()
       console.log('xyz');
    }
    await console.log('async');
    await xyz();//async order: slept(2)->abc->xyz
    
    await console.log('=======================================');
    await console.log('sync');
    async function abc1()
    {
        setTimeout(() => { console.log("World!"); }, 5);
        console.time("Slept for")
        sleep(2)//no sleep
        console.timeEnd("Slept for")
        await sleep(2)
        console.log('abc');
    }
    function xyz1()
    {
       abc1()
       console.log('xyz');
    }
    await xyz1();//sync order: slept->xyz->abc(2ms)->World!(5ms)
}());

// async
// Slept for: 3.082ms
// abc
// xyz
// =======================================
// sync
// Slept for: 0.033ms
// xyz
// abc
// World!
