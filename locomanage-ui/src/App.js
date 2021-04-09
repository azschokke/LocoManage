import "./style/main.css";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import SignIn from "./pages/SignIn"
import HomePage from "./pages/HomePage"
import Inventory from "./pages/Inventory"
import Layout from "./pages/Layout"
import ChainBuilder from "./pages/ChainBuilder"
import Locations from "./pages/Locations";

function App()
{
	return (
		<BrowserRouter>
			<Switch>
				<Route path="/sign-in">
					<SignIn></SignIn>
				</Route>
				<Route path="/inventory">
					<Inventory></Inventory>
				</Route>
				<Route path="/layout">
					<Layout></Layout>
				</Route>
				<Route path="/chain-builder">
					<ChainBuilder></ChainBuilder>
				</Route>
				<Route path="/locations">
					<Locations></Locations>
				</Route>
				<Route path="/">
					<HomePage></HomePage>
				</Route>
			</Switch>
		</BrowserRouter>
	);
}

export default App;
