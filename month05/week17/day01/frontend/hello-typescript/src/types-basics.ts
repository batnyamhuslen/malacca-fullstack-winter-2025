// ── Primitive types ────────────────────────────────────────────────────────
const filmTitle: string  = "ACADEMY DINOSAUR";
const filmId:    number  = 1;
const isActive:  boolean = true;

// ── Array ──────────────────────────────────────────────────────────────────
const ratings: string[]  = ["G", "PG", "PG-13", "R", "NC-17"];
const ids:     number[]  = [1, 2, 3, 4, 5];

// Array generic syntax (ижил утгатай)
const titles: Array<string> = ["ACADEMY DINOSAUR", "ACE GOLDFINGER"];

// ── null / undefined ───────────────────────────────────────────────────────
// strict: true үед null болон undefined тусад нь type болно
let rentalRate: number | null = null;    // null байж болно гэж заана
rentalRate = 0.99;                       // OK

// ── Union type ─────────────────────────────────────────────────────────────
let id: number | string;   // number эсвэл string аль аль нь болно
id = 1;
id = "FILM-001";

// Нөхнэ үү:
const category: string   = "Action";       // string
const filmCount: number  = 1000;           // number
const available: boolean  = true;           // boolean
const filmIds: number[]    = [1, 2, 3];      // number[]
let description: string | null = null;     // string эсвэл null

console.log(category,filmCount);