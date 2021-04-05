import React, { useState } from "react";
import { Button, Modal, Form, Row, Col } from "react-bootstrap"
import { GET, POST } from "../../util/apiCommunication";

const AddClassification = (props) => 
{
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        POST(`classification/add/${document.getElementById("classificationName").value}`).then(GET("classificationsJSON", props.setter));
        handleClose();
    }

    //onChange={(event) => setObject((previous) => ({ "name": event.target.value, ...previous }))}

    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                Add Classification
            </Button>

            <Modal size="lg" show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Classification</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Row>
                                <Col md={4}><Form.Label>Classification</Form.Label></Col>
                                <Col md={8}>
                                    <Form.Control id="classificationName" placeholder="class">
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

export default AddClassification;