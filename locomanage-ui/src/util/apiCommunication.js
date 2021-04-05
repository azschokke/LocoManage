const base = "http://192.168.1.10:8080/locomanage/";

export function GET(path, setter)
{
    return fetch(base + path).then((response) => response.json().then((data) => setter(data)));
}

export function POST(path, data)
{
    return fetch(base + path, { method: 'POST', body: data });
}