const movie = {
    title:    "Улаан Хад",
    director: "Б.Болд",
    year:     2021,
    genre:    "Drama",
    rating:   8.5,
    language: "Монгол"
};

console.log(movie.title);
console.log(movie.director);
console.log(movie.rating);

const {title,director,year:releaseYear,genre,rating,language,awards}= movie;
console.log(releaseYear);
console.log(awards);


