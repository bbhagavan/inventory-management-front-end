import { Container, Form, Button } from "react-bootstrap";
import axios from "axios";
import { useDispatch } from "react-redux";
import { createAddUser } from "../store/actions";

export default function LoginPage() {
    const dispath = useDispatch();

    let credentials = {};

    const getUser = () => {
        axios
            .post("authenticate", JSON.stringify(credentials), {
                headers: { "Content-Type": "application/json" },
            })
            .then((res) => {
                localStorage.setItem("token", res.data.jwt);
                dispath(createAddUser({ name: "user" }));
            });
    };

    return (
        <Container className="w-50">
            <Form>
                <Form.Group>
                    <Form.Label>Username: </Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter your username.."
                        onChange={(e) => {
                            credentials.username = e.target.value;
                        }}
                    />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Password: </Form.Label>
                    <Form.Control
                        type="password"
                        placeholder="Enter your password.."
                        onChange={(e) => {
                            credentials.password = e.target.value;
                        }}
                    />
                </Form.Group>
                <Button
                    variant="primary"
                    type="submit"
                    onClick={(e) => {
                        e.preventDefault();
                        getUser(e);
                    }}
                >
                    Login
                </Button>
            </Form>
        </Container>
    );
}
