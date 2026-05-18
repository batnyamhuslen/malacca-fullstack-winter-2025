"use strict";
class FilmRepository {
    items = [];
    constructor(initialItems) {
        this.items = initialItems;
    }
    findAll() {
        return { content: this.items, totalElements: this.items.length };
    }
    findById(id) {
        return this.items.find((f) => f.film_id === id) || null;
    }
    save(item) {
        const nextId = this.items.length > 0
            ? Math.max(...this.items.map((f) => f.film_id)) + 1
            : 1;
        const completeFilm = { film_id: nextId, ...item };
        this.items.push(completeFilm);
        return completeFilm;
    }
    update(id, changes) {
        const film = this.findById(id);
        if (!film)
            return null;
        Object.assign(film, changes);
        return film;
    }
    sort(key) {
        return [...this.items].sort((a, b) => {
            if (a[key] < b[key])
                return -1;
            if (a[key] > b[key])
                return 1;
            return 0;
        });
    }
}
class Stack {
    items = [];
    push(item) {
        this.items.push(item);
    }
    pop() {
        return this.items.pop();
    }
    getAllHistory() {
        return [...this.items].reverse();
    }
}
const initialData = [
    {
        film_id: 1,
        title: "academy dinosaur",
        rating: "PG",
        rental_rate: 0.99,
        rental_duration: 5,
    },
    {
        film_id: 2,
        title: "ace goldfinger",
        rating: "G",
        rental_rate: 4.99,
        rental_duration: 3,
    },
];
const database = new FilmRepository(initialData);
const actionHistory = new Stack();
// dom
const tableBody = document.getElementById("inventoryTable");
const filmForm = document.getElementById("filmForm");
const sortSelect = document.getElementById("sortSelect");
const btnUpdate = document.getElementById("btnUpdate");
const categoryContainer = document.getElementById("categoryContainer");
const stackLog = document.getElementById("stackLog");
function updateUI() {
    const records = database.findAll().content;
    // 1. Redraw main database table view
    tableBody.innerHTML = records
        .map((f) => `
        <tr>
            <td><strong>#${f.film_id}</strong></td>
            <td>${f.title}</td>
            <td>${f.rating}</td>
            <td>$${f.rental_rate.toFixed(2)}</td>
        </tr>
        `)
        .join("");
    // 2. Part 4: Processing Record<K, V> layout metrics dynamically
    const categoryMapping = {
        "Family Friendly (G/PG)": records
            .filter((f) => f.rating === "G" || f.rating === "PG")
            .map((f) => ({ film_id: f.film_id, title: f.title, rating: f.rating })),
        "Mature Audiences (PG13/R)": records
            .filter((f) => f.rating === "PG-13" || f.rating === "R")
            .map((f) => ({ film_id: f.film_id, title: f.title, rating: f.rating })),
    };
    categoryContainer.innerHTML = Object.entries(categoryMapping)
        .map(([catName, subFilms]) => `<div style="margin-bottom:10px;" >
        <strong>${catName}(${subFilms.length}) </strong>
        < div style = "font-size:0.85em; color:#aaa; padding-left:10px;" >
        ${subFilms.length > 0 ? subFilms.map((sf) => `${sf.title}[${sf.rating}]`).join(", ") : "None Loaded"}
        </div>
        </div>
            `)
        .join("");
    // 3. Render Generic Tracking History Log Stack elements
    stackLog.innerHTML = actionHistory
        .getAllHistory()
        .map((logLine) => `<div>& gt; ${logLine} </div>`)
        .join("");
}
// Event Triggers
filmForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const titleIn = document.getElementById("title");
    const ratingIn = document.getElementById("rating");
    const rateIn = document.getElementById("rate");
    const omitPayload = {
        title: titleIn.value.toUpperCase(),
        rating: ratingIn.value,
        rental_rate: parseFloat(rateIn.value),
        rental_duration: 0
    };
    const saved = database.save(omitPayload);
    actionHistory.push(`INSERTED: "${saved.title}" with ID #${saved.film_id}`);
    filmForm.reset();
    updateUI();
});
btnUpdate.addEventListener("click", () => {
    const idIn = document.getElementById("updateId");
    const rateIn = document.getElementById("updateRate");
    const targetId = parseInt(idIn.value);
    const targetRate = parseFloat(rateIn.value);
    if (isNaN(targetId) || isNaN(targetRate))
        return alert("Please fill ID and Rate elements");
    const partialPayload = { rental_rate: targetRate };
    const updatedRecord = database.update(targetId, partialPayload);
    if (updatedRecord) {
        actionHistory.push(`UPDATED: Film #${targetId} base price shifted to $${targetRate}`);
        idIn.value = "";
        rateIn.value = "";
        updateUI();
    }
    else {
        alert("Target film ID was not found!");
    }
});
