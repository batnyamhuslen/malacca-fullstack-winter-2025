const нэр = "Анар";
const нас = 22;
const хот = "Улаанбаатар";
const цалин = 1500000;
const ажил = "Хөгжүүлэгч";

// TODO: Дараах 5 хувьсагчийг template literal ашиглан дахин бич

// const a = "Намайг " + нэр + " гэдэг. Би " + нас + " настай.";
// const a = ??? (template literal болгох)
const a = `"namaig" ${нэр}"gedeg. Bi"${нас} "nastai"`;
// const b = нэр + " " + хот + "-д амьдардаг.";
// const b = ???
const b = `нэр " " ${хот} "amdardag"`;
// const c = "Цалин: " + цалин + "₮ / сар";
// const c = ??? (Hint: toLocaleString() ашиглаж болно)
const c = `"tsalin" ${цалин} "$"`;
// const d = нэр + " " + ажил + " байна. Нас: " + нас;
// const d = ???
const d = `${нэр} " " ${ажил} " baina. Nas: " ${нас}`;
// const e = нас >= 18 ? нэр + " насанд хүрсэн" : нэр + " насанд хүрээгүй";
// const e = ??? (Hint: ternary operator-г ${} дотор ашиглаж болно)
const e  = `${нас}>=18? ${нэр} "nasand hvrsen. нэр + " nasand huregui"`;
console.log(a);
console.log(b);
console.log(c);
console.log(d);
console.log(e);