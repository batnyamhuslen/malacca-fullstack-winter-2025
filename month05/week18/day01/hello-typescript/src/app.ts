interface Film {
    film_id: number;
    title: string;
    rating: "G" | "PG" | "PG-13" | "R";
    rental_rate: number;
    rental_duration: number;
}

interface Actor {
    actor_id: number;
    first_name: string;
}

type CreateFilm = Omit<Film, "film_id">;
type FilmUpdate = Partial<Film>;
type FilmSummary = Pick<Film, "film_id" | "title" | "rating">;

interface PageResponse<T> {
    content: T[],
    totalElements: number;
}

interface HasId {
    film_id?: number;
    actor_id?: number;
}

type MyPartial<T> = { [K in keyof T]?: T[K] };
type MyPick<T, K extends keyof T> = { [P in K]: T[P] };

interface Repository<T, ID> {
    findAll(): PageResponse<T>;
    save(item: Omit<T, "film_id">): T;
    update(id: ID, changes: Partial<T>): T | null;
}

class FilmRepository implements Repository<Film, number> {

    private items: Film[] = [];
    constructor(initialItems: Film[]) {
        this.items = initialItems;
    }

    findAll(): PageResponse<Film> {
        return { content: this.items, totalElements: this.items.length };
    }
    findById(id: number): Film | null {
        return this.items.find((f) => f.film_id === id) || null;
    }

    save(item: Omit<Film, "film_id">): Film {
        const nextId =
            this.items.length > 0
                ? Math.max(...this.items.map((f) => f.film_id)) + 1
                : 1;
        const completeFilm: Film = { film_id: nextId, ...item };
        this.items.push(completeFilm);
        return completeFilm;
    }

    update(id: number, changes: Partial<Film>): Film | null {
        const film = this.findById(id);
        if (!film) return null;
        Object.assign(film, changes);
        return film;
    }

    sort(key: keyof Film): Film[] {
        return [...this.items].sort((a, b) => {
            if (a[key]! < b[key]!) return -1;
            if (a[key]! > b[key]!) return 1;
            return 0;
        });
    }
}

class Stack<T> {
    private items: T[] = [];
    push(item: T): void {
        this.items.push(item);
    }
    pop(): T | undefined {
        return this.items.pop();
    }
    getAllHistory(): T[] {
        return [...this.items].reverse();
    }
}

const initialData: Film[] = [
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
const actionHistory = new Stack<string>();

// dom
const tableBody = document.getElementById("inventoryTable") as HTMLTableSectionElement;
const filmForm = document.getElementById("filmForm") as HTMLFormElement;
const sortSelect = document.getElementById("sortSelect") as HTMLSelectElement;
const btnUpdate = document.getElementById("btnUpdate") as HTMLButtonElement;
const categoryContainer = document.getElementById("categoryContainer") as HTMLDivElement;
const stackLog = document.getElementById("stackLog") as HTMLDivElement;
function updateUI(): void {
    const records = database.findAll().content;

    // 1. Redraw main database table view
    tableBody.innerHTML = records
        .map(
            (f) =>
                `
        <tr>
            <td><strong>#${f.film_id}</strong></td>
            <td>${f.title}</td>
            <td>${f.rating}</td>
            <td>$${f.rental_rate.toFixed(2)}</td>
        </tr>
        `
            ,
        )
        .join("");

    // 2. Part 4: Processing Record<K, V> layout metrics dynamically
    const categoryMapping: Record<string, FilmSummary[]> = {
        "Family Friendly (G/PG)": records
            .filter((f) => f.rating === "G" || f.rating === "PG")
            .map((f) => ({ film_id: f.film_id, title: f.title, rating: f.rating })),
        "Mature Audiences (PG13/R)": records
            .filter((f) => f.rating === "PG-13" || f.rating === "R")
            .map((f) => ({ film_id: f.film_id, title: f.title, rating: f.rating })),
    };

    categoryContainer.innerHTML = Object.entries(categoryMapping)
        .map(
            ([catName, subFilms]) =>
                `<div style="margin-bottom:10px;" >
        <strong>${catName}(${subFilms.length}) </strong>
        < div style = "font-size:0.85em; color:#aaa; padding-left:10px;" >
        ${subFilms.length > 0 ? subFilms.map((sf) => `${sf.title}[${sf.rating}]`).join(", ") : "None Loaded"}
        </div>
        </div>
            `,
        )
        .join("");

    // 3. Render Generic Tracking History Log Stack elements
    stackLog.innerHTML = actionHistory
        .getAllHistory()
        .map((logLine) => `<div>& gt; ${logLine} </div>`)
        .join("");
}

// Event Triggers
filmForm.addEventListener("submit", (e: Event) => {
    e.preventDefault();
    const titleIn = document.getElementById("title") as HTMLInputElement;
    const ratingIn = document.getElementById("rating") as HTMLSelectElement;
    const rateIn = document.getElementById("rate") as HTMLInputElement;

    const omitPayload: CreateFilm = {
        title: titleIn.value.toUpperCase(),
        rating: ratingIn.value as Film["rating"],
        rental_rate: parseFloat(rateIn.value),
        rental_duration: 0
    };

    const saved = database.save(omitPayload);
    actionHistory.push(`INSERTED: "${saved.title}" with ID #${saved.film_id}`);

    filmForm.reset();
    updateUI();
});

btnUpdate.addEventListener("click", () => {
    const idIn = document.getElementById("updateId") as HTMLInputElement;
    const rateIn = document.getElementById("updateRate") as HTMLInputElement;

    const targetId = parseInt(idIn.value);
    const targetRate = parseFloat(rateIn.value);

    if (isNaN(targetId) || isNaN(targetRate))
        return alert("Please fill ID and Rate elements");

    const partialPayload: FilmUpdate = { rental_rate: targetRate };
    const updatedRecord = database.update(targetId, partialPayload);

    if (updatedRecord) {
        actionHistory.push(
            `UPDATED: Film #${targetId} base price shifted to $${targetRate}`,
        );
        idIn.value = "";
        rateIn.value = "";
        updateUI();
    } else {
        alert("Target film ID was not found!");
    }
});

