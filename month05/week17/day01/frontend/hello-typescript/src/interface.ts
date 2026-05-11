// Week 14-ийн GET /api/films буцаадаг JSON-тай тааруулна
interface Film {
    film_id:     number;
    title:       string;
    rating:      string;
    rental_rate: number;
    description?: string;  // ? = optional, байхгүй ч болно
}

// Interface ашиглах
const film: Film = {
    film_id:     1,
    title:       "ACADEMY DINOSAUR",
    rating:      "PG",
    rental_rate: 0.99
    // description байхгүй ч ЗА — optional тул
};

// film.titel = "...";  ❌ Compile error: 'titel' does not exist on type 'Film'
// film.film_id = "abc"; ❌ Compile error: Type 'string' is not assignable to type 'number'

interface FilmDetail extends Film {
    rental_duration: number;
    replacement_cost: number;
    special_features: string[];
}

// FilmDetail нь Film-ийн бүх field + өөрийн field-тэй
const detail: FilmDetail = {
    film_id:          1,
    title:            "ACADEMY DINOSAUR",
    rating:           "PG",
    rental_rate:      0.99,
    rental_duration:  6,
    replacement_cost: 20.99,
    special_features: ["Deleted Scenes", "Behind the Scenes"]
};

interface Category {
    category_id: number;    // тоо
    name: string;           // мөр
}

interface Actor {
    actor_id:   number;
    first_name: string;     // мөр
    last_name:  string;     // мөр
}

// Week 14-ийн /api/stats/categories буцаадаг JSON
interface CategoryStats extends Category {   // Category-г өвлөнө
    film_count:      number;
    avg_rental_rate: number;   // тоо
    total_rentals:   number;
}
console.log()