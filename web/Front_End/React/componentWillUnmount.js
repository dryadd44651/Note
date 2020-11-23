class Show extends React.Component {
    //when Show not longer render
    componentWillUnmount() {
    alert('leave');
  }
  render() {
    return <h2>It is {this.props.count}.</h2>
  }
}

class Clock extends React.Component {
  constructor(props) {
    super(props);
    this.state = {count: 1
                 };
  }

  componentDidMount() {
    this.timerID = setInterval(
      () => this.tick(),
      1000
    );
  }

  componentWillUnmount() {
    clearInterval(this.timerID);
  }

  tick() {
    this.setState({
      count:this.state.count+1
    });
  }

  render() {
    let message;
    if(this.state.count<10)
      message = <Show count={this.state.count}/>
    else
      <p>nothing</p>
    return (
      <div>
        <h1>Hello, world!</h1>
        {message}
        <h2>It is {this.state.count}.</h2>
      </div>
    );
  }
}

ReactDOM.render(
  <Clock />,
  document.getElementById('root')
);
