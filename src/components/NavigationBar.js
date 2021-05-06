import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCartPlus } from "@fortawesome/free-solid-svg-icons";
import { useSelector, useDispatch } from "react-redux";
import { createLogout } from "../store/actions";

export default function NavigationBar() {
    let count = useSelector((state) => state.cartItems.length);
    let user = useSelector((state) => state.user);
    const dispatch = useDispatch();
    let buttons;

    if (user) {
        buttons = (
            <>
                <Nav className="m-auto">
                    <Link to={"/services"}>
                        <MenuItem>Services</MenuItem>
                    </Link>
                    <Link to={"/products"}>
                        <MenuItem>Products</MenuItem>
                    </Link>
                    <Link to={"/orders"}>
                        <MenuItem>Orders</MenuItem>
                    </Link>
                </Nav>
                <Link
                    to={"/"}
                    className="mr-5"
                    onClick={() => {
                        dispatch(createLogout());
                        localStorage.clear();
                    }}
                >
                    <MenuItem>Log out</MenuItem>
                </Link>
                <Link to={"/cart"}>
                    <MenuItem className="position-absolute ml-n5 mt-n2">
                        <FontAwesomeIcon icon={faCartPlus} />
                        <Count className="position-relative ml-3 mt-n4">{count}</Count>
                    </MenuItem>
                </Link>
            </>
        );
    } else {
        buttons = (
            <Link to={"/login"}>
                <MenuItem>Sign in</MenuItem>
            </Link>
        );
    }
    return (
        <Navbar sticky="top" bg="dark" variant="dark" className="justify-content-between">
            <Navbar.Brand href="" className="text-white">
                <Link to={"/"}>
                    <MenuItem>Brand</MenuItem>
                </Link>
            </Navbar.Brand>
            {buttons}
        </Navbar>
    );
}

const MenuItem = styled.p`
    color: #fff;
    padding: 0 10px;
    margin-bottom: 0;
    &:hover {
        text-decoration: none;
        color: #0f9;
    }
`;

const Count = styled.div`
    height: 10px;
    width: 10px;
    background-color: #f00;
    border-radius: 50%;
    font-size: 6px;
`;
