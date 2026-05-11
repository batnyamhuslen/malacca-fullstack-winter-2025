"use strict";
// Interface ашиглах
const film = {
    film_id: 1,
    title: "ACADEMY DINOSAUR",
    rating: "PG",
    rental_rate: 0.99
    // description байхгүй ч ЗА — optional тул
};
// FilmDetail нь Film-ийн бүх field + өөрийн field-тэй
const detail = {
    film_id: 1,
    title: "ACADEMY DINOSAUR",
    rating: "PG",
    rental_rate: 0.99,
    rental_duration: 6,
    replacement_cost: 20.99,
    special_features: ["Deleted Scenes", "Behind the Scenes"]
};
console.log();
