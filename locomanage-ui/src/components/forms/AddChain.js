import React, { useEffect, useState } from "react";
import { Button, Modal, Form, Row, Col } from "react-bootstrap"
import { POST, GET } from "../../util/apiCommunication";

const AddChain = (props) => 
{
    const [show, setShow] = useState(false);
    const [chain, setChain] = useState({ name: "", cars: props.stock, location: 0 });
    const [tracks, setTracks] = useState([]);

    useEffect(() =>
    {
        GET(`location/tracks/${window.localStorage.getItem("userId")}`, setTracks);
    });

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () =>
    {
        console.log("save!");
        POST(`chain/add/${window.localStorage.getItem("userId")}`, JSON.stringify(chain)).then(() => 
        {
            GET(`chain/all/${window.localStorage.getItem("userId")}`, props.chains);
            GET(`rollingStock/available/${window.localStorage.getItem("userId")}`, props.availableCars);
        });
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
                        <Form.Group>
                            <Row>
                                <Col md={4}><Form.Label>Location</Form.Label></Col>
                                <Col md={8}>
                                    <Form.Control as="select" placeholder="tracks" onChange={(event) => { setChain((previous) => ({ ...previous, location: event.target.value })) }}>
                                        <option value={0}>None</option>
                                        {
                                            tracks.map((i) =>
                                            {
                                                return <option value={i.id} key={`chainLocationSelect${i.id}`}>{i.name}</option>
                                            })
                                        }
                                    </Form.Control>
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