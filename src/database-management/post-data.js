import axios from "axios";

export function postOrderInDB(order) {
    axios
        .post("orders", JSON.stringify(order), {
            headers: {
                "content-type": "application/json",
                Authorization: "Bearer " + localStorage.getItem("token"),
            },
        })
        .then((res) => {
            console.log(res.data);
        });
}

export function postProductIntoCart(product) {
    axios
        .post("cart", JSON.stringify(product), {
            headers: {
                "content-type": "application/json",
                Authorization: "Bearer " + localStorage.getItem("token"),
            },
        })
        .then((res) => {
            console.log(res.data);
        });
}

export function removeCartItemInDB(id) {
    axios
        .delete("cart/" + id, {
            headers: {
                Authorization: "Bearer " + localStorage.getItem("token"),
            },
        })
        .then((res) => {
            console.log(res.data);
        });
}

export function deleteCartInDB() {
    axios
        .delete("cart", {
            headers: {
                Authorization: "Bearer " + localStorage.getItem("token"),
            },
        })
        .then((res) => {
            console.log(res.data);
        });
}
