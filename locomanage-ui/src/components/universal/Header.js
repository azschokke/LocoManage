import React from "react";
import { Link } from "react-router-dom";
import { Navbar } from "react-bootstrap";

const Header = () =>
{
	return (
		<Navbar sticky="top">
			<header>
				<h1>
					<Link to="/">LocoManage</Link>
				</h1>
				<div className="nav_menu">
					<i className="material-icons">menu</i>
					<div className="nav_menu_content">
						<ul>
							<Link to="/">
								<li>Home</li>
							</Link>
							<Link to="./about-us">
								<li>About Us</li>
							</Link>
							<Link to="./sign-in" id="signIn">
								<li>Sign In</li>
							</Link>
							<Link to="./my-inventory" id="myInventory">
								<li>My Inventory</li>
							</Link>
							<Link to="./layout" id="layout">
								<li>Layout</li>
							</Link>
							<Link to="./chain-builder" id="chainBuilder">
								<li>Chain Builder</li>
							</Link>
						</ul>
					</div>
				</div>
			</header>
		</Navbar>
	);
};

export default Header;
