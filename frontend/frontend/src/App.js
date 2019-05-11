import React from 'react';
import ReactDOM from 'react-dom';
import logo from './EventFinderLogo.png';
import './App.css';
import SearchFiled from './search';
import EvenetField from './event';
import 'bootstrap/dist/css/bootstrap.css';
import {ListGroup, Button, Container, Col, Row, Popover} from 'react-bootstrap';
import {geolocated} from 'react-geolocated';


class App extends React.Component {
    constructor(props, context) {
        super(props, context);

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
        if (this.state.latest != null) {
            console.log("Latest = " + this.state.latest + " id= " + e)
            //HÄR SKICKAAR VI updatend till om från till

        }
        this.setState({latest: e});
        alert(this.state.latest);
    }

    greetParent() {
        alert(`Hella ${this.state.latest}`)
    }

    sendQuery(query) {
        let term = 'http://localhost:8080/documents/search/'
        const input = {
            'query': query.query,
            'music': this.state.music,
            'businessAndProfessional': this.state.businessAndProfessional,
            'foodAndDrink': this.state.foodAndDrink,
            'communityAndCulture': this.state.communityAndCulture,
            'performingAndVisualArts': this.state.performingAndVisualArts,
            'filmAndMediaAndEntertainment': this.state.filmAndMediaAndEntertainment,
            'sportsAndFitness': this.state.sportsAndFitness,
            'healthAndWellness': this.state.healthAndWellness,
            'scienceAndTechnology': this.state.scienceAndTechnology,
            'travelAndOutdoor': this.state.travelAndOutdoor,
            'charityAndCauses': this.state.charityAndCauses,
            'religionAndSpirituality': this.state.religionAndSpirituality,
            'familyAndEducation': this.state.familyAndEducation,
            'seasonalAndHoliday': this.state.seasonalAndHoliday,
            'governmentAndPolitics': this.state.governmentAndPolitics,
            'fashionAndBeauty': this.state.fashionAndBeauty,
            'homeAndLifestyle': this.state.homeAndLifestyle,
            'autoAndBoatAndAir': this.state.autoAndBoatAndAir,
            'hobbiesAndSpecialAndInterest': this.state.hobbiesAndSpecialAndInterest,
            'other': this.state.other,
            'schoolActivities': this.state.schoolActivities,
            'longitude': this.state.long,
            'latitude': this.state.lat,
            'fromDate': this.state.fromDate,
            'toDate': this.state.toDate,
            'isLocataionChecked': this.state.isLocataionChecked
        }
        console.log(input)
        fetch(term, {
            method: "POST",
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(input)
        })
            .then((response) => response.json())
            .then((res) => {
                alert("i fetch")
                //HÄR SPARAR VI NER INFON FRÅN BACKEND"
                console.log(res);

                this.setState({result: res})
                if (!this.state.haveSearched) {
                    this.setState({haveSearched: true})
                }
            }).catch((err) => alert(err))


    }

    sendHistory(id) {
        alert("SEND")

    }

    findEvent(e) {
        console.log(e)
        console.log(this.state.result.length);
        for (var i = 0; i < this.state.result.length; i++) {
            console.log(this.state.result[i]._id)
            if (e === this.state.result[i]._id) {
                return true
            }
        }
    }

    locateEvent() {
        this.event2.handleShow();
    }

    changeModal(e) {
        if (this.findEvent(e)) {
            this[`event${e}`].handleShow();
        }

    }

    render() {
        if (this.state.haveSearched) {
            return (
                <div>
                    <div className="header">
                        <Col>
                            <img src={logo} className="logo" alt="logo"/>
                        </Col>
                        <Col>
                            <div className="searchf">
                                <SearchFiled sendQuery={this.sendQuery}/>
                            </div>
                        </Col>
                        <Col>
                        </Col>
                    </div>
                    <div>
                        <ListGroup as="ul">
                            {this.state.result.map((d) => {
                                return (<EvenetField key={d._id} id={d._id} ref={(e) => {
                                    const nr = d.id;
                                    this[`event${d._id}`] = e;
                                }} name={d.eventName} summary={d.summary} text={d.text} greetHandler={this.changeState}
                                                     changeEvent={this.changeModal}/>)
                            })}
                        </ListGroup>
                    </div>
                </div>

            )
        } else {
            return (
                <div className="App">
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo"/>
                        <SearchFiled sendQuery={this.sendQuery}/>
                    </header>
                </div>
            );
        }

    }
}


export default App;

