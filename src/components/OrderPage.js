import { Col, Card } from "react-bootstrap";
import { Component } from "react";
import axios from "axios";
import OrderDetailsView from "./OrderDetailsView";
import NumberFormat from "react-number-format";

export default class OrderPage extends Component {
    constructor(props) {
        super(props);
        this.order = props.order;
        this.state = { details: [], cost: 0 };
    }

    componentDidMount() {
        axios.get("http://localhost:8000/ordersdetails/" + this.order.id).then((respose) => {
            let cost = 0;
            respose.data.map((prod) => {
                cost += Math.round(prod.price * (1 - prod.discount / 100)) * prod.count;
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
            <Col sm={6} md={4} lg={3} className="py-2">
                <Card className="mx-2 p-1">
                    <Card.Title>Order #{this.order.id}</Card.Title>
                    <Card.Text className="text-dark">
                        Status: {this.order.status}
                        <br />
                        Address: {this.order.address}
                    </Card.Text>
                    <hr />
                    <h3>
                        <NumberFormat
                            displayType="text"
                            thousandSeparator={true}
                            thousandsGroupStyle="lakh"
                            prefix={"₹"}
                            value={this.state.cost}
                        />{" "}
                    </h3>
                    <OrderDetailsView details={this.state.details} cost={this.state.cost} />
                </Card>
            </Col>
        );
    }
}
