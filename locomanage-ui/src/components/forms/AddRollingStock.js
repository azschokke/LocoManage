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
        let body = "";
        console.log("save!");
        console.log("railroad: " + document.querySelector("form #railroad").value);
        console.log("car number: " + document.querySelector("form #carNumber").value);
        console.log("length: " + document.querySelector("form #length").value);
        console.log("model: " + document.querySelector("form #model").value);
        console.log("scale: " + document.querySelector("form #scale").value);
        console.log("class: " + document.querySelector("form #classification").value);
        console.log("sku: " + document.querySelector("form #sku").value);
        console.log("manufacturer: " + document.querySelector("form #manufacturer").value);
        console.log("notes: " + document.querySelector("form #notes").value);
        body = document.querySelector("form #railroad").value + "," +
            document.querySelector("form #carNumber").value + "," +
            document.querySelector("form #length").value + "," +
            document.querySelector("form #model").value + "," +
            document.querySelector("form #scale").value + "," +
            document.querySelector("form #classification").value + "," +
            document.querySelector("form #sku").value + "," +
            document.querySelector("form #manufacturer").value + "," +
            document.querySelector("form #notes").value;
        POST("rollingStock/add", body);
        console.log(body);
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
                                    <Form.Control as="select" id="railroad" placeholder="railroad" >
                                        {railroads.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                        {
                                            return <option key={i.id} value={i.id}>{i.name}</option>
                                        })}
                                    </Form.Control>
                                </Col>
                                <Col md={3}><Form.Control id="carNumber" placeholder="car number" /></Col>
                                <Col md={3}><Form.Control id="length" placeholder="length" /></Col>
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
                                    <Form.Control id="model" placeholder="model" />
                                </Col>

                                <Col md={6}>
                                    <Form.Control as="select" id="classification" placeholder="model classification">
                                        {classifications.sort((a, b) => a.name.localeCompare(b.name)).map((i) =>
                                        {
                                            return <option key={`classification${i.id}`} value={i.id}> {i.name}</option>
                                        })}
                                    </Form.Control>
                                </Col>
                                <Col md={3}>
                                    <Form.Control id="scale" as="select" placeholder="scale">
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
                                    <Form.Control id="notes" as="textarea" rows={3} placeholder="notes" />
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
                                    <Form.Control as="select" id="manufacturer" placeholder="manufacturer">
                                        {manufacturers.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                        {
                                            return <option key={i.id} value={i.id}>{i.name}</option>
                                        })}
                                    </Form.Control>
                                </Col>
                                <Col><Form.Control id="sku" placeholder="sku" /></Col>
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