import React, { useState } from "react";
import { Button, Modal, Form, Row, Col } from "react-bootstrap"
// import { POST } from "../../util/thatsSoFetch";

const AddChain = () => 
{
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        console.log("save!");
        handleClose();
    }

    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                Add Chain
            </Button>

            <Modal size="lg" show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Chain</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Row>
                                <Col md={4}><Form.Label>Chain Name</Form.Label></Col>
                                <Col md={8}>
                                    <Form.Control placeholder="train">
                                    </Form.Control>
                                </Col>
                            </Row>
                        </Form.Group>
                        <Form.Group>
                            <Row>
                                <Col><Form.Label>Notes</Form.Label></Col>
                            </Row>
                            <Row>
                                <Col>
                                    <Form.Control as="textarea" rows={3} placeholder="i like trains" />
                                </Col>
                            </Row>
                        </Form.Group>

                    </Form>
                </Modal.Body>

                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>Close</Button>
                    <Button variant="primary" onClick={handleSave}>Save Changes</Button>
                </Modal.Footer>
            </Modal>
        </>
    );
};

export default AddChain;