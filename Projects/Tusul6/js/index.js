// const blogs = [
//     {
//         "title": "test Title1",
//         "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
//     },
//     {
//         "title": "test Title2",
//         "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
//     },
//     {
//         "title": "test Title3",
//         "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
//     },
//     {
//         "title": "test Title4",
//         "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
//     },
//     {
//         "title": "test Title5",
//         "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
//     },
// ];




const mainElement = document.querySelector("main");

for (let i = 0; i < blogs.length; i++) {
    const blog = blogs[i];
    const index = i + 1;

    const card = document.createElement("div");
    card.className = "blog-card";

    card.innerHTML = `
        <div class="blog-index">${index}</div>
        <div class="blog-content">
            <h1>${blog.title}</h1>
            <p>${blog.body}</p>
        </div>
    `;

    mainElement.appendChild(card);
}
