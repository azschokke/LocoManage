import React, { useState, useEffect } from "react";
import { Button, Modal, Form } from "react-bootstrap"
import { GET, UPDATE } from "../../util/apiCommunication";

const AddLocation = (props) => 
{
    const [show, setShow] = useState(false);
    const [locations, setLocations] = useState([]);
    const [newLocation, setNewLocation] = useState({ isTrack: false, name: "", parent: 0 });

    useEffect(() =>
    {
        GET(`location/listNames/${window.localStorage.getItem("userId")}`, setLocations);
    }, [props.locations]);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        console.log("save!");
        console.log(newLocation);
        UPDATE("location", `add/${window.localStorage.getItem("userId")}`, JSON.stringify(newLocation), props.setter);
        // POST("location/add",
        //     `${document.getElementById("locationName").value},${document.getElementById("parentLoc").value},${document.getElementById("isTrack").checked}`);
        handleClose();
    }//end handleSave

    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                Add Location
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Location</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>Location Name</Form.Label>
                            <Form.Control id="locationName" placeholder="name" onChange={(event) => { setNewLocation((previous) => ({ ...previous, name: event.target.value })) }} />

                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Parent Location</Form.Label>
                            <Form.Control id="parentLoc" as="select" placeholder="locations" onChange={(event) => setNewLocation((previous) => ({ ...previous, parent: event.target.value }))}>
                                <option value={0}>None</option>
                                {locations.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                {
                                    return <option key={i.id} value={i.id}>{i.name}</option>
                                })}
                            </Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Check onChange={(event) => setNewLocation((previous) => ({ ...previous, isTrack: event.target.checked }))}
                                custom
                                type="switch"
                                id="isTrack"
                                label="This location is a track"
                            />
                        </Form.Group>

                    </Form>
                </Modal.Body>

                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>Close</Button>
                    <Button variant="primary" onClick={handleSave}>Save Changes</Button>
                </Modal.Footer>
            </Modal >
        </>
    );
};

export default AddLocation;