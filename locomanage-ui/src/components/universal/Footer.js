import React from "react";
import { Navbar } from "react-bootstrap";

const Footer = () =>
{
    return (
        <Navbar fixed="bottom">
            <footer>
                <p>Thanks for visiting!</p>
                <p>Check us out on <a href="https://azschokke.github.io/" target="_blank" rel="noreferrer">Github</a>!</p>
                <p><a href="mailto:alicen.zschokke@gmail.com?subject=LocoManage%20SBA">Email Us!</a></p>
            </footer>
        </Navbar>);
};

export default Footer;