 // submitPost функц
    async function submitPost(formData) {
      try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(formData)
        });

        const data = await response.json();
        console.log(`Амжилттай үүсгэлээ! ID: ${data.id}`);
      } catch (error) {
        console.error("Алдаа гарлаа:", error);
      }
    }

    // form submit event
    const form = document.getElementById("postForm");
    form.addEventListener("submit", (event) => {
      event.preventDefault(); // form-ийг default submit-ээс сэргийлэх

      const formData = {
        title: form.title.value,
        body: form.body.value,
        userId: 1
      };

      submitPost(formData);
    });