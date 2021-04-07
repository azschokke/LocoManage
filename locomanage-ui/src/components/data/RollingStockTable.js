import React, { useState, useEffect } from "react";
import { Table } from "react-bootstrap";

const RollingStockTable = (props) =>
{
    const [stock, setStock] = useState([]);

    // eslint-disable-next-line react-hooks/exhaustive-deps
    useEffect(() => { setStock(props.stockList); console.log(props.add); console.log(stock) }, []);

    function sort(sortType)
    {
        switch (sortType)
        {
            case "r":
                //set train to sorted copy of previous train
                setStock((previousTrain) => previousTrain.slice().sort((a, b) => a.railroad.localeCompare(b.railroad)));
                break;
            case "m":
                setStock((previousTrain) => previousTrain.slice().sort((a, b) => a.modelName.localeCompare(b.modelName)));
                break;
            case "t":
                setStock((previousTrain) => previousTrain.slice().sort((a, b) => a.type.localeCompare(b.type)));
                break;
            case "y":
                setStock((previousTrain) => previousTrain.slice().sort((a, b) => a.year - b.year));
                break;
            case "s":
                setStock((previousTrain) => previousTrain.slice().sort((a, b) => 
                {
                    let aScale;
                    let bScale;

                    switch (a.scale)
                    {
                        case "Z":
                            aScale = 0;
                            break;
                        case "N":
                            aScale = 1;
                            break;
                        case "HO":
                            aScale = 2;
                            break;
                        case "O":
                            aScale = 3;
                            break;
                        default:
                            aScale = 4;
                    }

                    switch (b.scale)
                    {
                        case "Z":
                            bScale = 0;
                            break;
                        case "N":
                            bScale = 1;
                            break;
                        case "HO":
                            bScale = 2;
                            break;
                        case "O":
                            bScale = 3;
                            break;
                        default:
                            bScale = 4;
                    }
                    return aScale - bScale;
                }));
                console.log(stock);
                break;
            case "n":
                setStock((previousTrain) => previousTrain.slice().sort((a, b) => a.number - b.number));
                break;
            default:
                return;
        }//end switch
    }//end sort

    return (
        <Table id="rollingStockTable" striped hover size="md">
            {console.log("Stock List: " + props.stockList)}
            <thead>
                <tr key="trainTableHeaders">
                    <th key="userActionHeader"></th>
                    <th key="railroadHeader" onClick={() => sort("r")}>Railroad</th>
                    <th key="carNumberHeader" onClick={() => sort("n")}>Car Number</th>
                    <th key="lengthHeader" onClick={() => sort("l")}>Length</th>
                    <th key="modelHeader" onClick={() => sort("m")}>Model</th>
                    <th key="classHeader" onClick={() => sort("c")}>Class</th>
                    <th key="scaleHeader" onClick={() => sort("s")}>Scale</th>
                    <th key="manufacturerHeader" onClick={() => sort("pm")}>Manufacturer</th>
                    <th key="trainTableHeaderY" onClick={() => sort("ps")}>Sku</th>
                </tr>
            </thead>
            <tbody id="tableContent">
                {props.stockList.map((i) =>
                {
                    return <tr key={`rs${i.id}` + ((props.chain) ? "a" : "e")}>
                        <td key={`action${i.id}`} id={i.id} onClick={props.userAction}>{(props.chain) ? "Add" : "Edit"}</td>
                        <td key={`rs${i.id}r`}>{i.owner.name}</td>
                        <td key={`rs${i.id}c`}>{i.carNumber}</td>
                        <td key={`rs${i.id}l`}>{i.length}</td>
                        <td key={`rs${i.id}m`}>{i.model.name}</td>
                        <td key={`rs${i.id}cn`}>{i.model.classification.name}</td>
                        <td key={`rs${i.id}s`}>{i.productInfo.scale.name}</td>
                        <td key={`rs${i.id}pm`}>{i.productInfo.manufacturer.name}</td>
                        <td key={`rs${i.id}ps`}>{i.productInfo.sku}</td>
                    </tr>
                })}
            </tbody>

        </Table >
    );
};

export default RollingStockTable;