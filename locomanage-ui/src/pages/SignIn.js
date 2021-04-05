import React from "react";
import Page from "../components/universal/Page"
import { Form, Button } from "react-bootstrap";

const SignIn = () => 
{
    function signUp()
    {
        console.log("sign up ");
        console.log(document.querySelector("#signUp #username").value);
        console.log(document.querySelector("#signUp #password").value);
    }

    function signIn()
    {
        console.log("sign in");
        console.log(document.querySelector("#signIn #username").value);
        console.log(document.querySelector("#signIn #password").value);
    }

    return (
        <Page>
            <div className="main" id="sign_in">
                <div id="existing_user">
                    <Form id="signIn">
                        <h1>Sign In</h1>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="text" name="username" id="username" placeholder="Username" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" name="password" id="password" placeholder="Password" />
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
                            <Form.Control type="text" name="name" id="enter_name" placeholder="Name" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" name="email" id="enter_email" placeholder="Email" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="text" name="username" id="create_username" placeholder="Create a Username" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" name="password" id="password" placeholder="Create a Password" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label></Form.Label>
                            <Form.Control type="password" name="cpassword" id="cpassword" placeholder="Confirm Your Password" />
                        </Form.Group>
                        <Button id="submit" onClick={signUp}>Sign Up</Button>
                    </Form>
                </div>

            </div>
        </Page>);
};

export default SignIn;