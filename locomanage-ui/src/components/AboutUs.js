import React, { useState, useEffect } from "react";
import { Table } from "react-bootstrap";
import { GET } from "../util/apiCommunication";

const AboutUs = () => 
{
    const [train, setTrain] = useState([]);
    const [classification, setClassification] = useState([]);
    //eslint-disable-next-line
    useEffect(() => { createTrain() }, []);
    useEffect(() =>
    {
        GET("classificationJSON", setClassification);
    }, []);

    function sort(sortType)
    {
        switch (sortType)
        {
            case "r":
                //set train to sorted copy of previous train
                setTrain((previousTrain) => previousTrain.slice().sort((a, b) => a.railroad.localeCompare(b.railroad)));
                break;
            case "m":
                setTrain((previousTrain) => previousTrain.slice().sort((a, b) => a.modelName.localeCompare(b.modelName)));
                break;
            case "t":
                setTrain((previousTrain) => previousTrain.slice().sort((a, b) => a.type.localeCompare(b.type)));
                break;
            case "y":
                setTrain((previousTrain) => previousTrain.slice().sort((a, b) => a.year - b.year));
                break;
            case "s":
                setTrain((previousTrain) => previousTrain.slice().sort((a, b) => 
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
                console.log(train);
                break;
            case "c":
                setTrain((previousTrain) => previousTrain.slice().sort((a, b) => a.number - b.number));
                break;
            default:
                return;
        }//end switch
        // console.log(train);
    }//end sort

    function Train(railroad, modelName, type, year, scale, number)
    {
        this.railroad = railroad;
        this.modelName = modelName;
        this.type = type;
        this.year = year;
        this.scale = scale;
        this.number = number;
    }//end Train

    function createTrain()
    {
        var railways = ["Canadian National", "Amtrak", "BNSF", "Canadian Pacific", "CSX", "Kansas City Southern", "Norfolk Southern", "Union Pacific"];
        var typesOfCars = ["Box Car", "Passenger", "Gondola", "Engine", "Dining Car"];
        var carModelTypes = ["BC", "P", "G", "E", "DC"];
        var scales = ["Z", "N", "HO", "O", "G"];
        var trainCars = [];

        console.log("making train");
        for (var i = 0; i < 20; i++)
        {
            var carType = Math.floor(Math.random() * typesOfCars.length)
            var car = new Train();
            car.railroad = railways[Math.floor(Math.random() * railways.length)];
            car.type = typesOfCars[carType];
            car.scale = scales[Math.floor(Math.random() * scales.length)];
            car.modelName = carModelTypes[carType] + "-" + Math.floor((Math.random() * 10000) + 10000);
            car.number = Math.floor((Math.random() * 1000) + 1000);
            car.year = Math.floor((Math.random() * 217) + 1804);
            trainCars.push(car);
        }//end for
        setTrain(trainCars);
    }//end createTrain

    return (
        <div className="main">
            <h1>About Us</h1>
            <p>We provide a system for tracking all of your model trains online!</p>
            <h3>Sample Table</h3>
            {console.log(classification)}
            <Table id="trainTable" striped hover size="md">
                <thead>
                    <tr key="trainTableHeaders">
                        <th key="trainTableHeaderRr" onClick={() => sort("r")}>Railroad</th>
                        <th key="trainTableHeaderMN" onClick={() => sort("m")}>Model Name</th>
                        <th key="trainTableHeaderT" onClick={() => sort("t")}>Type</th>
                        <th key="trainTableHeaderY" onClick={() => sort("y")}>Year</th>
                        <th key="trainTableHeaderS" onClick={() => sort("s")}>Scale</th>
                        <th key="trainTableHeaderCN" onClick={() => sort("c")}>Car Number</th>
                    </tr>
                </thead>
                <tbody id="tableContent">
                    {train.map((i, index) =>
                    {
                        return <tr key={`trainTableRow${index}`}>
                            <td key={`trainTableRow${index}Rr`}>{i.railroad}</td>
                            <td key={`trainTableRow${index}MN`}>{i.modelName}</td>
                            <td key={`trainTableRow${index}T`}>{i.type}</td>
                            <td key={`trainTableRow${index}Y`}>{i.year}</td>
                            <td key={`trainTableRow${index}S`}>{i.scale}</td>
                            <td key={`trainTableRow${index}N`}>{i.number}</td>
                        </tr>
                    })}
                </tbody>
            </Table>
        </div>);
};

export default AboutUs;