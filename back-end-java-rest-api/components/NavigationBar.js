import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCartPlus } from "@fortawesome/free-solid-svg-icons";
import { useSelector } from "react-redux";

export default function NavigationBar() {
    let count = useSelector((state) => state.cartItems.length);
    return (
        <Navbar sticky="top" bg="dark" variant="dark">
            <Navbar.Brand href="" className="text-white">
                <Link to={"/"}>
                    <MenuItem>Brand</MenuItem>
                </Link>
            </Navbar.Brand>
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
            <Link to={"/cart"}>
                <MenuItem className="position-absolute ml-n5 mt-n2">
                    <FontAwesomeIcon icon={faCartPlus} />
                    <Count className="position-relative ml-3 mt-n4">{count}</Count>
                </MenuItem>
            </Link>
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
