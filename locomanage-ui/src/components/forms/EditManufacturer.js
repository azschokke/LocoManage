import React, { useState } from "react";
import { Button, Modal, Form, ListGroup } from "react-bootstrap"
import { UPDATE } from "../../util/apiCommunication";

const EditManufacturer = (props) => 
{
    const [show, setShow] = useState(false);
    const [manufacturer, setManufacturer] = useState(props.data);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleDelete = () => 
    {
        console.log("delete");
        UPDATE("manufacturer", "delete", manufacturer.id, props.setter);
        handleClose();
    }
    const handleSave = () =>
    {
        UPDATE("manufacturer", "update", manufacturer, props.setter);
        handleClose();
    }

    //onChange={(event) => setObject((previous) => ({ "name": event.target.value, ...previous }))}

    return (
        <>
            <ListGroup.Item key={`manufacturer${props.data.id}e`} action onClick={handleShow}>
                {props.data.name}
            </ListGroup.Item>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit Manufacturer</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Label>Manufacturer</Form.Label>
                        <Form.Control defaultValue={props.data.name} onChange={(event) => { setManufacturer((previous) => ({ ...previous, name: event.target.value })) }} />
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

export default EditManufacturer;
