import React from 'react';
//import 'bootstrap/dist/css/bootstrap.css';
import './search.css';
import {FormControl, Form, Popover, OverlayTrigger, Button, Row, Col, Dropdown} from 'react-bootstrap';
import Geo from './geo';
import {geolocated} from 'react-geolocated';
import Calendar from 'react-calendar'
import CustomToggle from './CustomToggle'


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
            longitude: "40.748425",
            latitude: "-73.984535",
            fromDate: new Date(),
            toDate: new Date(),
            isLocataionChecked: false,

        Suggestions: ["cool", "or not"] 

        }
        this.backpropQuery = this.backpropQuery.bind(this)

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
        //console.log(this.props.coords.longitude + " " + this.props.coords.latitude)
        //this.props.sendQuery(this.state);
        //this.setState({longitude: this.props.coords.longitude, latitude: this.props.coords.latitude}, function () {
        //    this.props.sendQuery(this.state);
        //});

    }
    backpropQuery(e) {
        alert("THE QUERY " + e)
        this.setState({query: e}, function() {
            this.props.sendQuery(this.state);
        })
        
    }

    updateCalendar = date => this.setState({fromDate: date})
    updateCalendar2 = date => this.setState({toDate: date})

    getQueryComplet(queryString) {
        //alert("vill hämta query!")
        fetch('Apply backend herer')
        .then(response => response.json())
        .then((res) => {

        })
    }

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
                <Dropdown>
                    <Dropdown.Toggle as={CustomToggle} fetch ={this.getQueryComplet} query ={this.backpropQuery}/>
                    <Dropdown.Menu>
                        <Dropdown.Item>haaaaaaj</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>

                <Row className="justify-content-md-center">

                    <Col>
                        <OverlayTrigger trigger="click" placement="auto" rootClose="true" overlay={<Popover>
                            <Form.Check id={22} type="checkbox" inline label="Suggest events like this"
                                        defaultChecked={this.state.isLocataionChecked}
                                        value={this.state.isLocataionChecked}
                                        onChange={(e) => {
                                            if (this.state.isLocataionChecked != true) {
                                                this.setState({isLocataionChecked: true})
                                            } else {
                                                this.setState({isLocataionChecked: false})
                                            }

                                        }}
                            />
                        </Popover>}>
                            <Button variant="link" className="btn-cat">Suggest events like this</Button>
                        </OverlayTrigger>
                    </Col>
                    <Col>
                        <OverlayTrigger trigger="click" placement="under" rootClose="true" overlay={<Popover>
                            <Form.Group controlId="formBasicChecbox">
                                <Form.Check id={1} type="checkbox" inline label="Music"
                                            defaultChecked={this.state.music}
                                            onChange={(e) => {
                                                if (this.state.music === "103") {
                                                    this.setState({music: ""})
                                                } else {
                                                    this.setState({music: "103"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={2} type="checkbox" inline
                                            label="Business & Professional"
                                            defaultChecked={this.state.businessAndProfessional}
                                            onChange={(e) => {
                                                if (this.state.businessAndProfessional === "101") {
                                                    this.setState({businessAndProfessional: ""})
                                                } else {
                                                    this.setState({businessAndProfessional: "103"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={3} type="checkbox"
                                            inline label="Food & Drink"
                                            defaultChecked={this.state.foodAndDrink}
                                            onChange={(e) => {
                                                if (this.state.foodAndDrink === "110") {
                                                    this.setState({foodAndDrink: ""})
                                                } else {
                                                    this.setState({foodAndDrink: "110"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={4} type="checkbox" inline
                                            label="Community & Culture"
                                            defaultChecked={this.state.communityAndCulture}
                                            onChange={(e) => {
                                                if (this.state.communityAndCulture === "113") {
                                                    this.setState({communityAndCulture: ""})
                                                } else {
                                                    this.setState({communityAndCulturek: "113"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={5} type="checkbox" inline
                                            label="Performing & Visual Arts"
                                            defaultChecked={this.state.performingAndVisualArts}
                                            onChange={(e) => {
                                                if (this.state.performingAndVisualArts === "105") {
                                                    this.setState({performingAndVisualArts: ""})
                                                } else {
                                                    this.setState({performingAndVisualArts: "105"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={6} type="checkbox" inline
                                            label="Film, Media & Entertainment"
                                            defaultChecked={this.state.filmAndMediaAndEntertainment}
                                            onChange={(e) => {
                                                if (this.state.filmAndMediaAndEntertainment === "104") {
                                                    this.setState({filmAndMediaAndEntertainment: ""})
                                                } else {
                                                    this.setState({filmAndMediaAndEntertainment: "104"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={7} type="checkbox" inline
                                            label="Sports & Fitness"
                                            defaultChecked={this.state.sportsAndFitness}
                                            onChange={(e) => {
                                                if (this.state.sportsAndFitness === "108") {
                                                    this.setState({sportsAndFitness: ""})
                                                } else {
                                                    this.setState({sportsAndFitness: "108"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={8} type="checkbox" inline
                                            label="Health & Wellness"
                                            defaultChecked={this.state.healthAndWellness}
                                            onChange={(e) => {
                                                if (this.state.healthAndWellness === "107") {
                                                    this.setState({healthAndWellness: ""})
                                                } else {
                                                    this.setState({healthAndWellness: "107"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={9} type="checkbox" inline
                                            label="Science & Technology"
                                            defaultChecked={this.state.scienceAndTechnology}
                                            onChange={(e) => {
                                                if (this.state.scienceAndTechnology === "102") {
                                                    this.setState({scienceAndTechnology: ""})
                                                } else {
                                                    this.setState({scienceAndTechnology: "102"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={10} type="checkbox" inline
                                            label="Travel & Outdoor"
                                            defaultChecked={this.state.travelAndOutdoor}
                                            onChange={(e) => {
                                                if (this.state.travelAndOutdoor === "109") {
                                                    this.setState({travelAndOutdoor: ""})
                                                } else {
                                                    this.setState({travelAndOutdoor: "109"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={11} type="checkbox" inline
                                            label="Charity & Causes"
                                            defaultChecked={this.state.charityAndCauses}
                                            onChange={(e) => {
                                                if (this.state.charityAndCauses === "111") {
                                                    this.setState({charityAndCauses: ""})
                                                } else {
                                                    this.setState({charityAndCauses: "111"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={12} type="checkbox" inline
                                            label="Religion & Spirituality"
                                            defaultChecked={this.state.religionAndSpirituality}
                                            onChange={(e) => {
                                                if (this.state.religionAndSpirituality === "114") {
                                                    this.setState({religionAndSpirituality: ""})
                                                } else {
                                                    this.setState({religionAndSpirituality: "114"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={13} type="checkbox" inline
                                            label="Family & Education"
                                            defaultChecked={this.state.familyAndEducation}
                                            onChange={(e) => {
                                                if (this.state.familyAndEducation === "115") {
                                                    this.setState({familyAndEducation: ""})
                                                } else {
                                                    this.setState({familyAndEducation: "115"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={14} type="checkbox" inline
                                            label="Seasonal & Holiday"
                                            defaultChecked={this.state.seasonalAndHoliday}
                                            onChange={(e) => {
                                                if (this.state.seasonalAndHoliday === "116") {
                                                    this.setState({seasonalAndHoliday: ""})
                                                } else {
                                                    this.setState({seasonalAndHoliday: "116"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={15} type="checkbox" inline
                                            label="Government & Politics"
                                            defaultChecked={this.state.governmentAndPolitics}
                                            onChange={(e) => {
                                                if (this.state.governmentAndPolitics === "112") {
                                                    this.setState({governmentAndPolitics: ""})
                                                } else {
                                                    this.setState({governmentAndPolitics: "112"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={16} type="checkbox" inline
                                            label="Fashion & Beauty"
                                            defaultChecked={this.state.fashionAndBeauty}
                                            onChange={(e) => {
                                                if (this.state.fashionAndBeauty === "106") {
                                                    this.setState({fashionAndBeauty: ""})
                                                } else {
                                                    this.setState({fashionAndBeauty: "106"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={17} type="checkbox" inline
                                            label="Home & Lifestyle"
                                            defaultChecked={this.state.homeAndLifestyle}
                                            onChange={(e) => {
                                                if (this.state.homeAndLifestyle === "117") {
                                                    this.setState({homeAndLifestyle: ""})
                                                } else {
                                                    this.setState({homeAndLifestyle: "117"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={18} type="checkbox" inline
                                            label="Auto, Boat & Air"
                                            defaultChecked={this.state.autoAndBoatAndAir}
                                            onChange={(e) => {
                                                if (this.state.autoAndBoatAndAir === "118") {
                                                    this.setState({autoAndBoatAndAir: ""})
                                                } else {
                                                    this.setState({autoAndBoatAndAir: "118"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={19} type="checkbox" inline
                                            label="Hobbies & Special Interest"
                                            defaultChecked={this.state.hobbiesAndSpecialAndInterest}
                                            onChange={(e) => {
                                                if (this.state.hobbiesAndSpecialAndInterest === "119") {
                                                    this.setState({hobbiesAndSpecialAndInterest: ""})
                                                } else {
                                                    this.setState({hobbiesAndSpecialAndInterest: "119"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={20} type="checkbox" inline label="Other"
                                            defaultChecked={this.state.other}
                                            onChange={(e) => {
                                                if (this.state.other === "199") {
                                                    this.setState({other: ""})
                                                } else {
                                                    this.setState({other: "199"})
                                                }

                                            }
                                            }/>
                                <Form.Check id={21} type="checkbox" inline
                                            label="School Activities"
                                            defaultChecked={this.state.schoolActivities}
                                            onChange={(e) => {
                                                if (this.state.schoolActivities === "120") {
                                                    this.setState({schoolActivities: ""})
                                                } else {
                                                    this.setState({schoolActivities: "120"})
                                                }

                                            }
                                            }/>

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

