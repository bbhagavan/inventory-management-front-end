import { Col, Button, Card, Alert } from "react-bootstrap";
import { useState, useEffect, Component } from "react";
import axios from "axios";

export default class OrderPage extends Component {
    constructor(props) {
        super(props);
        this.item = props.item;
        this.state = { show: false, details: [], cost: 0 };
    }
    componentDidMount() {
        axios.get("http://localhost:8000/ordersdetails/" + this.item.id).then((respose) => {
            let cost = 0;
            respose.data.map((prod) => {
                cost += prod.price;
            });
            this.setState((state) => ({
                ...state,
                details: respose.data,
                cost,
            }));
        });
    }
    componentDidUpdate() {
        console.log("no setstate 1");
    }
    componentWillUpdate() {
        console.log("no setstate 2");
    }

    render() {
        return (
            <Col key={this.item.id}>
                <Card className="mx-2 p-1">
                    <Card.Title>Order #{this.item.id}</Card.Title>
                    <Card.Text className="text-dark">
                        {this.item.status}
                        <br />
                        {this.item.address}
                    </Card.Text>
                    <hr />
                    <p>Rs {this.state.cost}</p>
                    <Button
                        variant="outline-info"
                        onClick={() => this.setState((state) => ({ ...state, show: true }))}
                    >
                        View details
                    </Button>
                </Card>
                <Alert show={this.state.show} variant="success">
                    <Alert.Heading>order details</Alert.Heading>
                    {this.state.details.map((item) => {
                        return (
                            <p>
                                Item: {item.name} * {item.count} = Rs.{item.price}
                            </p>
                        );
                    })}
                    <hr className="my-0" />
                    <p>Total cost: {this.state.cost}</p>
                    <div className="d-flex justify-content-end">
                        <Button
                            onClick={() => this.setState((state) => ({ ...state, show: false }))}
                            variant="outline-success"
                        >
                            Close
                        </Button>
                    </div>
                </Alert>
            </Col>
        );
    }
}
