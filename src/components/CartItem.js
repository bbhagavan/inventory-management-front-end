import { Button, Card } from "react-bootstrap";
import { decreaseCount, addCount, createRemoveCart } from "../store/actions";
import { useDispatch } from "react-redux";
import { removeCartItemInDB } from "../database-management/post-data";

export default function CartItem(props) {
    let { product } = props;
    const dispatch = useDispatch();

    return (
        <Card border className="h-100 p-1">
            <Card.Title>{product.name}</Card.Title>
            <Card.Text className="my-auto">{product.description}</Card.Text>
            <div className="d-flex mx-auto w-25 mt-3 justify-content-around">
                <Button
                    onClick={function () {
                        dispatch(decreaseCount(product.pid));
                    }}
                    className="py-0 px-1"
                >
                    -
                </Button>
                <Button className="py-0 px-1" variant="outline-primary" disabled>
                    {product.count}
                </Button>
                <Button
                    className="py-0 px-1"
                    onClick={function () {
                        dispatch(addCount(product.pid));
                    }}
                >
                    +
                </Button>
            </div>
            <Button disabled variant="outline-info">
                Rs.{Math.round(product.price * (1 - product.discount / 100)) * product.count}
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
