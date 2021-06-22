import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { createAddCart } from "../store/actions";
import NumberFormat from "react-number-format";

export default function Products() {
    let items = useSelector((state) => state.products);
    const dispatch = useDispatch();

    return (
        <Container className="mb-5">
            <Row>
                {items?.map((item) => (
                    <Col sm={6} md={4} lg={3} key={item.pid} className="p-2">
                        <Card border="success" className=" p-1 h-100">
                            <Card.Title>{item.name}</Card.Title>
                            <Card.Text className="my-auto">{item.description}</Card.Text>
                            <div className="row mt-4 mb-2 mx-2 justify-content-around">
                                {item.discount ? (
                                    <>
                                        <h3 className="my-auto">
                                            <NumberFormat
                                                displayType="text"
                                                thousandSeparator={true}
                                                thousandsGroupStyle="lakh"
                                                prefix={"₹"}
                                                value={Math.round(
                                                    item.price * (1 - item.discount / 100)
                                                )}
                                            />
                                        </h3>
                                        <div>
                                            <strike className="my-auto" style={{ color: "#aaa" }}>
                                                <NumberFormat
                                                    displayType="text"
                                                    thousandSeparator={true}
                                                    thousandsGroupStyle="lakh"
                                                    prefix={"₹"}
                                                    value={item.price}
                                                />
                                            </strike>
                                            <p
                                                className=" px-1 my-auto bg-success text-white"
                                                style={{
                                                    "border-radius": "5px",
                                                    "font-size": "14px",
                                                }}
                                            >
                                                {item.discount}% OFF
                                            </p>
                                        </div>
                                    </>
                                ) : (
                                    <>
                                        <h3 className=" mb-0">
                                            <NumberFormat
                                                displayType="text"
                                                thousandSeparator={true}
                                                thousandsGroupStyle="lakh"
                                                prefix={"₹"}
                                                value={item.price}
                                            />
                                        </h3>
                                    </>
                                )}
                            </div>
                            <Button
                                variant="warning"
                                onClick={() => {
                                    dispatch(createAddCart(item));
                                }}
                                style={{ "font-size": "20px" }}
                            >
                                Add to cart
                            </Button>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    );
}
