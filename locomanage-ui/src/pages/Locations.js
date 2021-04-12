import React, { useState, useEffect } from "react";
import { Accordion, Card } from "react-bootstrap";
import { GET } from "../util/apiCommunication";
import Page from "../components/universal/Page";
import LocationRender from "../components/data/LocationRender";
import AddLocation from "../components/forms/AddLocation";

const Locations = () =>
{
    const [locations, setLocations] = useState([]);

    useEffect(() => 
    {
        GET(`location/getRoots/${window.localStorage.getItem("userId")}`, setLocations);
    }, []);

    return (
        <Page>
            <h1>Location Manager</h1>
            <Accordion>
                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey="0">Locations</Accordion.Toggle>
                    <Accordion.Collapse eventKey="0">
                        <Card.Body>
                            {
                                locations.map((i) => <LocationRender key={`loc${i.id}`} location={i} layout={false}></LocationRender>)
                            }
                            <br />
                            <AddLocation setter={setLocations} locations={locations}></AddLocation>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>
            </Accordion>
        </Page>
    );
};

export default Locations;