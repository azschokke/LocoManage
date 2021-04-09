import React, { useState } from "react";
import { Button, Modal, Form, Row, Col } from "react-bootstrap"
import { POST } from "../../util/apiCommunication";
// import { POST } from "../../util/thatsSoFetch";

const AddChain = (props) => 
{
    const [show, setShow] = useState(false);
    const [chain, setChain] = useState({ name: "", cars: props.stock });

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        console.log("save!");
        POST(`chain/add/${window.localStorage.getItem("userId")}`, JSON.stringify(chain));
        console.log(JSON.stringify(chain));
        handleClose();
    }

    return (
        <>
            <Button variant="primary" onClick={handleShow} block>
                Add Chain
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Chain</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Row>
                                <Col md={4}><Form.Label>Chain Name</Form.Label></Col>
                                <Col md={8}>
                                    <Form.Control placeholder="train" onChange={(event) => { setChain((previous) => ({ ...previous, name: event.target.value })) }} />
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