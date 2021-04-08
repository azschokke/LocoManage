import React from "react";
import { Accordion, Card } from "react-bootstrap";
import Page from "../components/universal/Page";
import AddRollingStock from "../components/forms/AddRollingStock";
import RollingStockTable from "../components/data/RollingStockTable";
import CategoryAccordion from "../components/data/CategoryAccordion";
import { useEffect, useState } from "react";
import { GET } from "../util/apiCommunication";

const Inventory = () => 
{
    const [stock, setStock] = useState([]);

    useEffect(() =>
    {
        GET(`rollingStock/all/${window.localStorage.getItem("userId")}`, setStock);
    }, []);
    return (
        <Page>
            <h1>Your Inventory</h1>
            <Accordion>
                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey="3">Rolling Stock</Accordion.Toggle>
                    <Accordion.Collapse eventKey="3">
                        <Card.Body>

                            <RollingStockTable stockList={stock} add={false}></RollingStockTable>
                            <AddRollingStock setter={setStock}></AddRollingStock>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>
                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey="4">Categories</Accordion.Toggle>
                    <Accordion.Collapse eventKey="4">
                        <Card.Body>
                            <CategoryAccordion></CategoryAccordion>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>
            </Accordion>
        </Page>);
};

export default Inventory;