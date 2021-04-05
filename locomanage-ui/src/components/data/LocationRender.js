import React from "react";
import { Card, Accordion } from "react-bootstrap"

const LocationRender = (props) => 
{
    // console.log("Location Render");
    // console.log(props);

    if (!props.location.isTrack)
    {
        return (
            <>
                <Accordion>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey={`loc${props.location.id}`}>
                            {props.location.name}
                        </Accordion.Toggle>
                        <Accordion.Collapse eventKey={`loc${props.location.id}`}>
                            <Card.Body>
                                {props.location.children.sort((a, b) => a.name.localeCompare(b.name)).map((child) =>
                                {
                                    return (<LocationRender key={`loc${child.id}`} location={child}></LocationRender>);
                                })}
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                </Accordion>
            </>
        );
    }
    else
    {
        return (
            <>
                <Accordion>
                    <Card>
                        <Accordion.Toggle as={Card.Header} eventKey={`loc${props.location.id}`}>
                            {props.location.name}
                        </Accordion.Toggle>
                        <Accordion.Collapse eventKey={`loc${props.location.id}`}>
                            <Card.Body>
                                "I'm a track."
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                </Accordion>
            </>
        );
    }

};

export default LocationRender;