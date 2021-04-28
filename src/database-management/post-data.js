import axios from "axios";

export function postOrderInDB(order) {
    axios
        .post("http://localhost:8000/orders", JSON.stringify(order), {
            headers: { "content-type": "application/json" },
        })
        .then((res) => {
            console.log(res.data);
        });
}

export function postProductIntoCart(product) {
    axios
        .post("http://localhost:8000/cart", JSON.stringify(product), {
            headers: { "content-type": "application/json" },
        })
        .then((res) => {
            console.log(res.data);
        });
}

export function removeCartItemInDB(id) {
    axios.delete("http://localhost:8000/cart/" + id).then((res) => {
        console.log(res.data);
    });
}

export function deleteCartInDB() {
    axios.delete("http://localhost:8000/cart").then((res) => {
        console.log(res.data);
    });
}
