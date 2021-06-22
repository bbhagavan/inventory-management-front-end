import { Button, Card } from "react-bootstrap";
import { decreaseCount, addCount, createRemoveCart } from "../store/actions";
import { useDispatch } from "react-redux";
import { removeCartItemInDB } from "../database-management/post-data";
import NumberFormat from "react-number-format";

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
            <hr className="mt-1" />
            <h5>
                <NumberFormat
                    displayType="text"
                    thousandSeparator={true}
                    thousandsGroupStyle="lakh"
                    prefix={"₹"}
                    value={Math.round(product.price * (1 - product.discount / 100)) * product.count}
                />
            </h5>
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
