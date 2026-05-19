// src/types/models.ts
export interface Film {
    film_id:      number;
    title:        string;
    rating:       string;
    rental_rate:  number;
    description?: string;
}

export interface Actor {
    actor_id:   number;
    first_name: string;
    last_name:  string;
}

export interface Category {
    category_id: number;
    name:        string;
}