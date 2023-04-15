const getProductsUrl = "http://localhost:8080/get";

const header = {
  "content-type": "application/json",
};

const getAllOptions = {
  method: "GET",
  headers: header,
  mode: "cors",
  cache: "default",
};

function showDetails(id){
  console.log("hiillll");
  localStorage.setItem("id", id)
  window.location.href = "http://localhost:9000/product.html"
}

const elements = document.getElementById("elements");

fetch(getProductsUrl, getAllOptions)
  .then((response) => response.json())
  .then((data) => {
    //console.log(data[0]);
    data.forEach((element) => {
      const mots = element.description.split(" ");

      let p3mot = `${mots[1]} ${mots[2]} ${mots[3]}...`;

      if (mots.length <= 3) {
        p3mot = element.description;
      }

      elements.innerHTML += `
        <div class="carte">
        <h3 class="productName">${element.name}</h3>
        <h4 class="categoryName">${element.category.categoryName}</h4>
        <h5 class="productDesc">${p3mot}</h5>
        <input class="btn" id="btn${element.id}" type="button" value="Show more" onclick="showDetails(${element.id})">
      </div>`;

    });
  });
