import { Container, Row, Col, Button, Card, CardDeck, Alert } from "react-bootstrap";
import { useSelector } from "react-redux";
import OrderPage from "./OrderPage";

export default function Orders() {
    let orderData = useSelector((state) => state.orders);
    // [
    //     { id: 1, items: ["p001", "p002", "p003"], cost: 280000 },
    //     { id: 2, items: ["p004", "p006"], cost: 70000 },
    //     { id: 3, items: ["p005"], cost: 70000 },
    //     { id: 4, items: ["p004", "p006"], cost: 70000 },
    //     { id: 5, items: ["p004", "p006"], cost: 70000 },
    // ];
    return (
        <Container className="mt-1 mb-5">
            <Row>
                {orderData.map((item) => (
                    <OrderPage item={item} />
                ))}
            </Row>
        </Container>
    );
}
