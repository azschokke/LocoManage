import React, { useState } from "react";
import { Button, Modal, Form } from "react-bootstrap"
import { UPDATE } from "../../util/apiCommunication";

const AddManufacturer = (props) => 
{
    const [show, setShow] = useState(false);
    const [newManufacturer, setNewManufacturer] = useState();

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        UPDATE("manufacturer", "add", newManufacturer, props.setter);
        handleClose();
    }

    //onChange={(event) => setObject((previous) => ({ "name": event.target.value, ...previous }))}

    return (
        <>
            <Button variant="primary" onClick={handleShow} block>
                Add Manufacturer
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Manufacturer</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>Manufacturer</Form.Label>
                            <Form.Control id="manufacturerName" placeholder="manufacturer" onChange={(event) => setNewManufacturer(event.target.value)} />
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

export default AddManufacturer;