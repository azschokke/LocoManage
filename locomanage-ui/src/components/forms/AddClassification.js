import React, { useState } from "react";
import { Button, Modal, Form } from "react-bootstrap"
import { UPDATE } from "../../util/apiCommunication";

const AddClassification = (props) => 
{
    const [show, setShow] = useState(false);
    const [newClassification, setNewClassification] = useState();

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        UPDATE("classification", "add", newClassification, props.setter);
        handleClose();
    }
    //onChange={(event) => setObject((previous) => ({ "name": event.target.value, ...previous }))}

    return (
        <>
            <Button variant="primary" onClick={handleShow} block>
                Add Classification
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Classification</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Label>Classification</Form.Label>
                        <Form.Control id="classificationName" placeholder="class" onChange={(event) => setNewClassification(event.target.value)} />
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