const base = "http://localhost:8080/locomanage/";

export function GET(path, setter)
{
    return fetch(base + path).then((response) => response.json().then((data) => setter(data)));
}

export function POST(path, data)
{
    return fetch(base + path, { method: 'POST', body: data });
}

export async function UPDATE(entity, goal, data, setter)
{
    const response = await POST(entity + "/" + goal, data);
    response.json();
    if (entity === "location")
    {
        GET(entity + "/getRoots", setter);
    }
    else
    {
        GET(entity + "/all", setter);
    }
}//end UPDATE

export async function LOGIN(data)
{
    const response = await POST("user/login", data);

    response.json().then((data) =>
    {
        console.log(data.value);
        if (data.value)
        {
            window.location = "/my-inventory";
        }//end if
        else
        {
            alert("Invalid login.");
        }//end else
    });
}//end LOGIN