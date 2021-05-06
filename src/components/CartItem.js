import { Button, Card } from "react-bootstrap";
import { decreaseCount, addCount, createRemoveCart } from "../store/actions";
import { useDispatch } from "react-redux";
import { removeCartItemInDB } from "../database-management/post-data";

export default function CartItem(props) {
    let { product } = props;
    const dispatch = useDispatch();

    return (
        <Card border className="my-2 p-1">
            <Card.Title>{product.item.name}</Card.Title>
            <Card.Text className="my-auto">{product.item.desc}</Card.Text>
            <div className="d-flex justify-content-center">
                <Button
                    onClick={() => {
                        dispatch(decreaseCount(product.item.pid));
                    }}
                >
                    -
                </Button>
                <Button variant="outline-primary" disabled>
                    {product.count}
                </Button>
                <Button
                    onClick={() => {
                        dispatch(addCount(product.item.pid));
                    }}
                >
                    +
                </Button>
            </div>
            <Button disabled variant="outline-info">
                Rs.{product.item.price * product.count}
            </Button>
            <Button
                onClick={() => {
                    dispatch(createRemoveCart(product.item.pid));
                    removeCartItemInDB(product.item.pid);
                }}
            >
                Remove from cart
            </Button>
        </Card>
    );
}
