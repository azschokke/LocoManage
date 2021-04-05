import React, { useEffect, useState } from "react";
import { Card, Accordion, ListGroup, Row, Col } from "react-bootstrap"
import { GET } from "../../util/apiCommunication";
import AddManufacturer from "../forms/AddManufacturer";
import AddClassification from "../forms/AddClassification";
import AddRailroad from "../forms/AddRailroad";

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
                        <Row>
                            <Col>Classification
                                </Col>
                        </Row></Accordion.Toggle>
                    <Accordion.Collapse eventKey="8">
                        <Card.Body>
                            <ListGroup>
                                {classifications.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                {
                                    return <ListGroup.Item key={`classification${i.id}`} value={i.id}>{i.name} edit delete</ListGroup.Item>
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
                                    return <ListGroup.Item key={`manufacturer${i.id}`} value={i.id}>{i.name}</ListGroup.Item>
                                })}
                            </ListGroup>
                            <br />
                            <AddManufacturer></AddManufacturer>
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
                                {railroads.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                {
                                    return <ListGroup.Item key={`railroad${i.id}`} value={i.id}>{i.name} edit delete</ListGroup.Item>
                                })}
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