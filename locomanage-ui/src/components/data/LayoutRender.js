import React, { useEffect, useState } from "react";
import { Card, Accordion } from "react-bootstrap";
import { GET } from "../../util/apiCommunication";
import ChainDisplay from "./ChainDisplay";

const LayoutRender = (props) => 
{
    const [trackChains, setTrackChains] = useState([]);

    useEffect(() =>
    {
        if (props.location.isTrack)
        {
            GET(`chain/byTrack/${props.location.id}`, setTrackChains);
        }
        //eslint-disable-next-line
    }, [])
    console.log("Layout Render");
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
                                        console.log(props.location.id + "is not a track");
                                        return (<LayoutRender key={`loc${child.id}`} location={child}></LayoutRender>);
                                    }))
                                    : /*else*/
                                    trackChains.map((i) => <ChainDisplay keyName={"layoutChain"} chain={i}></ChainDisplay>)
                            }
                        </Card.Body>
                    </Accordion.Collapse >
                </Card >
            </Accordion >
        </>
    );

}

export default LayoutRender;