import { postProductIntoCart } from "../database-management/post-data";

export function reducer(state, action) {
    switch (action.type) {
        case "ADD-USER":
            return { ...state, user: action.payload };
        case "LOG-OUT":
            return {  };
        case "ADD-PRODUCTS":
            return { ...state, products: action.payload };

        case "ADD-CART":
            return { ...state, cartItems: action.payload };

        case "ADD-ITEM-CART":
            postProductIntoCart(action.payload);
            let flag = 0;
            let result = {
                ...state,
                cartItems: state.cartItems.map((item) => {
                    if (item.item.pid === action.payload.pid) {
                        flag = 1;
                        return { ...item, count: item.count + 1 };
                    }
                    return item;
                }),
            };
            if (flag == 1) return result;
            return {
                ...state,
                cartItems: [...state.cartItems, { item: action.payload, count: 1 }],
            };

        case "REMOVE-ITEM-CART":
            return {
                ...state,
                cartItems: state.cartItems.filter((item) => item.item.pid != action.payload.pid),
            };

        case "ADD-COUNT":
            return {
                ...state,
                cartItems: state.cartItems.map((item) => {
                    if (item.item.pid == action.payload) return { ...item, count: item.count + 1 };
                    else return item;
                }),
            };

        case "SUB-COUNT":
            return {
                ...state,
                cartItems: state.cartItems.map((item) => {
                    if (item.item.pid === action.payload) return { ...item, count: item.count - 1 };
                    else return item;
                }),
            };

        case "ADD-ORDERS-LIST":
            return {
                ...state,
                orders: action.payload,
            };

        case "CHECK-OUT":
            return {
                ...state,
                orders: [...state.orders, action.payload],
                cartItems: [],
            };

        default:
            return state;
    }
}
