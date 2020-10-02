// BUBBLE
// document.querySelector('.box-1').addEventListener(
//     'click',
//     e => {
//         setTimeout(() => {
//             document.querySelector('.box-1 > p').textContent = 'Clicked';
//             console.log('Box-1 is clicked');
//         }, 1000);
//     },
//     
// );

// document.querySelector('.box-2').addEventListener(
//     'click',
//     e => {
//         setTimeout(() => {
//             document.querySelector('.box-2 > p').textContent = 'Clicked';
//             console.log('Box-2 is clicked');
//         }, 1000);
//     },
//     
// );

// document.querySelector('.box-3').addEventListener(
//     'click',
//     e => {
//         setTimeout(() => {
//             document.querySelector('.box-3 > p').textContent = 'Clicked';
//             console.log('Box-3 is clicked');
//         }, 1000);
//     },
//     
// );
// CAPTURE 
document.querySelector('.box-1').addEventListener(
    'click',
    e => {
        setTimeout(() => {
            document.querySelector('.box-1 > p').textContent = 'Clicked';
            console.log('Box-1 is clicked');
        }, 1000);
    },
    true
);

document.querySelector('.box-2').addEventListener(
    'click',
    e => {
        setTimeout(() => {
            document.querySelector('.box-2 > p').textContent = 'Clicked';
            console.log('Box-2 is clicked');
        }, 1000);
    },
    true
);

document.querySelector('.box-3').addEventListener(
    'click',
    e => {
        setTimeout(() => {
            document.querySelector('.box-3 > p').textContent = 'Clicked';
            console.log('Box-3 is clicked');
        }, 1000);
    },
    true
);
//bubbling: inner->outer
//capture: outer->inner
//"Box-1 is clicked"
//"Box-2 is clicked"
//"Box-3 is clicked"
