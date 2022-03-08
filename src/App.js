import "./App.css";
import styled from "styled-components";

function App() {
    return <StyledComponent>Hello world</StyledComponent>;
}

const StyledComponent = styled.div`
    text-alin: center;
    color: red;
    font-size: 34px;
`;

export default App;
