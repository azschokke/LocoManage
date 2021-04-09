import React, { useEffect, useState } from "react";
import Page from "../components/universal/Page";
import LocationRender from "../components/data/LocationRender"
import { GET } from "../util/apiCommunication";

const Layout = () =>
{
    const [locations, setLocations] = useState([]);
    const [chains, setChains] = useState([]);

    useEffect(() =>
    {
        GET(`location/getRoots/${window.localStorage.getItem("userId")}`, setLocations)
        GET(`chain/getAll/${window.localStorage.getItem("userId")}`, setChains)
    }, []);
    return (<>
        <Page>
            <h1>Layout{locations.length > 1 ? "s" : ""}</h1>
            {
                locations.map((i, index) => 
                {
                    return <LocationRender location={i} key={`layoutRoot${index}`} chains={chains}></LocationRender>;
                })
            }

        </Page>
    </>);
}

export default Layout;