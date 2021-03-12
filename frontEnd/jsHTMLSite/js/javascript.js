var isSignedIn = false; 
console.log("hello world");
function checkSignedIn()
{
    if(isSignedIn)
    {
        document.getElementById("signIn").innerHTML = "My Account";
        document.getElementById("signIn").href = "./myAccount.html";
    }
    
}//end checkSignedIn

function newUser()
{
    isSignedIn = true; 
}

function signIn()
{
    isSignedIn = true; 
}