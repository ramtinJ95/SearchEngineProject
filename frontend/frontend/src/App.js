import React from 'react';
import ReactDOM from 'react-dom';
import logo from './EventFinderLogo.png';
import './App.css';
import SearchFiled from './search';
import EvenetField from './event';
import 'bootstrap/dist/css/bootstrap.css';
import {ListGroup, Button, Container,Col, Row, Popover} from 'react-bootstrap';
import {geolocated} from 'react-geolocated';


class App extends React.Component{
    constructor(props, context){
    super(props,context);

    this.state = {
        haveSearched: false,
        result: null,
        latest: null
      }
    this.changeState = this.changeState.bind(this);
    this.greetParent = this.greetParent.bind(this);
    this.changeModal = this.changeModal.bind(this);
    this.sendQuery = this.sendQuery.bind(this);
    this.findEvent = this.findEvent.bind(this);
    this.sendHistory = this.sendHistory.bind(this);


  }

    changeState(e) {
        if(this.state.latest != null){
            console.log("Latest = "+this.state.latest + " id= " + e)
            //HÄR SKICKAAR VI updatend till om från till

        }
        this.setState({latest: e});
        alert(this.state.latest);
    }

    greetParent() {
        alert(`Hella ${this.state.latest}`)
    }

    sendQuery (query){
        
        let term = 'http://130.229.172.166:8080/documents/search/'+query.query
        fetch('http://130.229.172.166:8080/documents/search/stockholm',{
          method: "GET",
          mode: "cors",
          headers: {
            "Content-Type": "application/json",
          }
        })
        .then((response) => response.json())
        .then((res) => {
          alert("i fetch")
          //HÄR SPARAR VI NER INFON FRÅN BACKEND"
          this.setState({result: res.hits.hits})
          if(!this.state.haveSearched){
            this.setState({haveSearched: true})
        }
        }).catch((err) => alert(err))


    }

    sendHistory (id){
        alert("SEND")

    }

    findEvent(e) {
        console.log(e)
        console.log(this.state.result.length);
        for (var i = 0; i < this.state.result.length; i++) {
          console.log(this.state.result[i]._id)
          if(e === this.state.result[i]._id){
            return true
          }
        }
      }

  locateEvent () {
    this.event2.handleShow();
  }

  changeModal (e) {
    if(this.findEvent(e)){
      this[`event${e}`].handleShow();
    }
    
  }

  render() {
      if(this.state.haveSearched){
        return(
          <div>
            <div className="header">
              <Col>
                <img src={logo} className="logo" alt="logo" />
              </Col>
              <Col >
                <div className = "searchf">
                  <SearchFiled sendQuery = {this.sendQuery} />
                </div>
              </Col>
              <Col >
              </Col>
            </div>
            <div>
                    <ListGroup as="ul">
          {this.state.result.map((d) => {
                    return (<EvenetField key = {d._id} id= {d._id} ref = {(e) => {
                      const nr = d.id;
                      this[`event${d._id}`] = e;
                    }} name = {d._source.eventName} summary = {d._source.summary}text = {d._source.text} greetHandler = {this.changeState} changeEvent = {this.changeModal}/>)
                  })}
        </ListGroup>
          </div>
          </div>

          )
      }else{
            return (

    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <SearchFiled sendQuery = {this.sendQuery}/>        
      </header>
    </div>
  );
      }

  }
}


export default App;

