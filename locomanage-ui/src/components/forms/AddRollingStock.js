import React, { useEffect, useState } from "react";
import { Button, Modal, Form, Row, Col } from "react-bootstrap"
import { GET, POST } from "../../util/apiCommunication";

const AddRollingStock = () => 
{
    const [show, setShow] = useState(false);
    const [classifications, setClassifications] = useState([]);
    const [scales, setScales] = useState([]);
    const [manufacturers, setManufacturers] = useState([]);
    const [railroads, setRailroads] = useState([]);
    const [newRollingStock, setNewRollingStock] = useState({
        railroad: 0,
        carNumber: "",
        length: "",
        model: "",
        classification: 0,
        scale: 0,
        notes: "",
        manufacturer: 0,
        sku: ""
    });

    useEffect(() =>
    {
        //get data
        GET("classification/all", setClassifications);
        GET("scale/all", setScales);
        GET("manufacturer/all", setManufacturers);
        GET("railroad/all", setRailroads);
    }, []);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const handleSave = () => 
    {
        console.log(newRollingStock);
        POST("rollingStock/add", JSON.stringify(newRollingStock));
        handleClose();
    }

    return (
        <>
            <Button variant="primary" onClick={handleShow}>
                Add Rolling Stock
            </Button>

            <Modal size="lg" show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Rolling Stock Item</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Row>
                                <Col md={6}>
                                    <Form.Label>Railroad</Form.Label>
                                </Col>
                                <Col md={3}>
                                    <Form.Label >Car Number</Form.Label>
                                </Col>
                                <Col md={3}>
                                    <Form.Label>Length</Form.Label>
                                </Col>

                            </Row>
                            <Row>
                                <Col md={6}>
                                    <Form.Control as="select" id="railroad" placeholder="railroad" onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, railroad: event.target.value })) }}>
                                        <option value={0}>Select a Railroad</option>
                                        {railroads.sort((a, b) => a.name.localeCompare(b.name)).map((i) =>
                                        {
                                            return <option key={i.id} value={i.id}>{i.name}</option>
                                        })}
                                    </Form.Control>
                                </Col>
                                <Col md={3}><Form.Control type="number" id="carNumber" placeholder="car number"
                                    onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, carNumber: event.target.valueAsNumber })) }} /></Col>
                                <Col md={3}><Form.Control type="number" id="length" placeholder="length" onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, length: event.target.valueAsNumber })) }} /></Col>
                            </Row>
                        </Form.Group>
                        <Form.Group>
                            <Row>
                                <Col md={3}><Form.Label>Model</Form.Label></Col>
                                <Col md={6}><Form.Label>Class</Form.Label></Col>
                                <Col md={3}><Form.Label>Scale</Form.Label></Col>
                            </Row>
                            <Row>
                                <Col md={3}>
                                    <Form.Control id="model" placeholder="model" onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, model: event.target.value })) }} />
                                </Col>

                                <Col md={6}>
                                    <Form.Control as="select" id="classification" placeholder="model classification"
                                        onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, classification: event.target.value })) }}>
                                        <option value={0}>Select a Classification</option>
                                        {classifications.sort((a, b) => a.name.localeCompare(b.name)).map((i) =>
                                        {
                                            return <option key={`classification${i.id}`} value={i.id}> {i.name}</option>
                                        })}
                                    </Form.Control>
                                </Col>
                                <Col md={3}>
                                    <Form.Control id="scale" as="select" placeholder="scale" onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, scale: event.target.value })) }}>
                                        <option value={0}>Select a Scale</option>
                                        {scales.map((i) =>
                                        {
                                            return <option key={`scale${i.id}`} value={i.id}>{i.name}</option>
                                        })}
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
                                    <Form.Control id="notes" as="textarea" rows={3} placeholder="notes" onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, notes: event.target.value })) }} />
                                </Col>
                            </Row>
                        </Form.Group>
                        <Form.Group>
                            <Row>
                                <Col><Form.Label>Manufacturer</Form.Label></Col>
                                <Col><Form.Label>Sku</Form.Label></Col>
                            </Row>
                            <Row>
                                <Col>
                                    <Form.Control as="select" id="manufacturer" placeholder="manufacturer" onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, manufacturer: event.target.value })) }}>
                                        <option value={0}>Select a Manufacturer</option>
                                        {manufacturers.sort((a, b) => a.name.localeCompare(b.name)).map((i) =>
                                        {
                                            return <option key={i.id} value={i.id}>{i.name}</option>
                                        })}
                                    </Form.Control>
                                </Col>
                                <Col><Form.Control id="sku" placeholder="sku" onChange={(event) => { setNewRollingStock((previous) => ({ ...previous, sku: event.target.value })) }} /></Col>
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

export default AddRollingStock;