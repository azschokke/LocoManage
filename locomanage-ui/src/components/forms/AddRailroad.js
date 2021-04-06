import React, { useState } from "react";
import { Button, Modal, Form } from "react-bootstrap"
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
            <Button variant="primary" onClick={handleShow} block>
                Add Railroad
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Railroad</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Label>Railroad</Form.Label>
                        <Form.Control id="railroadName" placeholder="Railroad"></Form.Control>
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