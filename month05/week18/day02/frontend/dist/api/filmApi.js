// src/api/filmApi.ts
import { get, post, put, del } from './client.js';
export async function fetchFilms() {
    return await get('/api/films'); // client.ts өөрөө цаанаа /api-тай тул энд /films гэвэл илүү цэвэр
}
export async function fetchFilmById(id) {
    return await get(`/api/films/${id}`);
}
export async function createFilm(data) {
    // 1-р generic: TBody (CreateFilmDto)
    // 2-р generic: TResponse (Film)
    return await post('/api/films', data);
}
export async function updateFilm(id, data) {
    return await put(`/api/films/${id}`, data);
}
export async function deleteFilm(id) {
    return await del(`/api/films/${id}`);
}
