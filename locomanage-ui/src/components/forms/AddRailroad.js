import React, { useState } from "react";
import { Button, Modal, Form, Row, Col } from "react-bootstrap"
import { POST } from "../../util/apiCommunication";

const AddRailroad = () => 
{
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        POST(`railroad/add/${document.getElementById("railroadName").value}`);
        window.location.reload();
        handleClose();
    }

    //onChange={(event) => setObject((previous) => ({ "name": event.target.value, ...previous }))}

    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                Add Railroad
            </Button>

            <Modal size="lg" show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Railroad</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Row>
                                <Col md={4}><Form.Label>Railroad</Form.Label></Col>
                                <Col md={8}>
                                    <Form.Control id="railroadName" placeholder="Railroad">
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
                                    <Form.Control as="textarea" rows={3} placeholder="notes" />
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

export default AddRailroad;