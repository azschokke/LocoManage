import React from "react";
import { Card, Accordion } from "react-bootstrap"

const LocationRender = (props) => 
{
    console.log("Location Render");

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
                                        return (<LocationRender key={`loc${child.id}`} location={child}></LocationRender>);
                                    }))
                                    : /*else*/
                                    (props.chains === undefined)
                                        ? /* if */
                                        "I'm a track!"
                                        : /*else*/
                                        "do chain stuff"
                            }
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>
            </Accordion>
        </>
    );

};

export default LocationRender;