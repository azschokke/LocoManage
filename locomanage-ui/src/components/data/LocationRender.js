import React, { useState } from "react";
import { Card, Accordion } from "react-bootstrap";
import { GET } from "../../util/apiCommunication";
import RollingStockTable from "../data/RollingStockTable";

const LocationRender = (props) => 
{
    console.log("Location Render");
    console.log(props.location.id);

    return (
        <>
            <Accordion>
                <Card>
                    <Accordion.Toggle as={Card.Header} eventKey={`loc${props.location.id}`}>
                        {props.location.name}
                    </Accordion.Toggle>
                    <Accordion.Collapse eventKey={`loc${props.location.id}`}>
                        <Card.Body>
                            {
                                (!props.location.isTrack)
                                    ? /* if */
                                    (props.location.children.sort((a, b) => a.name.localeCompare(b.name)).map((child) =>
                                    {
                                        console.log("not a track");
                                        return (<LocationRender key={`loc${child.id}`} location={child} layout={props.layout}></LocationRender>);
                                    }))
                                    : /*else*/
                                    (!props.layout)
                                        ?
                                        "Track"
                                        :
                                        fetch(`http://localhost:8080/locomanage/chain/byTrack/${props.location.id}`).then((response) => response.json().then((data) => 
                                        {
                                            console.log(data);
                                            if (!props.layout)
                                            {
                                                return "Empty Track";
                                            }
                                            else
                                            {
                                                data.map((chain) =>  
                                                {
                                                    console.log(chain);
                                                    return (
                                                        <>
                                                            <Accordion>
                                                                <Card>
                                                                    <Accordion.Toggle as={Card.header} eventKey={`chain${chain.id}`}>
                                                                        {chain.name}
                                                                    </Accordion.Toggle>
                                                                    <Accordion.Collapse eventKey={`chain${chain.id}`}>
                                                                        <RollingStockTable stockList={chain.cars}></RollingStockTable>
                                                                    </Accordion.Collapse>
                                                                </Card>
                                                            </Accordion>
                                                        </>);
                                                });
                                            }//end else
                                        }))
                            }
                        </Card.Body>
                    </Accordion.Collapse >
                </Card >
            </Accordion >
        </>
    );

}

export default LocationRender;