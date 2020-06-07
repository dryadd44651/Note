import React, {useState, useEffect} from 'react';

const Numbers = () =>{
    const [num,setNum] = useState(['1','2','3']);
    const add =()=>{
        setNum([...num,'4'])
    }
    useEffect(()=>{
        console.log('trigger');
    },[num])
    return (
        <div>
            <h1>Numbers</h1>
            {num.map(n=>{
                return <h4 key={n}>{n}</h4>
            })}
            <button onClick = {add}>add</button>
        </div>
        
    )

}

export default Numbers;