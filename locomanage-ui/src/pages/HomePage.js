import React from "react";
import Page from "../components/universal/Page"

const HomePage = () => 
{
    return (<Page>
        <div className="main">
            <h1>Welcome to LocoManage!</h1>
            <p>LocoManage is an easy-to-use online tool for managing your model train stock!</p>

            <p>Enter information about your rolling stock into a table, where you can then sort by category, add them to chains of cars, and model your layout using our location tools.</p>

            <img className="gif" src="https://media.giphy.com/media/hqm2bYw6pY3F1ylAWg/giphy.gif" alt="a gif from the PBS kids show 'Dinosaur Train' shows a train styled to look like a dinosaur rolling down the track through a forest." />
        </div>
    </Page>);
};
export default HomePage;