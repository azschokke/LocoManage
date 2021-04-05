import React, { useEffect, useState } from "react";
import { Accordion, Card, Form } from "react-bootstrap";
import Page from "../components/universal/Page";
import { GET } from "../util/apiCommunication";
import AddTrain from "../components/forms/AddTrain";

const TrainBuilder = () =>
{
    const [railroads, setRailroads] = useState([]);
    console.log("chain builder");

    useEffect(() =>
    {
        GET("railroad/all", setRailroads);
    }, []);
    return (
        <>
            <Page>
                <h1>Chain Builder</h1>
                <Accordion>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey="0">Train View</Accordion.Toggle>
                        <Accordion.Collapse eventKey="0">
                            <Card.Body>
                                <AddTrain></AddTrain>
                            </Card.Body>

                        </Accordion.Collapse>
                    </Card>
                </Accordion>
                <Accordion>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey="1">Chain View</Accordion.Toggle>
                        <Accordion.Collapse eventKey="1">
                            <Card.Body><p>Train shit here</p></Card.Body>
                        </Accordion.Collapse>
                    </Card>
                </Accordion>
                <Accordion>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey="2">Create Chain Menu</Accordion.Toggle>
                        <Accordion.Collapse eventKey="2">
                            <Card.Body>
                                <Form>
                                    <Form.Label>Search by:</Form.Label>
                                    <Form.Group>
                                        <Form.Label>Railroad</Form.Label>
                                        <Form.Control as="select" id="railroad" placeholder="railroad" >
                                            {railroads.sort((a, b) => a.name.localeCompare(b.name)).map((i, index) =>
                                            {
                                                return <option key={i.id} value={i.id}>{i.name}</option>
                                            })}
                                        </Form.Control>
                                    </Form.Group>
                                </Form>
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                </Accordion>
            </Page>
        </>
    )
}

export default TrainBuilder;