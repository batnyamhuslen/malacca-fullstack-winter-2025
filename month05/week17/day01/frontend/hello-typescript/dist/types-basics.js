"use strict";
// ── Primitive types ────────────────────────────────────────────────────────
const filmTitle = "ACADEMY DINOSAUR";
const filmId = 1;
const isActive = true;
// ── Array ──────────────────────────────────────────────────────────────────
const ratings = ["G", "PG", "PG-13", "R", "NC-17"];
const ids = [1, 2, 3, 4, 5];
// Array generic syntax (ижил утгатай)
const titles = ["ACADEMY DINOSAUR", "ACE GOLDFINGER"];
// ── null / undefined ───────────────────────────────────────────────────────
// strict: true үед null болон undefined тусад нь type болно
let rentalRate = null; // null байж болно гэж заана
rentalRate = 0.99; // OK
// ── Union type ─────────────────────────────────────────────────────────────
let id; // number эсвэл string аль аль нь болно
id = 1;
id = "FILM-001";
// Нөхнэ үү:
const category = "Action"; // string
const filmCount = 1000; // number
const available = true; // boolean
const filmIds = [1, 2, 3]; // number[]
let description = null; // string эсвэл null
console.log(category, filmCount);
