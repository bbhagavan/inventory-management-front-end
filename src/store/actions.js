import axios from "axios";

export function createAddCart(product) {
    return { type: "ADD-ITEM-CART", payload: product };
}

export function createRemoveCart(productId) {
    return { type: "REMOVE-ITEM-CART", payload: { pid: productId } };
}

export function createCart(products) {
    return { type: "ADD-CART", payload: products };
}

export function createInitialAdd(products) {
    return { type: "ADD-PRODUCTS", payload: products };
}

export function addCount(id) {
    return { type: "ADD-COUNT", payload: id };
}

export function decreaseCount(id) {
    return { type: "SUB-COUNT", payload: id };
}

export function createOrdersList(orders) {
    return { type: "ADD-ORDERS-LIST", payload: orders };
}

export function createCheckOut(order) {
    return { type: "CHECK-OUT", payload: order };
}

export function createAddUser(user) {
    return { type: "ADD-USER", payload: user };
}

export function createLogout() {
    return { type: "LOG_OUT" };
}

export function getProducts() {
    //For products
    return function (dispatch) {
        axios
            .get("products", {
                headers: { Authorization: "Bearer " + localStorage.getItem("token") },
            })
            .then((respose) => {
                dispatch(createInitialAdd(respose.data));
            });
    };
}

export function getUserData() {
    return function (dispatch) {
        //For cart
        axios
            .get("cart", { headers: { Authorization: "Bearer " + localStorage.getItem("token") } })
            .then((respose) => {
                console.log(respose.data);
                dispatch(createCart(respose.data));
            });

        // For orders
        axios
            .get("orders", {
                headers: { Authorization: "Bearer " + localStorage.getItem("token") },
            })
            .then((respose) => {
                dispatch(createOrdersList(respose.data));
            });
    };
}
