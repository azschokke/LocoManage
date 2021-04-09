const base = "http://localhost:8080/locomanage/";

export function GET(path, setter)
{
    console.log(base + path);
    console.log(setter);
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
        GET(entity + `/getRoots/${window.localStorage.getItem("userId")}`, setter);
    }
    else
    {
        GET(entity + `/all`, setter);
    }
}//end UPDATE

export async function LOGIN(user)
{
    let response = await fetch(base + "user/login", { method: 'POST', body: JSON.stringify(user) });
    console.log(response);
    await response.json().then((data) =>
    {
        if (data === false)
        {
            alert("Invalid login.");
        }//end if
        else
        {
            window.localStorage.setItem("username", user.username);
            window.localStorage.setItem("userId", data);
            window.location = "/inventory";
        }//end else
    });

}//end LOGIN