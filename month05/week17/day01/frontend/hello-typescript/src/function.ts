// ── Basic typed function ───────────────────────────────────────────────────
function formatFilm(film: Film): string {
    return `[${film.rating}] ${film.title} — $${film.rental_rate}`;
}

const result = formatFilm(film);
// result is string — TypeScript мэднэ

// ── Optional parameter ─────────────────────────────────────────────────────
function buildSearchUrl(title?: string, rating?: string): string {
    const params = new URLSearchParams();
    if (title)  params.append("title",  title);
    if (rating) params.append("rating", rating);
    return `/api/films/search?${params}`;
}

buildSearchUrl("academy");          // /api/films/search?title=academy
buildSearchUrl(undefined, "PG-13"); // /api/films/search?rating=PG-13
buildSearchUrl("love", "R");        // /api/films/search?title=love&rating=R

// ── Default parameter ─────────────────────────────────────────────────────
function getFilmsUrl(page: number = 1, size: number = 20): string {
    return `/api/films?page=${page}&size=${size}`;
}

getFilmsUrl();       // /api/films?page=1&size=20
getFilmsUrl(2);      // /api/films?page=2&size=20
getFilmsUrl(3, 5);   // /api/films?page=3&size=5

// ── Arrow function ─────────────────────────────────────────────────────────
const formatTitle = (title: string): string => title.toUpperCase();

const filterByRating = (films: Film[], rating: string): Film[] =>
    films.filter(f => f.rating === rating);

// Кино хэдэн доллар байгааг буцаах
function formatPrice(price: number): string {    // number авч string буцаана
    return `$${price.toFixed(2)}`;
}

// Film array-г дамжуулж rental_rate-г нийлбэрлэх
function totalRentalRate(films: Film[]): number{   // Film[] авч number буцаана
    return films.reduce((sum, f) => sum + f.rental_rate, 0);
}

