const users = [
    { id: 1, username: "bold22",   email: "bold@mail.mn",   active: true  },
    { id: 2, username: "oyun_dev", email: "oyun@mail.mn",   active: false },
    { id: 3, username: "bat123",   email: "bat@gmail.com",  active: true  },
    { id: 4, username: "anu_mn",   email: "anu@mail.mn",    active: true  }
]; 

const find = users.find(x=>x.id === 3);
console.log(find);

const activitive = users.find(x=>x.active ===false);
console.log(activitive);

const findname = users.findIndex(x=>x.username==="oyun_dev");
console.log(findname);

const gmail = users.find(x=>x.email);
console.log(gmail);
