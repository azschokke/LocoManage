import React, { useState } from "react";
import { Table, Button } from "react-bootstrap";

const RollingStockTable = (props) =>
{
    console.log("rolling stock table");
    console.log(props.stockList);
    const [previousSort, setPreviousSort] = useState();
    // const [stock, setStock] = useState([]);

    // eslint-disable-next-line react-hooks/exhaustive-deps
    // useEffect(() => { setStock(props.stockList); console.log(props.add); console.log(stock) }, []);

    function sort(sortType)
    {
        if (props.setter !== undefined)
        {


            console.log("sort type: " + sortType);
            console.log(previousSort);
            const swap = ((previousSort === sortType) ? -1 : 1);
            console.log(swap);
            switch (sortType)
            {
                //sort by owner (railroad name)
                case "r":
                    //set train to sorted copy of previous train
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => a.owner.name.localeCompare(b.owner.name) * swap));
                    break;
                //sort by car number
                case "n":
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => (a.carNumber - b.carNumber) * swap));
                    break;
                //sort by length
                case "l":
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => (a.length - b.length) * swap));
                    break;
                //sort by model
                case "m":
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => a.model.name.localeCompare(b.model.name) * swap));
                    break;
                //sort by classificaiton
                case "c":
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => a.model.classification.name.localeCompare(b.model.classification.name) * swap));
                    break;
                //sort by scale
                case "s":
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => (a.productInfo.scale.id - b.productInfo.scale.id) * swap));
                    break;
                //sort by manufacturer
                case "pm":
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => a.productInfo.manufacturer.name.localeCompare(b.productInfo.manufacturer.name) * swap));
                    break;
                //sort by sku
                case "ps":
                    props.setter((previousTrain) => previousTrain.slice().sort((a, b) => (a.productInfo.sku.localeCompare(b.productInfo.sku)) * swap));
                    break;
                default:
                    return;
            }//end switch
            if (swap === -1)
            {
                setPreviousSort("");
            }
            else
            {
                setPreviousSort(sortType);
            }
        }

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
                {(props.stockList === undefined) ? "" : props.stockList.map((i) =>
                {
                    return <tr key={`rs${i.id}` + ((props.chain) ? "a" : "e")}>
                        <td key={`action${i.id}`} ><Button id={i.id} onClick={props.userAction}>{(props.chain) ? "Add" : "Edit"}</Button></td>
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