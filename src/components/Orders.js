import { Container, Row, Col, Button, Card, CardDeck } from "react-bootstrap";

export default function Orders() {
    let orderData = [
        { id: 1, items: ["p001", "p002", "p003"], cost: 280000 },
        { id: 2, items: ["p004", "p006"], cost: 70000 },
        { id: 3, items: ["p005"], cost: 70000 },
        { id: 4, items: ["p004", "p006"], cost: 70000 },
        { id: 5, items: ["p004", "p006"], cost: 70000 },
    ];
    return (
        <Container className="mt-1">
            <Row>
                {orderData.map((item) => (
                    <Col key={item.id}>
                        <Card className="mx-2 p-1">
                            <Card.Title>Order</Card.Title>
                            <Card.Text className="text-dark">Status: Shipped</Card.Text>
                            <Button variant="outline-primary" disabled>
                                Rs.{item.cost}
                            </Button>
                            <Button variant="outline-info">View details</Button>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    );
}
