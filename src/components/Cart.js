import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { addCount, decreaseCount, increamentItemsInCount } from "../store/actions";
import { useState } from "react";

export default function Cart() {
    let items = useSelector((state) => state.cartItems);
    const dispatch = useDispatch();

    return (
        <Container className="mt-1">
            <h3>Welcome to Cart</h3>
            <Row>
                {items.map((item) => {
                    return (
                        <Col sm={6} md={4} lg={3} key={item.item.pid}>
                            <Card border className="my-2 p-1">
                                <Card.Title>{item.item.name}</Card.Title>
                                <Card.Text className="my-auto">{item.item.desc}</Card.Text>
                                <div className="d-flex justify-content-center">
                                    <Button
                                        onClick={() => {
                                            dispatch(decreaseCount(item.item.pid));
                                        }}
                                    >
                                        -
                                    </Button>
                                    <Button variant="outline-primary" disabled>
                                        {item.count}
                                    </Button>
                                    <Button
                                        onClick={() => {
                                            dispatch(addCount(item.item.pid));
                                        }}
                                    >
                                        +
                                    </Button>
                                </div>
                                <Button disabled variant="outline-info">
                                    Rs.{item.item.price * item.count}
                                </Button>
                            </Card>
                        </Col>
                    );
                })}
            </Row>
            <Button className="w-50">Check out</Button>
        </Container>
    );
}
