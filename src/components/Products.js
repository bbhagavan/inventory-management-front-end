import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { useSelector } from "react-redux";

export default function Products() {
    let items = useSelector((state) => state.products);

    return (
        <Container>
            <Row>
                {items.map((item) => (
                    <Col sm={6} md={4} lg={3} key={item.pid}>
                        <Card border className="my-2 p-1">
                            <Card.Title>{item.name}</Card.Title>
                            <Card.Text className="my-auto">{item.desc}</Card.Text>
                            <Button variant="outline-primary" disabled>
                                Rs.{item.price}
                            </Button>
                            <Button variant="outline-info">Add to cart</Button>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    );
}
