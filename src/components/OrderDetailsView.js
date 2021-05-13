import { useState } from "react";
import { Button, Modal } from "react-bootstrap";

export default function OrderDetailsView(props) {
    const [show, setShow] = useState(false);

    let { details, cost } = props;

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                View details
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Order details</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    {details.map((item) => {
                        return (
                            <p key={item.pid}>
                                Item: {item.name} ( Rs.{item.price} ) * {item.count} = Rs.
                                {item.price * item.count}
                            </p>
                        );
                    })}
                    <hr />
                    <p>Total cost: {cost}</p>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="outline-secondary" onClick={handleClose}>
                        close
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}
