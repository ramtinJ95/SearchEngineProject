import React from 'react';
//import 'bootstrap/dist/css/bootstrap.css';
import './search.css';
import {FormControl, Form, Popover, OverlayTrigger, Button, Row, Col} from 'react-bootstrap';
import Geo from './geo';
import {geolocated} from 'react-geolocated';
import Calendar from 'react-calendar'


class SearchField extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            query: "",
            music: "",
            businessAndProfessional: "",
            foodAndDrink: "",
            communityAndCulture: "",
            performingAndVisualArts: "",
            filmAndMediaAndEntertainment: "",
            sportsAndFitness: "",
            healthAndWellness: "",
            scienceAndTechnology: "",
            travelAndOutdoor: "",
            charityAndCauses: "",
            religionAndSpirituality: "",
            familyAndEducation: "",
            seasonalAndHoliday: "",
            governmentAndPolitics: "",
            fashionAndBeauty: "",
            homeAndLifestyle: "",
            autoAndBoatAndAir: "",
            hobbiesAndSpecialAndInterest: "",
            other: "",
            schoolActivities: "",
            long: null,
            lat: null,
            fromDate: new Date(),
            toDate: new Date(),
            isLocataionChecked: false
        }

    }

    handleKeyPress(target) {
        if (target.charCode == 13) {
            alert(target.target.value);
            //alert(this.state.query);
        }
    }

    onClickPreventDefault(e) {
        //alert('onClickPreventDefault called, form will not submit');
        e.preventDefault();
        //alert(e.target.value)
        if (this.props.coords.longitude != null && this.props.coords.latitude != null) {
            this.setState({long: this.props.coords.longitude, lat: this.props.coords.latitude});
        }

        this.props.sendQuery(this.state);
    }

    updateCalendar = date => this.setState({fromDate: date})
    updateCalendar2 = date => this.setState({toDate: date})

    componentDidMount() {
        this.input.focus()
    }


    render() {
        return (

            <Form className="searchField" onSubmit={(e) => {
                this.onClickPreventDefault(e);
            }}>
                <Form.Group>
                    <Form.Control ref={(e) => {
                        this.input = e
                    }} type="text" placeholder="What event are you looking for?" onChange={(e) => {
                        this.setState({query: e.target.value})
                    }}/>
                </Form.Group>

                <Row className="justify-content-md-center">
                    <Col>
                        <OverlayTrigger trigger="click" placement="auto" rootClose="true" overlay={
                            <Popover>
                                <Calendar onClickDay={this.updateCalendar} value={this.state.fromDate}/>
                            </Popover>}>
                            <Button variant="link" className="btn-cat">From date
                                : {this.state.fromDate.toLocaleDateString()}</Button>
                        </OverlayTrigger>
                    </Col>
                    <Col>
                        <OverlayTrigger trigger="click" placement="auto" rootClose="true" overlay={<Popover>
                            <Calendar onClickDay={this.updateCalendar2} value={this.state.toDate}/>
                        </Popover>}>
                            <Button variant="link" className="btn-cat">To date
                                : {this.state.toDate.toLocaleDateString()}</Button>
                        </OverlayTrigger>
                    </Col>
                    <Col>
                        <OverlayTrigger trigger="click" placement="auto" rootClose="true" overlay={<Popover>
                            <Form.Check id={22} type="checkbox" inline label="Search Nearby Events"
                                        value={this.state.isLocataionChecked}
                                   onChange={(e) => {
                                       this.setState({isLocataionChecked: e.target.value})
                                   }}
                            />
                        </Popover>}>
                            <Button variant="link" className="btn-cat">Search Nearby Events</Button>
                        </OverlayTrigger>
                    </Col>
                    <Col>
                        <OverlayTrigger trigger="click" placement="under" rootClose="true" overlay={<Popover>
                            <Form.Group controlId="formBasicChecbox">
                                <Form.Check id={1} type="checkbox" inline label="Music"
                                            onChange={(e) => {
                                                this.setState({music: "103"})
                                            }}/>
                                <Form.Check id={2}  type="checkbox" inline
                                            label="Business & Professional" onChange={(e) => {
                                    this.setState({businessAndProfessional: "101"})
                                }}/>
                                <Form.Check id={3}  type="checkbox" inline label="Food & Drink"
                                            onChange={(e) => {
                                                this.setState({foodAndDrink: "110"})
                                            }}/>
                                <Form.Check id={4}  type="checkbox" inline
                                            label="Community & Culture" onChange={(e) => {
                                    this.setState({communityAndCulture: "113"})
                                }}/>
                                <Form.Check id={5}  type="checkbox" inline
                                            label="Performing & Visual Arts" onChange={(e) => {
                                    this.setState({performingAndVisualArts: "105"})
                                }}/>
                                <Form.Check id={6}  type="checkbox" inline
                                            label="Film, Media & Entertainment" onChange={(e) => {
                                    this.setState({filmAndMediaAndEntertainment: "104"})
                                }}/>
                                <Form.Check id={7}  type="checkbox" inline
                                            label="Sports & Fitness"
                                            onChange={(e) => {
                                                this.setState({sportsAndFitness: "108"})
                                            }}/>
                                <Form.Check id={8}  type="checkbox" inline
                                            label="Health & Wellness" onChange={(e) => {
                                    this.setState({healthAndWellness: "107"})
                                }}/>
                                <Form.Check id={9}  type="checkbox" inline
                                            label="Science & Technology" onChange={(e) => {
                                    this.setState({scienceAndTechnology: "102"})
                                }}/>
                                <Form.Check id={10}  type="checkbox" inline
                                            label="Travel & Outdoor" onChange={(e) => {
                                    this.setState({travelAndOutdoor: "109"})
                                }}/>
                                <Form.Check id={11}  type="checkbox" inline
                                            label="Charity & Causes" onChange={(e) => {
                                    this.setState({charityAndCauses: "111"})
                                }}/>
                                <Form.Check id={12}  type="checkbox" inline
                                            label="Religion & Spirituality" onChange={(e) => {
                                    this.setState({religionAndSpirituality: "114"})
                                }}/>
                                <Form.Check id={13}  type="checkbox" inline
                                            label="Family & Education" onChange={(e) => {
                                    this.setState({familyAndEducation: "115"})
                                }}/>
                                <Form.Check id={14}  type="checkbox" inline
                                            label="Seasonal & Holiday" onChange={(e) => {
                                    this.setState({seasonalAndHoliday: "116"})
                                }}/>
                                <Form.Check id={15}  type="checkbox" inline
                                            label="Government & Politics" onChange={(e) => {
                                    this.setState({governmentAndPolitics: "112"})
                                }}/>
                                <Form.Check id={16}  type="checkbox" inline
                                            label="Fashion & Beauty" onChange={(e) => {
                                    this.setState({fashionAndBeauty: "106"})
                                }}/>
                                <Form.Check id={17}  type="checkbox" inline
                                            label="Home & Lifestyle" onChange={(e) => {
                                    this.setState({homeAndLifestyle: "117"})
                                }}/>
                                <Form.Check id={18}  type="checkbox" inline
                                            label="Auto, Boat & Air" onChange={(e) => {
                                    this.setState({autoAndBoatAndAir: "118"})
                                }}/>
                                <Form.Check id={19}  type="checkbox" inline
                                            label="Hobbies & Special Interest" onChange={(e) => {
                                    this.setState({hobbiesAndSpecialAndInterest: "119"})
                                }}/>
                                <Form.Check id={20}  type="checkbox" inline label="Other"
                                            onChange={(e) => {
                                                this.setState({other: "199"})
                                            }}/>
                                <Form.Check id={21}  type="checkbox" inline
                                            label="School Activities" onChange={(e) => {
                                    this.setState({schoolActivities: "120"})
                                }}/>

                            </Form.Group>
                        </Popover>}>
                            <Button variant="link" className="btn-cat">Choose categories</Button>
                        </OverlayTrigger>
                    </Col>
                </Row>
            </Form>
        )
    }
}

export default geolocated({
    positionOptions: {
        enableHighAccuracy: false,
    },
    userDecisionTimeout: 5000,
})(SearchField);

