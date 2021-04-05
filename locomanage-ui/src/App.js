import "./style/main.css";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import AboutUs from "./pages/AboutUs"
import SignIn from "./pages/SignIn"
import HomePage from "./pages/HomePage"
import MyInventory from "./pages/MyInventory"
import Layout from "./pages/Layout"
import ChainBuilder from "./pages/ChainBuilder"

function App()
{
	return (
		<BrowserRouter>
			<Switch>
				<Route path="/about-us">
					<AboutUs></AboutUs>
				</Route>
				<Route path="/sign-in">
					<SignIn></SignIn>
				</Route>
				<Route path="/my-inventory">
					<MyInventory></MyInventory>
				</Route>
				<Route path="/layout">
					<Layout></Layout>
				</Route>
				<Route path="/chain-builder">
					<ChainBuilder></ChainBuilder>
				</Route>
				<Route path="/">
					<HomePage></HomePage>
				</Route>
			</Switch>
		</BrowserRouter>
	);
}

export default App;
