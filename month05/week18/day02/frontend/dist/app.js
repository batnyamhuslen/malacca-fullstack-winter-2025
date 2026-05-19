function wrap(value) {
    return { value, type: typeof value };
}
function merge(a, b) {
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
console.log(merged.film_id); // (a) OK
console.log(merged.rating); // (b) OK
console.log(merged.director); // (c) OK
// API-аас өгөгдөл авах generic function
async function fetchData(url) {
    const response = await fetch(url);
    if (!response.ok) {
        throw Error(`HTTP ${response.status}`); // (b) бага зэрэг дутуу
    }
    return response.json(); // (c) алдаа
}
// Generic constraint дутуу
function getFirst(items) {
    return items[0]; // (d) боломжит асуудал
}
// keyof буруу ашиглалт
function pluck(items, key) {
    return items.map(item => item[key]);
}
function groupBy(items, key) {
    return items.reduce((groups, item) => {
        const groupKey = String(item[key]);
        if (!groups[groupKey]) {
            groups[groupKey] = [];
        }
        groups[groupKey].push(item);
        return groups;
    }, {});
}
const result = groupBy([
    { film_id: 1, title: "ACADEMY DINOSAUR", rating: "PG" },
    { film_id: 2, title: "ACE GOLDFINGER", rating: "G" },
    { film_id: 3, title: "ADAPTATION HOLES", rating: "PG" },
    { film_id: 4, title: "AFFAIR PREJUDICE", rating: "G" },
], "rating");
console.log(result);
// Аль нь compile error гарах вэ?
const a = {}; // (1)
const b = { film_id: 1, title: "ACADEMY DINOSAUR", rating: "PG",
    rental_rate: 0.99, description: "A Epic...", rental_duration: 6,
    replacement_cost: 20.99 }; // (2)
const c = { film_id: 1, title: "ACADEMY DINOSAUR", rating: "PG" }; // (3)
const d = { title: "ACADEMY DINOSAUR", rating: "PG",
    rental_rate: 0.99, rental_duration: 6,
    replacement_cost: 20.99 }; // (4)
const e = { G: [], PG: [], "PG-13": [], R: [], "NC-17": [] }; // (5)
const f = { G: [], PG: [], R: [] }; // (6)
export {};
