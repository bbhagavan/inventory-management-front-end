import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { addCount, decreaseCount, createRemoveCart } from "../store/actions";
import { useState } from "react";
import CheckOut from "./CheckPage";
import { Link } from "react-router-dom";
import { removeCartItemInDB } from "../database-management/post-data";

export default function Cart() {
    let items = useSelector((state) => state.cartItems);
    const [address, setAddress] = useState("");
    const dispatch = useDispatch();

    return (
        <Container className="mt-1 mb-5">
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
                                <Button
                                    onClick={() => {
                                        dispatch(createRemoveCart(item.item.pid));
                                        removeCartItemInDB(item.item.pid);
                                    }}
                                >
                                    Remove from cart
                                </Button>
                            </Card>
                        </Col>
                    );
                })}
            </Row>
            {items.length != 0 ? (
                <CheckOut address={address} setAddress={setAddress} items={items} />
            ) : (
                <div>
                    NO items in cart
                    <br />
                    <Link to={"/products"}>
                        <Button>See products</Button>
                    </Link>
                </div>
            )}
        </Container>
    );
}
