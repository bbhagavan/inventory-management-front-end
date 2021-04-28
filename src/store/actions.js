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
