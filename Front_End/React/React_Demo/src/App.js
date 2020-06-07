import React from 'react';
import './App.css';
import H from './com/header';
import F from './com/footer';
import Number from './numbers';
import styled from 'styled-components'


function aalert(){
  alert('hi app')
}
const pStyle ={
  fontSize: '2em',
  color: 'red'
}


const Paragraph = styled.p`
  font-size: 3em;
  color: green;
`;


function App() {
  return (
    
      <div className = 'App'>
        <H info="test prob" halert={aalert}/>
        <p style={pStyle}>main content</p>
        <Paragraph>new tag</Paragraph>
        <Number />
        <F halert={aalert}/>
      </div>
  );
}

export default App;
