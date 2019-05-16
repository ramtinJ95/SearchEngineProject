import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import './event.css';
import {Modal, Button, ListGroup, Row, Col, Container} from 'react-bootstrap';

class EventInformaion extends React.Component {
	constructor(props, context) {
	    super(props, context);

	    this.handleShow = this.handleShow.bind(this);
	    this.handleClose = this.handleClose.bind(this);
	    this.redirectToEvent = this.redirectToEvent.bind(this);

	    this.state = {
	    	event: {
	    		name: this.props.name,
	    		text: this.props.text,
	    		summary: this.props.summary,
	    		id: this.props.id,
	    	},
	      	show: false,
	    	events: [{
	    		id: 2,
	    		name: "Cool event at nightclub"
	    	},{
	    		id:"1400c7c4-0273-44ed-8c23-cb547e915ba9",
	    		name: "Cultural event at museum"
	    	}]
	    };
	}
	handleClose() {
    	this.setState({ show: false });
  	}

  	handleShow() {
    	this.setState({ show: true });
    	this.props.greetHandler(this.state.event.id);
    	// alert(this.state.event.id)
  	}
  	redirectToEvent (id) {
  		this.handleClose();
  		this.props.changeEvent(id);
  	}

  	componentDidMount(){
  		//Fetching the recommendations from backend.
  		fetch('http://localhost:8000/getRec',{
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(this.state.event.id),
    })
    .then((response) => response.json())
    .then((res) => {
      "HÄR SPARAR VI NER INFON FRÅN BACKEND"
      this.setState({events: res.hits.hits})
    })
  	}


	render(){
		return(
			<>
	        <ListGroup.Item action variant="flush" className ="eventList"onClick={this.handleShow}>
	          <strong>{this.props.name}</strong>
	          <p className = "teaseText">{this.state.event.summary}</p>
	        </ListGroup.Item>

	        <Modal size="lg" show={this.state.show} onHide={this.handleClose}>
	          <Modal.Header closeButton>
	            <Modal.Title>{this.state.event.name}</Modal.Title>
	          </Modal.Header>
	          <Modal.Body>{this.state.event.text}</Modal.Body>
	          <Modal.Footer>
	          	<Container>

		          	<Row>
		          		<Col md = {{offset: 6}}>

			            </Col>
			            <Col md = {{span: "auto", offset: 0}}>
				            <Button variant="secondary"  onClick={this.handleClose}>
				            	Close
				            </Button>

			            </Col>
		            </Row>
	            </Container>
	          </Modal.Footer>
	        </Modal>
	        </>






			)
	}
}
export default EventInformaion;