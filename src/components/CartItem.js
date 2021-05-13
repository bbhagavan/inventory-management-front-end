import { Button, Card } from "react-bootstrap";
import { decreaseCount, addCount, createRemoveCart } from "../store/actions";
import { useDispatch } from "react-redux";
import { removeCartItemInDB } from "../database-management/post-data";
import { useState } from "react";

export default function CartItem(props) {
    let { product } = props;
    const dispatch = useDispatch();

    return (
        <Card border className="my-2 p-1">
            <Card.Title>{product.name}</Card.Title>
            <Card.Text className="my-auto">{product.description}</Card.Text>
            <div className="d-flex justify-content-center">
                <Button
                    onClick={function () {
                        dispatch(decreaseCount(product.pid));
                    }}
                >
                    -
                </Button>
                <Button variant="outline-primary" disabled>
                    {product.count}
                </Button>
                <Button
                    onClick={function () {
                        dispatch(addCount(product.pid));
                    }}
                >
                    +
                </Button>
            </div>
            <Button disabled variant="outline-info">
                Rs.{product.price * product.count}
            </Button>
            <Button
                onClick={function () {
                    dispatch(createRemoveCart(product.pid));
                    removeCartItemInDB(product.pid);
                }}
            >
                Remove from cart
            </Button>
        </Card>
    );
}
