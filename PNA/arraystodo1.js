const numbers = [1,2,3,4,5];
numbers[numbers.length] = 6;
console.log(numbers)

const integers = [1,2,3,4,5,6];
const firstinteger = integers.shift();

console.log(firstinteger)
console.log(integers)

const insert = [1,2,3,4,5];
const newinserts = [8,9];

const inserts3 = insert.concat(newinserts);
console.log(inserts3)