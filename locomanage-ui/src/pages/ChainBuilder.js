import React, { useEffect, useState } from "react";
import { Accordion, Card } from "react-bootstrap";
import Page from "../components/universal/Page";
import { GET } from "../util/apiCommunication";
import AddTrain from "../components/forms/AddTrain";
import AddChain from "../components/forms/AddChain";
import RollingStockTable from "../components/data/RollingStockTable";

const ChainBuilder = () =>
{
    // const [railroads, setRailroads] = useState([]);
    const [stock, setStock] = useState([]);
    const [newChain, setNewChain] = useState([]);
    const [chains, setChains] = useState([]);
    // console.log("chain builder");
    const changeChain = (event) =>
    {
        console.log("add to chain");
        console.log(event.target.id);
        setNewChain((previous) => 
        {
            if (!previous.includes(event.target.id))
            {
                previous.push(event.target.id);
                event.target.innerText = "Remove";
            }
            else
            {
                previous.splice(previous.indexOf(event.target.id), 1);
                event.target.innerText = "Add";
            }

            return previous;
        });
        console.log(newChain);
    }

    useEffect(() =>
    {
        // GET("railroad/all", setRailroads);
        GET("chain/all", setChains);
        console.log(chains);
        GET("rollingStock/available", setStock);
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
                            <Card.Body>
                                {chains.map((i) => <Accordion>
                                    <Card>
                                        <Accordion.Toggle as={Card.header} eventKey={`chain${i.id}`}>
                                            {i.name}
                                        </Accordion.Toggle>
                                        <Accordion.Collapse eventKey={`chain${i.id}`}>
                                            <RollingStockTable stockList={i.cars}></RollingStockTable>
                                        </Accordion.Collapse>
                                    </Card>
                                </Accordion>)}
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                </Accordion>
                <Accordion>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey="2">Create Chain Menu</Accordion.Toggle>
                        <Accordion.Collapse eventKey="2">
                            <Card.Body>
                                {/*
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
                                            */}
                                <RollingStockTable stockList={stock} userAction={changeChain} chain={true}></RollingStockTable>
                                <AddChain stock={newChain}></AddChain>
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                </Accordion>
            </Page>
        </>
    )
}

export default ChainBuilder;