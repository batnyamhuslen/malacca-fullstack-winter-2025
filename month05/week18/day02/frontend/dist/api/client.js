// src/api/client.ts
const BASE_URL = 'http://localhost:8080/api';
export async function get(path) {
    const response = await fetch(`${BASE_URL}${path}`);
    if (!response.ok)
        throw new Error(`HTTP ${response.status}: ${path}`);
    return response.json();
}
export async function post(path, body) {
    const response = await fetch(`${BASE_URL}${path}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    });
    if (!response.ok) {
        const error = await response.json();
        throw new Error(JSON.stringify(error));
    }
    return response.json();
}
export async function put(path, body) {
    const response = await fetch(`${BASE_URL}${path}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    });
    if (!response.ok)
        throw new Error(`HTTP ${response.status}`);
    return response.json();
}
export async function del(path) {
    const response = await fetch(`${BASE_URL}${path}`, { method: 'DELETE' });
    if (!response.ok)
        throw new Error(`HTTP ${response.status}`);
}
