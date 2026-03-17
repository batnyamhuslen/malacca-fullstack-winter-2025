const questions = document.querySelectorAll(".faq-question");

questions.forEach(function(question) {
    question.addEventListener("click", function() {
        const answer = question.nextElementSibling;  // faq-answer div
        const isOpen = question.classList.contains("open");

        // TODO 1: Бүх асуултыг хаах
        questions.forEach(function(q) {
            q.classList.remove("open");
            q.nextElementSibling.style.display = "none";
        });

        // TODO 2: Хэрэв isOpen false байсан бол нээх
        if (!isOpen) {
            question.classList.add("open");
            answer.style.display = "block";
        }
    });
});