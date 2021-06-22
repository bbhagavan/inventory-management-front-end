import { Container, Row } from "react-bootstrap";
import { useSelector } from "react-redux";
import OrderPage from "./OrderPage";

export default function Orders() {
    let orderData = useSelector((state) => state.orders);

    return (
        <Container className="mt-1 mb-5">
            <Row>
                {orderData && orderData.map((order) => <OrderPage key={order.id} order={order} />)}
            </Row>
        </Container>
    );
}
