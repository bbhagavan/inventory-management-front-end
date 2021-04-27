import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { useEffect } from "react";
import axios from "axios";

export default function Products() {
    let items = [
        { pid: "p001", name: "Iphone", desc: "Good mobile for security", price: 60000 },
        {
            pid: "p002",
            name: "Mac-book",
            desc: "Good laptop for better performance",
            price: 160000,
        },
        {
            pid: "p003",
            name: "Dell Laptop",
            desc: "Good laptop for every point of view",
            price: 60000,
        },
        {
            pid: "p004",
            name: "hp Laptop",
            desc: "Good laptop for every point of view",
            price: 50000,
        },
        {
            pid: "p006",
            name: "POCO Mobile",
            desc: "Good mobile for studying",
            price: 20000,
        },
    ];

    useEffect(()=>{
        axios.get()
    });
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
