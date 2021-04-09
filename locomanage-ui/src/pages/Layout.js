import React, { useEffect, useState } from "react";
import Page from "../components/universal/Page";
import LocationRender from "../components/data/LocationRender"
import { GET } from "../util/apiCommunication";

const Layout = () =>
{
    const [locations, setLocations] = useState([]);
    console.log("layout top level");

    useEffect(() => 
    {
        GET(`location/getRoots/${window.localStorage.getItem("userId")}`, setLocations);
    }, []);
    return (
        <>
            <Page>
                <h1>Layout{locations.length > 1 ? "s" : ""}</h1>
                {
                    locations.map((i, index) => 
                    {
                        console.log(i);
                        return <LocationRender location={i} key={`layoutRoot${index}`} layout={true}></LocationRender>;
                    })
                }
            </Page>
        </>);
}

export default Layout;