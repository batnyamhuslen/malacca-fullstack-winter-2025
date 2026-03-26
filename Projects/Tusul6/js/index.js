const blogs = [
  {
    title: "New Road Projects Begin in Ulaanbaatar",
    body: "Several new road construction projects have started across the capital with the aim of reducing traffic congestion. According to officials, these projects are planned to be completed by the end of this year."
  },
  {
    title: "Education Sector Set for Reform",
    body: "The Ministry of Education has begun working on implementing new policies aimed at improving the quality of general education in schools. These include enhancing teachers' skills and updating the curriculum."
  },
  {
    title: "Reports Indicate Rising Food Prices",
    body: "Citizens have reported that the prices of some everyday food products have increased in recent days. Professional organizations have started studying the factors contributing to the price rise."
  },
  {
    title: "Tourism in Rural Areas is Reviving",
    body: "As the summer tourism season begins, the number of visitors to local tourist destinations in rural areas has started to increase. Tourism companies are introducing new routes and services."
  },
  {
    title: "New Medical Equipment Delivered to the Health Sector",
    body: "Relevant officials announced that modern diagnostic and treatment equipment has begun to be supplied to state hospitals. This is considered important for improving the quality of healthcare services provided to citizens."
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
  }
];

const mainElement = document.querySelector("main");
const inputResult = document.getElementById("input-result");

function displayBlogs(filterText = "") {
    mainElement.innerHTML = "";

    for (let i = 0; i < blogs.length; i++) {
        const blog = blogs[i];
        const title = blog.title.toLowerCase();
        const body = blog.body.toLowerCase();
        const search = filterText.toLowerCase();

        if (title.includes(search) || body.includes(search)) {
            const news = document.createElement("div");
            news.className = "blog-card";

            news.innerHTML = `
                <div class="blog-index">${i + 1}</div>
                <div class="blog-content">
                    <h1>${blog.title}</h1>
                    <p>${blog.body}</p>
                </div>
            `;
            mainElement.appendChild(news);
        }
    }
}

displayBlogs();

inputResult.addEventListener("input", (e) => {
    displayBlogs(e.target.value);
});