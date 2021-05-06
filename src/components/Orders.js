import { Container, Row } from "react-bootstrap";
import { useSelector } from "react-redux";
import OrderPage from "./OrderPage";

export default function Orders() {
    let orderData = useSelector((state) => state.orders);

    return (
        <Container className="mt-1 mb-5">
            <Row>
                {orderData && orderData.map((item) => <OrderPage key={item.id} item={item} />)}
            </Row>
        </Container>
    );
}
