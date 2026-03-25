const blogs = [
    {
        "title": "test Title1",
        "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
    },
    {
        "title": "test Title2",
        "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
    },
    {
        "title": "test Title3",
        "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
    },
    {
        "title": "test Title4",
        "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
    },
    {
        "title": "test Title5",
        "body": "    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Autem reiciendis beatae officiis incidunt esse quo totam nesciunt atque ab dolore?"
    },
];



for (let i = 0; i < blogs.length; i++) {
   const mainElement = document.querySelector("main");

blogs.forEach((blog, index) => {
    const card = document.createElement("div");
    card.className = "blog-card";

    const indexCircle = document.createElement("div");
    indexCircle.className = "blog-index";
    indexCircle.textContent = index + 1;

    const content = document.createElement("div");
    content.className = "blog-content";

    const title = document.createElement("h1");
    title.textContent = blog.title;

    const body = document.createElement("p");
    body.textContent = blog.body;

    content.appendChild(title);
    content.appendChild(body);
    
    card.appendChild(indexCircle);
    card.appendChild(content);
    
    mainElement.appendChild(card);
});
}
