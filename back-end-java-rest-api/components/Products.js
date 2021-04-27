import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { createAddCart } from "../store/actions";

export default function Products() {
    let items = useSelector((state) => state.products);
    const dispatch = useDispatch();

    return (
        <Container className="mb-5">
            <Row>
                {items.map((item) => (
                    <Col sm={6} md={4} lg={3} key={item.pid}>
                        <Card border className="my-2 p-1">
                            <Card.Title>{item.name}</Card.Title>
                            <Card.Text className="my-auto">{item.desc}</Card.Text>
                            <Button variant="outline-primary" disabled>
                                Rs.{item.price}
                            </Button>
                            <Button
                                variant="outline-info"
                                onClick={() => {
                                    dispatch(createAddCart(item));
                                }}
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
