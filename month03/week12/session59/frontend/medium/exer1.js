const account = {
            balance: 100000,
            owner: "Болдбаатар",

            deposit(amount) {
                if (amount <= 0) return "Орлого хийх дүн 0-ээс их байх ёстой.";
                this.balance += amount;
                return `${amount}₮ амжилттай нэмэгдлээ. Үлдэгдэл: ${this.balance}₮`;
            },

            withdraw(amount) {
                if (amount <= 0) return "Зарлага хийх дүн 0-ээс их байх ёстой.";
                if (amount > this.balance) return "Үлдэгдэл хүрэлцэхгүй байна.";
                this.balance -= amount;
                return `${amount}₮ амжилттай хасагдлаа. Үлдэгдэл: ${this.balance}₮`;
            },

            getInfo() {
                return `Эзэмшигч: ${this.owner}, Үлдэгдэл: ${this.balance}₮`;
            }
        };

        const accountInfoEl = document.getElementById("accountInfo");
        const depositInput = document.getElementById("depositAmount");
        const withdrawInput = document.getElementById("withdrawAmount");
        const depositBtn = document.getElementById("depositBtn");
        const withdrawBtn = document.getElementById("withdrawBtn");

        function updateInfo() {
            accountInfoEl.textContent = account.getInfo();
        }
        updateInfo();

        depositBtn.addEventListener("click", () => {
            const amount = Number(depositInput.value);
            alert(account.deposit(amount));
            depositInput.value = "";
            updateInfo();
        });

        withdrawBtn.addEventListener("click", () => {
            const amount = Number(withdrawInput.value);
            alert(account.withdraw(amount));
            withdrawInput.value = "";
            updateInfo();
        });