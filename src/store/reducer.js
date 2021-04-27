export function reducer(state = {}, action) {
    switch (action.type) {
        case "ADD-PRODUCTS":
            return { ...state, products: action.payload };
        case "ADD-CART":
            return { ...state, cartItems: action.payload };
        case "ADD-ITEM-CART":
            let flag = 0;
            state.cartItems.map((item) => {
                if (item.pid == action.payload.pid) {
                    flag = 1;
                }
            });

            if (flag == 0) return { ...state, items: [...state.items, action.payload] };
            else
                return {
                    ...state,
                    items: [...state.items, { ...action.payload, count: action.payload.count + 1 }],
                };
        case "REMOVE-ITEM-CART":
            return {
                ...state,
                items: state.items.filter((item) => item.pid != action.payload.pid),
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
        default:
            return state;
    }
}
