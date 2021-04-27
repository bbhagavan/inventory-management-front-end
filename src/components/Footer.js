import { Navbar, Container, Col } from "react-bootstrap";

export default function Footer() {
    return (
        <Navbar fixed="bottom" bg="dark" variant="dark">
            <Container>
                <Col className="text-muted">
                    <p>{new Date().getFullYear()}@ All rights are reserved</p>
                </Col>
            </Container>
        </Navbar>
    );
}
