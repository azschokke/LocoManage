import React from "react";
import { Accordion, Card } from "react-bootstrap";
import RollingStockTable from "./RollingStockTable";

const ChainDisplay = (props) =>
{
    if (props.chain === undefined || props.chain === null)
    {
        return "";
    }
    else
    {
        return (
            <Accordion>
                <Card>
                    <Accordion.Toggle as={Card.header} eventKey={`${props.keyName}${props.chain.id}`}>
                        {props.chain.name}
                    </Accordion.Toggle>
                    <Accordion.Collapse eventKey={`${props.keyName}${props.chain.id}`}>
                        <Card.Body>
                            <RollingStockTable stockList={props.chain.cars}></RollingStockTable>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>
            </Accordion>
        );
    }//end else
}//end ChainDisplay

export default ChainDisplay;