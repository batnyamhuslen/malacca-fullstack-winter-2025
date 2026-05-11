"use strict";
class FilmDisplay {
    // Constructor shorthand — field тодорхойлж assign нэгэн зэрэг
    constructor(films, apiUrl) {
        this.films = films;
        this.apiUrl = apiUrl;
    }
    // Method
    formatAll() {
        return this.films.map(f => `[${f.rating}] ${f.title} — $${f.rental_rate}`);
    }
    filterByRating(rating) {
        return this.films.filter(f => f.rating === rating);
    }
    // Getter — Java-ийн getFilmCount()-тай ижил
    get count() {
        return this.films.length;
    }
}
// Ашиглах
const display = new FilmDisplay([film], "http://localhost:8080");
console.log(display.count); // 1
console.log(display.formatAll()); // ["[PG] ACADEMY DINOSAUR — $0.99"]
console.log(display.filterByRating("G")); // []
// display.films = [];  ❌ films is private
// display.apiUrl = ""; ❌ apiUrl is readonly
class FilmSearch {
    constructor(apiUrl) {
        this.apiUrl = apiUrl;
        this.results = [];
    } // readonly болгоно
    search(title) {
        console.log(`Searching ${this.apiUrl} for "${title}"`);
        // fetch хийх код ирнэ
    }
    get resultCount() {
        return this.results.length;
    }
}
