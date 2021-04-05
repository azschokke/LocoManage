import React from "react";
import { Accordion, Card } from "react-bootstrap";
import Page from "../components/universal/Page";
import AddRollingStock from "../components/forms/AddRollingStock";
import RollingStockTable from "../components/data/RollingStockTable";
import AddLocation from "../components/forms/AddLocation";
import CategoryAccordion from "../components/data/CategoryAccordion";
import LocationRender from "../components/data/LocationRender";
import { useEffect, useState } from "react";
import { GET } from "../util/apiCommunication";

const MyInventory = () => 
{
    const [locations, setLocations] = useState([]);
    const [stock, setStock] = useState([]);

    useEffect(() =>
    {
        GET("location/getRoots", setLocations);
        GET("rollingStock/all", setStock);
    }, []);
    return (
        <Page>
            <div className="main">
                <h1>Your Inventory</h1>
                <Accordion>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey="0">Locations</Accordion.Toggle>
                        <Accordion.Collapse eventKey="0">
                            <Card.Body>
                                {
                                    locations.map((i) => <LocationRender key={`loc${i.id}`} location={i}></LocationRender>)
                                }
                                <br />
                                <AddLocation></AddLocation>
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey="3">Rolling Stock</Accordion.Toggle>
                        <Accordion.Collapse eventKey="3">
                            <Card.Body>

                                <RollingStockTable stockList={stock} add={false}></RollingStockTable>
                                <AddRollingStock></AddRollingStock>
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


            </div>
        </Page>);
};

export default MyInventory;