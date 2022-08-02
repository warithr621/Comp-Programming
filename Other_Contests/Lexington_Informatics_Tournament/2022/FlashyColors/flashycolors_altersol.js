// yes, to read the pixel data of an imported file in web JS,
// you have to go input -> filereader -> image -> canvas

function ascii(str) {
  //converts string to ASCII value
  var newbin = str.split(" ");
  var code = [];
  for (i = 0; i < newbin.length; i++) {
    code.push(String.fromCharCode(parseInt(newbin[i], 2)));
  }
  return code.join("");
}

const listen = async (target, type) =>
    new Promise((resolve) => {
        target.addEventListener(type, resolve);
    })

const input = document.createElement("input");
input.type = "file";
input.click();
await listen(input, "change");

const file = input.files[0];
const reader = new FileReader();
reader.readAsDataURL(file);
await listen(reader, "load");

const image = new Image();
image.src = reader.result;
await listen(image, "load");

const canvas = document.createElement("canvas");
canvas.width = image.width;
canvas.height = image.height;
const context = canvas.getContext("2d");
context.drawImage(image, 0, 0);

let str = ""; // long story short, this is going to have the 1s and 0s
for (let y = 0; y < 10; ++y) {
    if (y != 0) str += "\n";
    for (let x = 0; x < 10; ++x) {
        if (x != 0) str += " ";
        const [r,g,b] = context.getImageData(image.width*(x+.5)/10, image.height*(y+.5)/10, 1, 1).data;
        str += [r,g,b].map(n => +(n>=128)).join("");
    }
}
/*
----- Austin so geniosity for writing all the code above so big brain -----
--- and now the below is going to take those bits and make the flag >:) ---
*/
const arr = str.split("\n");
let cols = ""; // since we have to read by columns and not rows, fix string
for (let j = 0; j < 39; j += 4) {
  for (let i = 0; i < 10; i++) {
    cols += arr[i].substring(j, j+3)
  }
}

cols = cols.substring(4) // first four zeros are just padding
let char = []
for (let i = 0; i < cols.length; i += 8) {
  char.push(cols.substring(i, i+8)); // separate the bits into groups of 8 (byte)
}

bytes = ""
for (const S of char) {
  bytes = bytes + S + " " // make string called "bytes"
}
console.log(bytes) // the bytes and...
console.log(ascii(bytes)) //the flag :D

