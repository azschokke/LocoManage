const base = "http://localhost:8080/locomanage/";

export function GET(path, setter)
{
    return fetch(base + path).then((response) => response.json().then((data) => setter(data)));
}

export function POST(path, data)
{
    return fetch(base + path, { method: 'POST', mode: 'no-cors', body: data });
}

export async function UPDATE(entity, goal, data, setter)
{
    // eslint-disable-next-line
    const response = await POST(entity + "/" + goal, data);
    if (entity === "location")
    {
        GET(entity + "/getRoots", setter);
    }
    else
    {
        GET(entity + "/all", setter);
    }
}//end UPDATE

export async function LOGIN(user)
{
    let response = await fetch(base + "user/login", { method: 'POST', body: JSON.stringify(user) });
    console.log(response);
    await response.json().then((data) =>
    {
        if (data)
        {
            console.log(user.username);
            document.cookie = `username=${user.username}; path="/";`;
            window.location = "/my-inventory";
        }//end if
        else
        {
            alert("Invalid login.");
        }//end else
    });

}//end LOGIN