import { Container, Row, Col, Button, Card, CardDeck, Alert } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import OrderPage from "./OrderPage";
import { useEffect } from "react";
import axios from "axios";
import { createOrdersList } from "../store/actions";

export default function Orders() {
    let orderData = useSelector((state) => state.orders);
    const dispatch = useDispatch();

    useEffect(() => {
        getOrders();
    }, []);

    const getOrders = () => {
        axios.get("http://localhost:8000/orders").then((respose) => {
            dispatch(createOrdersList(respose.data));
        });
    };

    return (
        <Container className="mt-1 mb-5">
            <Row>
                {orderData.map((item) => (
                    <OrderPage key={item.id} item={item} />
                ))}
            </Row>
        </Container>
    );
}
