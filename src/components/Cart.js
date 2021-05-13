import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { useSelector } from "react-redux";
import { useState } from "react";
import CheckOut from "./CheckPage";
import { Link } from "react-router-dom";
import CartItem from "./CartItem";

export default function Cart() {
    let items = useSelector((state) => state.cartItems);
    const [address, setAddress] = useState("");

    return (
        <Container className="mt-1 mb-5">
            <h3>Welcome to Cart</h3>
            <Row>
                {items.map((item) => {
                    return (
                        <Col sm={6} md={4} lg={3} key={item.pid}>
                            <CartItem product={item} />
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
