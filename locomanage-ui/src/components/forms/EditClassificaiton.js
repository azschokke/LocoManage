import React, { useState } from "react";
import { Button, Modal, Form, ListGroup } from "react-bootstrap"
import { UPDATE } from "../../util/apiCommunication";

const EditClassification = (props) => 
{
    const [show, setShow] = useState(false);
    const [classification, setClassification] = useState(props.data);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleDelete = () => 
    {
        console.log("delete");
        UPDATE("classification", "delete", classification.id, props.setter)
        handleClose();
    }
    const handleSave = () =>
    {
        console.log("update");
        UPDATE("classification", "update", JSON.stringify(classification), props.setter);
        handleClose();
    }

    //onChange={(event) => setObject((previous) => ({ "name": event.target.value, ...previous }))}

    return (
        <>
            <ListGroup.Item key={`classification${props.data.id}`} action onClick={handleShow}>
                {props.data.name}
            </ListGroup.Item>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit Classification</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Label>Classification</Form.Label>
                        <Form.Control defaultValue={props.data.name} onChange={(event) => { setClassification((previous) => ({ ...previous, name: event.target.value })) }} />
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="danger" onClick={handleDelete}>Delete</Button>
                    <Button variant="primary" onClick={handleSave}>Save Changes</Button>
                </Modal.Footer>
            </Modal>
        </>
    );
};

export default EditClassification;
