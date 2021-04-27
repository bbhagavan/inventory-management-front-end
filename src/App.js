import "./App.css";
import styled from "styled-components";
import Home from "./components/Home";
import { Container } from "react-bootstrap";
import NavigationBar from "./components/NavigationBar";
import Footer from "./components/Footer";
import Products from "./components/Products";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Orders from "./components/Orders";
import Cart from "./components/Cart";
import { useEffect } from "react";
import axios from "axios";
import { createInitialAdd, createCart } from "./store/actions";
import { useDispatch } from "react-redux";
import Services from "./components/Services";

function App() {
    const dispatch = useDispatch();
    useEffect(() => {
        getProductsOfCart();
        getProducts();
    }, []);

    const getProductsOfCart = () => {
        axios.get("http://localhost:8000/cart").then((respose) => {
            dispatch(createCart(respose.data));
        });
    };

    const getProducts = () => {
        axios.get("http://localhost:8000/products").then((respose) => {
            dispatch(createInitialAdd(respose.data));
        });
    };

    return (
        <Router>
            <StyledComponent>
                <NavigationBar />
                <Container>
                    <Switch>
                        <Route path="/" exact component={Home} />
                        <Route path="/services" exact component={Services} />
                        <Route path="/products" exact component={Products} />
                        <Route path="/orders" exact component={Orders} />
                        <Route path="/orders/details" exact component={Orders} />
                        <Route path="/cart" exact component={Cart} />
                    </Switch>
                </Container>
                <Footer />
            </StyledComponent>
        </Router>
    );
}

const StyledComponent = styled.div`
    text-align: center;
`;

export default App;
