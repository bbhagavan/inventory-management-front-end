import { Modal, Button } from "react-bootstrap";
import { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { createCheckOut } from "../store/actions";
import { postOrderInDB, deleteCartInDB } from "../database-management/post-data";

export default function CheckOut(props) {
    const [show, setShow] = useState(false);
    const { address, setAddress, items } = props;
    let orderId = useSelector((state) => state.orders.length);
    const dispatch = useDispatch();

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <>
            <Button variant="primary" className="w-50 mt-1" onClick={handleShow}>
                Check Out
            </Button>

            <Modal show={show} onHide={handleClose} backdrop="static" keyboard={false}>
                <Modal.Header closeButton>
                    <Modal.Title>Check out</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    Enter the shipping address here:
                    <br />
                    <input
                        type="text"
                        onChange={(e) => {
                            setAddress(e.target.value);
                        }}
                        id="address"
                    />
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button
                        variant="primary"
                        onClick={function () {
                            let order = {
                                id: orderId + 1001,
                                items: {
                                    products: items.map((item) => ({
                                        pid: item.pid,
                                        count: item.count,
                                    })),
                                },
                                address: address,
                                status: "shipped",
                            };

                            dispatch(createCheckOut(order));
                            postOrderInDB(order);
                            deleteCartInDB();
                            handleClose();
                        }}
                    >
                        Place order
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}
