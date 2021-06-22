import { useState } from "react";
import { Button, Modal } from "react-bootstrap";
import NumberFormat from "react-number-format";

export default function OrderDetailsView(props) {
    const [show, setShow] = useState(false);
    let { details, cost } = props;
    const toggle = () => setShow(!show);

    return (
        <>
            <Button variant="primary" onClick={toggle}>
                View details
            </Button>

            <Modal show={show} onHide={toggle}>
                <Modal.Header closeButton>
                    <Modal.Title>Order details</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    {details.map((item) => {
                        let discountPrice = Math.round(item.price * (1 - item.discount / 100));
                        return (
                            <p key={item.pid}>
                                Item: {item.name} ({" "}
                                <NumberFormat
                                    displayType="text"
                                    thousandSeparator={true}
                                    thousandsGroupStyle="lakh"
                                    prefix={"₹"}
                                    value={discountPrice}
                                />
                                ) * {item.count} ={" "}
                                <NumberFormat
                                    displayType="text"
                                    thousandSeparator={true}
                                    thousandsGroupStyle="lakh"
                                    prefix={"₹"}
                                    value={discountPrice * item.count}
                                />
                            </p>
                        );
                    })}
                    <hr />
                    <p>Total cost: {cost}</p>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="outline-secondary" onClick={toggle}>
                        close
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}
