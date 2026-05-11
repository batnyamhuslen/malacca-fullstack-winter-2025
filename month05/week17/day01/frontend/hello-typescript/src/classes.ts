class FilmDisplay {
    // Constructor shorthand — field тодорхойлж assign нэгэн зэрэг
    constructor(
        private films: Film[],
        readonly apiUrl: string) {}

    // Method
    formatAll(): string[] {
        return this.films.map(f =>
            `[${f.rating}] ${f.title} — $${f.rental_rate}`
        );
    }

    filterByRating(rating: string): Film[] {
        return this.films.filter(f => f.rating === rating);
    }

    // Getter — Java-ийн getFilmCount()-тай ижил
    get count(): number {
        return this.films.length;
    }
}

// Ашиглах
const display = new FilmDisplay(
    [film],
    "http://localhost:8080"
);

console.log(display.count);              // 1
console.log(display.formatAll());        // ["[PG] ACADEMY DINOSAUR — $0.99"]
console.log(display.filterByRating("G")); // []

// display.films = [];  ❌ films is private
// display.apiUrl = ""; ❌ apiUrl is readonly

class FilmSearch {
    private results: Film[] = [];

    constructor(private readonly apiUrl: string) {}  // readonly болгоно

    search(title: string): void {    // void буцаана
        console.log(`Searching ${this.apiUrl} for "${title}"`);
        // fetch хийх код ирнэ
    }

    get resultCount(): number {   // number буцаана
        return this.results.length;
    }
}