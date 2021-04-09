import React from "react";
import { Link } from "react-router-dom";
import { Navbar, Nav } from "react-bootstrap";

const Header = () =>
{
	const getLinks = () =>
	{
		console.log(window.localStorage.getItem("username"));
		console.log(window.localStorage.getItem("userId"));
		if (window.localStorage.getItem("username") === null)
		{
			return (
				<div fill>
					<Nav>
						<Nav.Link>
							<Link to="/">Home</Link>
						</Nav.Link>
						<Nav.Link>
							<Link to="./sign-in">
								Sign In
					</Link>
						</Nav.Link>
					</Nav>
				</div>
			);
		}//end if
		else
		{
			return (
				<>
					<div fill>
						<Nav fill>
							<Nav.Link>
								<Link to="/">Home</Link>
							</Nav.Link>

							<Nav.Link>
								<Link to="./inventory" id="inventory">
									Inventory
								</Link>
							</Nav.Link>

							<Nav.Link>
								<Link to="./locations" id="locations">
									Locations
								</Link>
							</Nav.Link>

							<Nav.Link>
								<Link to="./chain-builder" id="chainBuilder">
									Chain Builder
								</Link>
							</Nav.Link>

							<Nav.Link>
								<Link to="./layout" id="layout">
									Layout
								</Link>
							</Nav.Link>

							<Nav.Link>
								<Link to="./" onClick={() => { window.localStorage.removeItem("username"); window.localStorage.removeItem("userId"); }}>
									Sign Out
								</Link>
							</Nav.Link>
						</Nav>
					</div>

					<Navbar.Collapse className="justify-content-end">
						<Navbar.Text style={{ color: "white" }}>Welcome, {window.localStorage.getItem("username")}!</Navbar.Text>
					</Navbar.Collapse>
				</>);
		}
	}

	return (
		<header>
			<Navbar sticky="top">
				<Navbar.Brand>
					<Link to="/">LocoManage</Link>
				</Navbar.Brand>
				{getLinks()}
			</Navbar>
		</header >
	);
};

export default Header;