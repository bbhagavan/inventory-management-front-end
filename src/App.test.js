import { render, screen } from "@testing-library/react";
import App from "./App";
import { store } from "./store";
import * as redux from "react-redux";
import Enzyme, { shallow, mount } from "enzyme";
import Adapter from "@wojtekmaj/enzyme-adapter-react-17";
import NavigationBar from "./components/NavigationBar";
import Products from "./components/Products";
import renderer, { create } from "react-test-renderer";
import { BrowserRouter as Router } from "react-router-dom";
import { act } from "react-dom/test-utils";
import configureMockStore from "redux-mock-store";
import { reducer } from "./store/reducer";

// test("renders learn react link", () => {
//     render(
//         <Provider store={store}>
//             <App />
//         </Provider>
//     );
//     const linkElement = screen.getByText(/brand shopping/i);
//     expect(linkElement).toBeInTheDocument();
// });

Enzyme.configure({ adapter: new Adapter() });

describe("Tests", () => {
    // it("should render cart count", () => {
    //     localStorage.setItem("token", "xyz");
    //     let container = document.createElement("div");
    //     document.body.appendChild(container);
    //     act(() => {
    //         render(
    //             <redux.Provider store={store}>
    //                 <Router>
    //                     <NavigationBar />
    //                 </Router>
    //             </redux.Provider>,
    //             container
    //         );
    //     });
    //     const count = document.getElementById("count");
    //     expect(count.textContent).toEqual("0");
    //     localStorage.clear();
    // });
    it("should render add to cart", () => {
        localStorage.setItem("token", "xyz");
        let state = {
            products: [
                {
                    pid: "p001",
                    name: "Iphone",
                    description: "Good mobile for security",
                    price: 60000,
                },
                {
                    pid: "p002",
                    name: "Mac-book",
                    description: "Good laptop for better performance",
                    price: 160000,
                },
                {
                    pid: "p007",
                    name: "Whirlpool Fridge",
                    description: "Nice cooling storage",
                    price: 13000,
                },
            ],
            cartItems: [],
        };
        const mockStore = configureMockStore();

        // jest.spyOn(redux, "useSelector").mockReturnValue(data);
        act(() => {
            render(
                <redux.Provider store={mockStore(() => state)}>
                    <Router>
                        <Products />
                        <NavigationBar />
                    </Router>
                </redux.Provider>
            );
        });
        const buttons = document.querySelectorAll("button.btn-outline-info");
        buttons?.[0].dispatchEvent(new MouseEvent("click", { bubbles: true }));

        localStorage.setItem("token", "xyz");
        let container = document.createElement("div");
        document.body.appendChild(container);
        // act(() => {
        //     render(
        //         <Provider store={store}>
        //             <Router>
        //                 <NavigationBar />
        //             </Router>
        //         </Provider>,
        //         container
        //     );
        // });
        const count = document.getElementById("count");
        expect(count?.textContent).toEqual("1");
        localStorage.clear();
    });
    it("another approach", () => {
        expect(
            reducer(
                { cartItems: [] },
                {
                    type: "ADD-ITEM-CART",
                    payload: {
                        pid: "p007",
                        name: "Whirlpool Fridge",
                        description: "Nice cooling storage",
                        price: 13000,
                    },
                }
            )
        );
    });
});
