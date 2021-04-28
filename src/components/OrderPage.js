import { Col, Button, Card, Alert } from "react-bootstrap";
import { useState, useEffect, Component } from "react";
import axios from "axios";
import OrderDetailsView from "./OrderDetailsView";

export default class OrderPage extends Component {
    constructor(props) {
        super(props);
        this.item = props.item;
        this.state = { details: [], cost: 0 };
    }
    componentDidMount() {
        axios.get("http://localhost:8000/ordersdetails/" + this.item.id).then((respose) => {
            let cost = 0;
            respose.data.map((prod) => {
                cost += prod.item.price * prod.count;
            });
            this.setState((state) => ({
                ...state,
                details: respose.data,
                cost,
            }));
        });
    }

    render() {
        return (
            <Col>
                <Card className="mx-2 p-1">
                    <Card.Title>Order #{this.item.id}</Card.Title>
                    <Card.Text className="text-dark">
                        Status: {this.item.status}
                        <br />
                        Address: {this.item.address}
                    </Card.Text>
                    <hr />
                    <p>Rs {this.state.cost}</p>
                    <OrderDetailsView details={this.state.details} cost={this.state.cost} />
                </Card>
            </Col>
        );
    }
}
