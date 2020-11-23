import React, {Component} from 'react';
import {CtxConsumer} from '../index'
function falert(){
    alert('hi footer')
}

class Footer extends Component{
    
    state = {
        name: 'howard'

    }
    changed=(evt)=>{
        this.setState({name: evt.target.value});
        console.log(this.state.name);
        
    }
    render(){
        // const animals = ['snake','elephant'];
        return (
        <div>
            <CtxConsumer>
                {(context =>(
                    context.animals.map( animal =>{
                        return (
                        <div key={animal}>
                            <h1>{animal}</h1>
                        </div>
                        );
                    })
                ))}
                
            </CtxConsumer>
        
            <h2 onClick = {this.props.halert}> Footer</h2>
            <input onChange={this.changed} value={this.state.name} type="text"></input>
        </div>
        )
    }

}

export default Footer;