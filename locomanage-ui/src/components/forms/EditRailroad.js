import React, { useState } from "react";
import { Button, Modal, Form, ListGroup } from "react-bootstrap"
import { UPDATE } from "../../util/apiCommunication";

const EditRailroad = (props) => 
{
    const [show, setShow] = useState(false);
    const [railroad, setRailroad] = useState(props.data);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleDelete = () => 
    {
        console.log("delete");
        console.log(railroad.id);
        UPDATE("railroad", "delete", railroad.id, props.setter);
        handleClose();
    }
    const handleSave = () =>
    {
        console.log("update");
        UPDATE("railroad", "update", JSON.stringify(railroad), props.setter);
        handleClose();
    }

    //onChange={(event) => setObject((previous) => ({ "name": event.target.value, ...previous }))}

    return (
        <>
            <ListGroup.Item key={`railroad${props.data.id}e`} action onClick={handleShow}>
                {props.data.name}
            </ListGroup.Item>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit Railroad</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Label>Railroad</Form.Label>
                        <Form.Control defaultValue={props.data.name} onChange={(event) => { setRailroad((previous) => ({ ...previous, name: event.target.value })) }} />
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

export default EditRailroad;
