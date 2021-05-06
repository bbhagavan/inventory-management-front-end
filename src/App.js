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
import { useSelector, useDispatch } from "react-redux";
import Services from "./components/Services";
import LoginPage from "./components/LoginPage";
import { getUserData, getProducts } from "./store/actions";

axios.defaults.baseURL = "http://localhost:8000/";

function App() {
    const dispatch = useDispatch();
    let user = useSelector((state) => state.user);

    useEffect(() => {
        dispatch(getProducts());
        dispatch(getUserData());
    }, [user]);

    return (
        <Router>
            <StyledComponent>
                <NavigationBar />
                <Container>
                    <Switch>
                        <Route path="/" exact component={Home} />
                        <Route path="/login" exact component={LoginPage} />
                        <Route path="/services" exact component={Services} />
                        <Route path="/products" exact component={Products} />
                        {localStorage.getItem("token") ? (
                            <>
                                <Route path="/orders" exact component={Orders} />
                                <Route path="/cart" exact component={Cart} />
                            </>
                        ) : (
                            <h3>Need to login first</h3>
                        )}
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
