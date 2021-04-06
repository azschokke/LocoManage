import React, { useEffect, useState } from "react";
import { Card, Accordion, ListGroup, Row, Col } from "react-bootstrap"
import { GET } from "../../util/apiCommunication";
import AddManufacturer from "../forms/AddManufacturer";
import AddClassification from "../forms/AddClassification";
import AddRailroad from "../forms/AddRailroad";
import EditClassification from "../forms/EditClassification";
import EditManufacturer from "../forms/EditManufacturer";
import EditRailroad from "../forms/EditRailroad";

const AddChain = () => 
{
    const [scales, setScales] = useState([]);
    const [manufacturers, setManufacturers] = useState([]);
    const [classifications, setClassifications] = useState([]);
    const [railroads, setRailroads] = useState([]);

    useEffect(() =>
    {
        GET("scale/all", setScales);
        GET("manufacturer/all", setManufacturers);
        GET("classification/all", setClassifications);
        GET("railroad/all", setRailroads);
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <>
            <Accordion>
                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey="8">
                        Classification
                                </Accordion.Toggle>
                    <Accordion.Collapse eventKey="8">
                        <Card.Body>
                            <ListGroup>
                                {classifications.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                {
                                    return <EditClassification key={`classificationDisplay${i.id}`} data={i} setter={setClassifications}></EditClassification>
                                })}
                            </ListGroup>
                            <br />
                            <AddClassification setter={setClassifications}></AddClassification>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>

                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey="7">
                        <Row>
                            <Col>Manufacturers</Col>
                        </Row></Accordion.Toggle>
                    <Accordion.Collapse eventKey="7">
                        <Card.Body>
                            <ListGroup>
                                {manufacturers.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                {
                                    return <EditManufacturer key={`manufacturerDisplay${i.id}`} data={i} setter={setManufacturers}></EditManufacturer>
                                })}
                            </ListGroup>
                            <br />
                            <AddManufacturer setter={setManufacturers}></AddManufacturer>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>

                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey="9">
                        <Row>
                            <Col>
                                Railroads
                            </Col>
                        </Row>
                    </Accordion.Toggle>
                    <Accordion.Collapse eventKey="9">
                        <Card.Body>
                            <ListGroup>
                                <ListGroup>
                                    {railroads.sort((a, b) => a.name.localeCompare(b.name)).map((i) =>
                                    {
                                        return <EditRailroad key={`railroadDisplay${i.id}`} data={i} setter={setRailroads}></EditRailroad>
                                    })}
                                </ListGroup>
                            </ListGroup>
                            <br />
                            <AddRailroad setter={setRailroads}></AddRailroad>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>

                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey="6"> Scales </Accordion.Toggle>
                    <Accordion.Collapse eventKey="6">
                        <Card.Body>
                            <ListGroup horizontal>
                                {scales.map((i) =>
                                {
                                    return <ListGroup.Item key={`scaleCard${i.id}`}>{i.name}</ListGroup.Item>
                                })}
                            </ListGroup>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>

            </Accordion>
        </>
    );
};

export default AddChain;