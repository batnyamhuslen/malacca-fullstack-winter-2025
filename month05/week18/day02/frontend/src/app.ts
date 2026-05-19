function wrap<T>(value: T): { value: T; type: string } {
    return { value, type: typeof value };
}

function merge<T extends object, U extends object>(a: T, b: U): T & U {
    return { ...a, ...b };
}

console.log(wrap(42));
console.log(wrap("hello"));
console.log(wrap(true));

const film = {
    film_id: 1,
    title: "ACADEMY DINOSAUR"
};

const extra = {
    rating: "PG",
    rental_rate: 0.99
};

const director = {
    director: "qwer"
};

// Merge all objects
const merged = merge(merge(film, extra), director);

console.log(merged.film_id);   // (a) OK
console.log(merged.rating);    // (b) OK
console.log(merged.director);  // (c) OK

// API-аас өгөгдөл авах generic function
async function fetchData<T>(url: string): Promise<T> {      // (a) алдаа
    const response = await fetch(url);
    if (!response.ok) {
        throw Error(`HTTP ${response.status}`);    // (b) бага зэрэг дутуу
    }
    return response.json() as T;                        // (c) алдаа
}

// Generic constraint дутуу
function getFirst<T>(items: T[]): T | undefined {
    return items[0];                               // (d) боломжит асуудал
}

// keyof буруу ашиглалт
function pluck<T,K extends keyof T>(items: T[], key: K): T[K][] { // (e) алдаа
    return items.map(item => item[key]);
}


function groupBy<T, K extends keyof T>(items: T[], key: K): Record<string, T[]> {
    return items.reduce((groups, item)=>{
        const groupKey = String(item[key]);

        if(!groups[groupKey]){
            groups[groupKey] = [];
        }

        groups[groupKey].push(item);

        return groups;
    }, {} as Record <string, T[]>);
}


const result = groupBy([
    { film_id: 1, title: "ACADEMY DINOSAUR", rating: "PG" },
    { film_id: 2, title: "ACE GOLDFINGER",   rating: "G"  },
    { film_id: 3, title: "ADAPTATION HOLES", rating: "PG" },
    { film_id: 4, title: "AFFAIR PREJUDICE", rating: "G"  },
], "rating");

console.log(result);

interface ApiResponse<T> {
    data: T;
    status: number;
    message: string;
    timestamp: string;
}

interface PageResponse<T> {
    content: T[];
    totalElements: number;
    totalPages: number;
    currentPage: number;
}

interface Film {
    film_id: number;
    title: string;
    rating: string;
    rental_rate: number;
    description?: string;
    rental_duration: number;
    replacement_cost: number;
}

type A = Partial<Film>;
type B = Required<Film>;
type C = Pick<Film, "film_id" | "title" | "rating">;
type D = Omit<Film, "film_id" | "description">;
type E = Record<"G" | "PG" | "PG-13" | "R" | "NC-17", Film[]>;
type F = Partial<E>;

// Аль нь compile error гарах вэ?
const a: A = {};                              // (1)
const b: B = { film_id: 1, title: "ACADEMY DINOSAUR", rating: "PG",
               rental_rate: 0.99, description: "A Epic...", rental_duration: 6,
               replacement_cost: 20.99 };     // (2)
const c: C = { film_id: 1, title: "ACADEMY DINOSAUR", rating: "PG" };  // (3)
const d: D = { title: "ACADEMY DINOSAUR", rating: "PG",
               rental_rate: 0.99, rental_duration: 6,
               replacement_cost: 20.99 };     // (4)
const e: E = { G: [], PG: [], "PG-13": [], R: [], "NC-17": [] };  // (5)
const f: F = { G: [], PG: [], R: [] };         // (6)

// Байгаа interface
interface Film {
    film_id: number;
    title: string;
    rating: string;
    rental_rate: number;
    description?: string;
    rental_duration: number;
    replacement_cost: number;
}

// Доорхыг Utility Types ашиглан үүсгэх (шинэ interface бичихгүй!)

// 1. POST /api/films — film_id байхгүй
type CreateFilmDto = Omit<Film,'film_id'>;

// 2. PUT /api/films/{id} — film_id + зарим field өөрчлөх
type UpdateFilmDto = Pick<Film, 'film_id'> & Partial<Omit<Film, 'film_id'>>;

// 3. Жагсаалтад харуулах — film_id, title, rating, rental_rate л хэрэгтэй
type FilmListItem = Pick<Film, 'film_id' | 'title' | 'rating' | 'rental_rate'>;

// 4. Rating тус бүрийн film лист (G, PG, PG-13, R, NC-17)
type FilmsByRating = Record <'G' | 'PG' | 'PG-13' | 'R' | 'NC-17', Film[]>;
