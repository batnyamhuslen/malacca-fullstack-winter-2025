const blogs = [
  {
    title: "Sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    body: "Quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
  },
  {
    title: "Qui est esse",
    body: "Est rerum tempore vitae sequi sint nihil reprehenderit dolor beatae ea dolores neque fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis qui aperiam non debitis possimus qui neque nisi nulla"
  },
  {
    title: "Ea molestias quasi exercitationem repellat qui ipsa sit aut",
    body: "Et iusto sed quo iure voluptatem occaecati omnis eligendi aut ad voluptatem doloribus vel accusantium quis pariatur molestiae porro eius odio et labore et velit aut"
  },
  {
    title: "Eum et est occaecati",
    body: "Ullam et saepe reiciendis voluptatem adipisci sit amet autem assumenda provident rerum culpa quis hic commodi nesciunt rem tenetur doloremque ipsam iure quis sunt voluptatem rerum illo velit"
  },
  {
    title: "Nesciunt quas odio",
    body: "Repudiandae veniam quaerat sunt sed alias aut fugiat sit autem sed est voluptatem omnis possimus esse voluptatibus quis est aut tenetur dolor neque"
  },
  {
    title: "New Public Buses Enter Service",
    body: "As part of the capital’s public transport fleet renewal, new eco-standard buses have started operating. It is expected that this will improve passenger comfort and safety."
  },
  {
    title: "Program to Support Youth Employment to Be Implemented",
    body: "A new program aimed at supporting youth employment is set to be launched. The program will include training, job placement services, and support for startup businesses."
  },
  {
    title: "New Sports Complex to Open Soon",
    body: "A new international-standard sports complex being built in the provincial center is expected to open soon. This development aims to increase opportunities for children and young people to participate in sports."
  },
  {
    title: "Crop Outlook Looks Positive in the Agricultural Sector",
    body: "Experts have highlighted that crop prospects in agricultural regions are relatively good this year due to favorable weather conditions. Farmers have begun preparing for the harvest season."
  },
  {
    title: "Digital Service Accessibility to Be Expanded",
    body: "As part of the digital transformation of government institutions, efforts are underway to increase access to digital services for citizens. As a result, some services will become fully available online."
  },
  {
    title: "Cultural Festival to Be Held Next Month",
    body: "A major cultural festival aimed at promoting national heritage and the arts is scheduled to take place next month. The festival will feature artistic performances, exhibitions, and handicraft fairs."
  },
  {
    title: "Community Tree-Planting Campaign Officially Begins",
    body: "A community-based tree-planting campaign has officially started with the goal of increasing urban green spaces. As part of the campaign, thousands of trees and shrubs are planned to be planted in several locations."
  },
  {
    title: "New Technology Exhibition to Open to the Public",
    body: "An exhibition showcasing advanced technical and technological solutions is set to open this week. Many domestic and international organizations will participate to present their latest products and services."
  },
  {
    title: "Support to Be Provided for Small and Medium Businesses",
    body: "New programs involving low-interest loans and training will be introduced to support small and medium-sized enterprises. The goal is to create jobs and strengthen domestic production."
  },
  {
    title: "New Plan Approved to Improve Urban Air Quality",
    body: "Officials announced that a new action plan has been approved to reduce air pollution in the capital. The plan includes improvements to ger district heating, green spaces, and public transportation."
  },
  {
    title: "Educational Programs to Continue During Students' Vacation",
    body: "Several schools and organizations will organize additional learning and development programs during students’ vacation period. These will include courses in languages, information technology, arts, and sports."
  },
  {
    title: "Нийслэлийн нийтийн тээвэрт шинэ автобуснууд үйлчилгээнд гарлаа",
    body: "Парк шинэчлэлтийн хүрээнд эко-стандартын шинэ автобуснууд зарим чиглэлд явж эхэллээ. Ингэснээр иргэдийн тав тух, аюулгүй байдал сайжрах хүлээлттэй байна."
  },
  {
    title: "Залуучуудын хөдөлмөр эрхлэлтийг дэмжих хөтөлбөр хэрэгжинэ",
    body: "Залуучуудыг ажлын байраар хангах, мэргэжлийн сургалтад хамруулах болон стартап бизнесийг дэмжих зорилготой шинэ төсөл нээлтээ хийхээр боллоо."
  },
  {
    title: "Олон улсын стандартад нийцсэн спортын цогцолбор ашиглалтад орно",
    body: "Аймгийн төвд баригдаж буй шинэ цогцолбор удахгүй үүд хаалгаа нээх бөгөөд хүүхэд залуучууд спортоор хичээллэх боломж илүү нэмэгдэх юм."
  },
  {
    title: "Хөдөө аж ахуйн салбарт ургац хураалтын төлөв эерэг байна",
    body: "Цаг агаарын нөхцөл байдал тааламжтай байгаа тул энэ жил ургац арвин байхыг мэргэжилтнүүд онцоллоо. Тариаланчид ургац хураалтын бэлтгэлээ базааж эхэлжээ."
  },
  {
    title: "Төрийн цахим үйлчилгээний хүртээмжийг нэмэгдүүлнэ",
    body: "Цахим шилжилтийн хүрээнд төрийн зарим үйлчилгээг бүрэн онлайн хэлбэрт шилжүүлж, иргэдэд чирэгдэлгүй үйлчлэх ажлууд хийгдэж байна."
  },
  {
    title: "Ирэх сард үндэсний соёл урлагийн наадам зохион байгуулагдана",
    body: "Өв соёлыг сурталчлах зорилготой тус наадмаар урлагийн тоглолт, үзэсгэлэн болон гар урлалын яармаг худалдаа болох хуваарь гарчээ."
  },
  {
    title: "Бүх нийтээр мод тарих аян албан ёсоор эхэллээ",
    body: "Хотын ногоон байгууламжийг нэмэгдүүлэх зорилгоор хэд хэдэн байршилд мянга мянган мод, бут сөөг тарих ажил идэвхтэй өрнөж байна."
  },
];

// const mainElement = document.querySelector("main");
// const inputResult = document.getElementById("input-result");
// const sentinel = document.getElementById("sentinel");
// let visiblbeCount = 5;
// let currentFilter = ""

// function displayBlogs(filterText = "") {

//   mainElement.innerHTML = "";

//   for (let i = 0; i < blogs.length; i++) {
//     const blog = blogs[i];
//     const title = blog.title.toLowerCase();
//     const body = blog.body.toLowerCase();
//     const search = filterText.toLowerCase();

//     if (title.includes(search) || body.includes(search)) {
//       const card = document.createElement("div");
//       card.className = "blog-card";

//       card.innerHTML = `
//                 <div class="blog-index">${i + 1}</div>
//                 <div class="blog-content">
//                     <h1>${blog.title}</h1>
//                     <p>${blog.body}</p>
//                 </div>
//             `;
//       mainElement.appendChild(card);
//     }

//   }
// }

// displayBlogs();

// inputResult.addEventListener("input", (e) => {
//   displayBlogs(e.target.value);
// });

const gridContainer = document.getElementById("grid-container");
const loadingMsg = document.getElementById("loading-msg");
const scrollAnchor = document.getElementById("scroll-anchor");
const inputResult = document.getElementById("input-result");

let isFetching = false;
let currentIndex = 0;
const batchSize = 5;
let filteredBlogs = [...blogs];

function loadItems() {
  if (isFetching || currentIndex >= filteredBlogs.length) {
    return;
  }

  isFetching = true;
  loadingMsg.style.display = "block";

  setTimeout(() => {
    const end = Math.min(currentIndex + batchSize, filteredBlogs.length);

    for (let i = currentIndex; i < end; i++) {
      const blog = filteredBlogs[i];
      const card = document.createElement("div");
      card.className = "blog-card";

      card.innerHTML = `
                <div class="blog-index">${i + 1}</div>
                <div class="blog-content">
                    <h1>${blog.title}</h1>
                    <p>${blog.body}</p>
                </div>
            `;
      gridContainer.insertBefore(card, scrollAnchor);
    }

    currentIndex = end;
    isFetching = false;
    loadingMsg.style.display = "none";


    if (document.documentElement.scrollHeight <= window.innerHeight && currentIndex < filteredBlogs.length) {
      loadItems();
    }
  }, 1000);
}

inputResult.addEventListener("input", (e) => {
  const searchTerm = e.target.value.toLowerCase();

  filteredBlogs = blogs.filter(blog =>
    blog.title.toLowerCase().includes(searchTerm) ||
    blog.body.toLowerCase().includes(searchTerm)
  );

  gridContainer.querySelectorAll('.blog-card').forEach(card => card.remove());
  currentIndex = 0;

  loadItems();
});

window.addEventListener("scroll", () => {
  const { scrollHeight, scrollTop, clientHeight } = document.documentElement;

  if (scrollTop + clientHeight >= scrollHeight - 100) {
    loadItems();
  }
});

loadItems();