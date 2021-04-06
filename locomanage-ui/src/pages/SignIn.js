import React, { useState } from "react";
import Page from "../components/universal/Page"
import { Form, Button } from "react-bootstrap";
import { POST, LOGIN } from "../util/apiCommunication"

const SignIn = (props) => 
{
    const [newUser, setNewUser] = useState({ user_name: null, email: null, username: null, password: null, confirmPassword: null });
    const [existingUser, setExistingUser] = useState({ username: null, password: null });
    function signUp()
    {
        console.log("sign up ");
        console.log(newUser);
        POST("user/add", JSON.stringify(newUser));
    }

    function signIn()
    {
        console.log("sign in");
        console.log(existingUser);
        LOGIN(JSON.stringify(existingUser));
    }

    return (
        <Page>
            <div className="main" id="sign_in">
                <div id="existing_user">
                    <Form id="signIn">
                        <h1>Sign In</h1>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="text" name="username" id="username" placeholder="Username" onChange={(event) => { setExistingUser((previous) => ({ ...previous, username: event.target.value })) }} />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" name="password" id="password" placeholder="Password" onChange={(event) => { setExistingUser((previous) => ({ ...previous, password: event.target.value })) }} />
                        </Form.Group>
                        <Button id="submit" onClick={signIn}>Sign In</Button>
                        <p onClick={() => alert("tough")}>Forgot username?</p>
                        <p onClick={() => alert("tough")}>Forgot password?</p>
                    </Form>
                </div>

                <div id="new_user">
                    <Form id="signUp">
                        <h1>Create Account</h1>
                        <Form.Group>
                            <Form.Label>Name</Form.Label>
                            <Form.Control type="text" name="name" id="enter_name" placeholder="Name"
                                onChange={(event) => { setNewUser((previous) => ({ ...previous, user_name: event.target.value })) }} />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" name="email" id="enter_email" placeholder="Email"
                                onChange={(event) => { setNewUser((previous) => ({ ...previous, email: event.target.value })) }} />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="text" name="username" id="create_username" placeholder="Create a Username"
                                onChange={(event) => { setNewUser((previous) => ({ ...previous, username: event.target.value })) }} />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" name="password" id="password" placeholder="Create a Password"
                                onChange={(event) => { setNewUser((previous) => ({ ...previous, password: event.target.value })) }} />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label></Form.Label>
                            <Form.Control type="password" name="cpassword" id="cpassword" placeholder="Confirm Your Password"
                                onChange={(event) => { setNewUser((previous) => ({ ...previous, confirmPassword: event.target.value })) }} />
                        </Form.Group>
                        <Button id="submit" onClick={signUp}>Sign Up</Button>
                    </Form>
                </div>

            </div>
        </Page>);
};

export default SignIn;