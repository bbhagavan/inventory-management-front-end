import { Container, Row, Col, Button } from "react-bootstrap";
import { useSelector } from "react-redux";
import { useState, useEffect } from "react";
import CheckOut from "./CheckPage";
import { Link } from "react-router-dom";
import CartItem from "./CartItem";
import NumberFormat from "react-number-format";

export default function Cart() {
    let items = useSelector((state) => state.cartItems);
    const [address, setAddress] = useState("");
    const [total, setTotal] = useState(0);

    useEffect(() => {
        let sum = 0;
        items.map((item) => {
            sum += Math.round(item.price * (1 - item.discount / 100)) * item.count;
        });
        setTotal(sum);
    }, [items]);
    return (
        <Container className=" mt-1 mb-5">
            <h3>Welcome to Cart</h3>
            {items ? (
                <>
                    <div>
                        Your total cart value is:{" "}
                        <h4 className="d-inline">
                            <NumberFormat
                                displayType="text"
                                thousandSeparator={true}
                                thousandsGroupStyle="lakh"
                                prefix={"₹"}
                                value={total}
                            />
                        </h4>
                    </div>
                    <Row>
                        {items.map((item) => {
                            return (
                                <Col sm={6} md={4} lg={3} key={item.pid} className="py-2">
                                    <CartItem product={item} />
                                </Col>
                            );
                        })}
                    </Row>
                    <CheckOut address={address} setAddress={setAddress} items={items} />
                </>
            ) : (
                <div>
                    NO items in cart
                    <br />
                    <Link to={"/products"}>
                        <Button>Check out products</Button>
                    </Link>
                </div>
            )}
        </Container>
    );
}
