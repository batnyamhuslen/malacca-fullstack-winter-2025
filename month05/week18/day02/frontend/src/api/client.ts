// src/api/client.ts

const BASE_URL = 'http://localhost:8080/api';

export async function get<T>(path: string): Promise<T> {
    const response = await fetch(`${BASE_URL}${path}`);
    if (!response.ok) throw new Error(`HTTP ${response.status}: ${path}`);
    return response.json() as Promise<T>;
}

export async function post<TBody, TResponse>(
    path: string,
    body: TBody
): Promise<TResponse> {
    const response = await fetch(`${BASE_URL}${path}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    });
    if (!response.ok) {
        const error = await response.json();
        throw new Error(JSON.stringify(error));
    }
    return response.json() as Promise<TResponse>;
}

export async function put<TBody, TResponse>(
    path: string,
    body: TBody
): Promise<TResponse> {
    const response = await fetch(`${BASE_URL}${path}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    });
    if (!response.ok) throw new Error(`HTTP ${response.status}`);
    return response.json() as Promise<TResponse>;
}

export async function del(path: string): Promise<void> {
    const response = await fetch(`${BASE_URL}${path}`, { method: 'DELETE' });
    if (!response.ok) throw new Error(`HTTP ${response.status}`);
}