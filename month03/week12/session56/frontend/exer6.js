const movies = [
    { title: "Avengers",     year: 2019, rating: 8.4 },
    { title: "Parasite",     year: 2019, rating: 8.6 },
    { title: "Interstellar", year: 2014, rating: 8.6 }
];
console.log(movies);
const a = movies.reduce((acc, el) => acc + el.rating, 0);
console.log(a);

const arr = [1,2,3];
const b = arr.reduce((acc,el)=>acc+el,0);
console.log(b);

const movieHTML = movies.map(movie => `
  <div class="movie-card">
    <h3>${movie.title} (${movie.year})</h3>
    <p>⭐ ${movie.rating}</p>
  </div>
`).join('');

document.querySelector("#movies").innerHTML = movieHTML;