import React from 'react';
//import 'bootstrap/dist/css/bootstrap.css';
import './search.css';
import {FormControl, Form, Popover,OverlayTrigger, Button, Row, Col} from 'react-bootstrap';
import Geo from './geo';
import {geolocated} from 'react-geolocated';
import Calendar from 'react-calendar'


class SearchField extends React.Component {
	constructor(props){
		super(props)
		this.state = {
			query: "",
			"103": true,
			"101": true,
			"113": true,
			"105": true,
			"104": true,
			"108": true,
			"107": true,
			"102": true,
			"109": true,
			"111": true,
			"114": true,
			"115": true,
			"116": true,
			"112": true,
			"106": true,
			"118": true,
			"119": true,
			"199": true,
			"120": true,
			long: null,
			lat: null,
			fromDate: new Date(),
			toDate: new Date(),
		}	

	}

	handleKeyPress(target) {
		if(target.charCode==13){
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
			console.log("Here is location " + this.props.coords.longitude + " " + this.props.coords.latitude);
		}
	    //alert(this.state.long)
	    this.props.sendQuery(this.state);
  	}

  	updateCalendar = date => this.setState({ fromDate: date })
  	updateCalendar2 = date => this.setState({ toDate: date })
  	
  	componentDidMount() {
  		this.input.focus()
  	}


	render(){
		return(

			<Form className ="searchField" onSubmit = {(e) =>{
					this.onClickPreventDefault(e);
				}}>
				<Form.Group >
					<Form.Control ref = {(e) => {this.input = e	}}type="text" placeholder="What event are you looking for?"  onChange= {(e)=> {this.setState({query: e.target.value})}}/>
				</Form.Group>

				<Row className="justify-content-md-center">
				<Col>
				  	<OverlayTrigger trigger="click" placement="auto" rootClose = "true" overlay={	
				  		<Popover >
				  			<Calendar onClickDay={this.updateCalendar} value={this.state.fromDate}/>
						</Popover>}>
    					<Button variant="link" className ="btn-cat">From date : {this.state.fromDate.toLocaleDateString()}</Button>
  					</OverlayTrigger>
  				</Col>
  				<Col>
				  <OverlayTrigger trigger="click" placement="auto"  rootClose = "true" overlay={				<Popover >
				  	<Calendar onClickDay={this.updateCalendar2} value={this.state.toDate}/>
				</Popover>}>
    				<Button variant="link" className ="btn-cat">To date : {this.state.toDate.toLocaleDateString()}</Button>
  					</OverlayTrigger>	
  				</Col>
  				<Col>			
				  <OverlayTrigger trigger="click" placement="under" rootClose = "true" overlay={				<Popover >
					<Form.Group controlId="formBasicChecbox">
	    				<Form.Check id= {1} defaultChecked = "true" type="checkbox" inline label="Music" onChange = {(e) => {this.setState({"103": e.target.checked})}}/>
	    				<Form.Check id= {2} defaultChecked = "true" type="checkbox" inline label="Business & Professional" onChange = {(e) => {this.setState({"101": e.target.checked})}}/>
	    				<Form.Check id= {3} defaultChecked = "true" type="checkbox" inline label="Food & Drink" onChange = {(e) => {this.setState({"110": e.target.checked})}}/> 
	    				<Form.Check id= {4} defaultChecked = "true" type="checkbox" inline label="Community & Culture" onChange = {(e) => {this.setState({"113": e.target.checked})}}/>
	    				<Form.Check id= {5} defaultChecked = "true" type="checkbox" inline label="Performing & Visual Arts" onChange = {(e) => {this.setState({"105": e.target.checked})}} />
	    				<Form.Check id= {6} defaultChecked = "true" type="checkbox" inline label="Film, Media & Entertainment" onChange = {(e) => {this.setState({"104": e.target.checked})}}/> 
	    				<Form.Check id= {7} defaultChecked = "true" type="checkbox" inline label="Sports & Fitness" onChange = {(e) => {this.setState({"108": e.target.checked})}} />
	    				<Form.Check id= {8} defaultChecked = "true" type="checkbox" inline label="Health & Wellness" onChange = {(e) => {this.setState({"107": e.target.checked})}}/>
	    				<Form.Check id= {9} defaultChecked = "true" type="checkbox" inline label="Science & Technology" onChange = {(e) => {this.setState({"102": e.target.checked})}}/> 
	    				<Form.Check id= {10} defaultChecked = "true" type="checkbox" inline label="Travel & Outdoor" onChange = {(e) => {this.setState({"109": e.target.checked})}}/>
	    				<Form.Check id= {11} defaultChecked = "true" type="checkbox" inline label="Charity & Causes" onChange = {(e) => {this.setState({"111": e.target.checked})}}/>
	    				<Form.Check id= {12} defaultChecked = "true" type="checkbox" inline label="Religion & Spirituality" onChange = {(e) => {this.setState({"114": e.target.checked})}}/> 
	    				<Form.Check id= {13} defaultChecked = "true" type="checkbox" inline label="Family & Education" onChange = {(e) => {this.setState({"115": e.target.checked})}}/>
	    				<Form.Check id= {14} defaultChecked = "true" type="checkbox" inline label="Seasonal & Holiday" onChange = {(e) => {this.setState({"116": e.target.checked})}}/>
	    				<Form.Check id= {15} defaultChecked = "true" type="checkbox" inline label="Government & Politics" onChange = {(e) => {this.setState({"112": e.target.checked})}}/> 
	    				<Form.Check id= {16} defaultChecked = "true" type="checkbox" inline label="Fashion & Beauty" onChange = {(e) => {this.setState({"106": e.target.checked})}}/>
	    				<Form.Check id= {17} defaultChecked = "true" type="checkbox" inline label="Home & Lifestyle" onChange = {(e) => {this.setState({"117": e.target.checked})}}/>
	    				<Form.Check id= {18} defaultChecked = "true" type="checkbox" inline label="Auto, Boat & Air" onChange = {(e) => {this.setState({"118": e.target.checked})}}/> 
	    				<Form.Check id= {19} defaultChecked = "true" type="checkbox" inline label="Hobbies & Special Interest" onChange = {(e) => {this.setState({"119": e.target.checked})}}/>
	    				<Form.Check id= {20} defaultChecked = "true" type="checkbox" inline label="Other" onChange = {(e) => {this.setState({"199": e.target.checked})}}/>
	    				<Form.Check id= {21} defaultChecked = "true" type="checkbox" inline label="School Activities "onChange = {(e) => {this.setState({"120": e.target.checked})}} /> 

	  				</Form.Group>
				</Popover>}>
    				<Button variant="link" className ="btn-cat">Choose categories</Button>
  					</OverlayTrigger>
  				</Col>
  				</Row>



			</Form>
/*			<div>
				<div>
					<h1> JÄVLAR VAD MYCKET FIELDS DETTA ÄR </h1>
					
				</div>
				<div class = "form-group">
					<Form>
						<Form.Group>
						<Form.Control type="text" placeholder = "Type your search phrase here"/>
						<input type = "text" class = "form-control" placeholder = "Type your search phrase here"/>
						</Form.Group>
					</Form>
				</div>
				<div>
					<p>
					<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
    					Button with data-target
  					</button>
  					</p>
  					<div class="collapse" id="collapseExample">
 						<div class="card card-body">
    						Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
  						</div>
					</div>
				</div>


			</div>
*/
			)
	}
}

export default geolocated({
  positionOptions: {
    enableHighAccuracy: false,
  },
  userDecisionTimeout: 5000,
})(SearchField);

