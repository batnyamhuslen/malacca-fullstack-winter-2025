// src/api/filmApi.ts
import { get, post, put, del } from './client.js';

interface Film {
    film_id: number;
    title: string;
    rating: string;
    rental_rate: number;
    description?: string;
    rental_duration: number;
}

type CreateFilmDto = Omit<Film, 'film_id'>;
type UpdateFilmDto = Partial<Omit<Film, 'film_id'>>;

export async function fetchFilms(): Promise<Film[]> {
    return await get<Film[]>('/api/films'); // client.ts өөрөө цаанаа /api-тай тул энд /films гэвэл илүү цэвэр
}

export async function fetchFilmById(id: number): Promise<Film> {
    return await get<Film>(`/api/films/${id}`);
}

export async function createFilm(data: CreateFilmDto): Promise<Film> {
    // 1-р generic: TBody (CreateFilmDto)
    // 2-р generic: TResponse (Film)
    return await post<CreateFilmDto, Film>('/api/films', data);
}

export async function updateFilm(id: number, data: UpdateFilmDto): Promise<Film> {

    return await put<UpdateFilmDto, Film>(`/api/films/${id}`, data);
}

export async function deleteFilm(id: number): Promise<void> {
    return await del(`/api/films/${id}`); 
}