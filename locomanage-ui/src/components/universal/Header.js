import React from "react";
import { Link } from "react-router-dom";
import { Navbar, Nav } from "react-bootstrap";

const Header = () =>
{
	return (
		<header>
			<Navbar sticky="top">
				<Navbar.Brand>
					<Link to="/">LocoManage</Link>
				</Navbar.Brand>
				<Nav fill variant="tabs" className="justify-content-end">
					<Nav.Link>
						<Link to="/">Home</Link>
					</Nav.Link>

					<Nav.Link>
						<Link to="./about-us">
							About Us
						</Link>
					</Nav.Link>

					<Nav.Link>
						<Link to="./sign-in">
							Sign In
						</Link>
					</Nav.Link>

					<Nav.Link>
						<Link to="./my-inventory" id="myInventory">
							My Inventory
						</Link>
					</Nav.Link>

					<Nav.Link>
						<Link to="./layout" id="layout">
							Layout
						</Link>
					</Nav.Link>

					<Nav.Link>
						<Link to="./chain-builder" id="chainBuilder">
							Chain Builder
						</Link>
					</Nav.Link>


				</Nav>
			</Navbar>
		</header >
	);
};

export default Header;
