let products = [
    {
        id: 1,
        name: "ny Khánh",
        price: 300,
        img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6dtt5UfnOt9vD1E8j9WrmW-h9iYunfEDc1g&usqp=CAU"
    },
    {
        id: 2,
        name: "ny Quang",
        price: 200,
        img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqNk8loXPtuESswzcFHl6-NbtYOVxSbMWfHnHn1PlEtccqXUaHyfcog7fl7bV6ROb4IDY&usqp=CAU"
    },
    {
        id: 3,
        name: "ny Hiếu",
        price: 100,
        img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgUIbT-9YpR-1sJAlPvExOAY6DgJW2YH6rDk3b-xmgqP4dxSFenf40C3v_UIt7vwEGuek&usqp=CAU"
    },
]
function show(products) {
    let str = "";
    for (const product of products) {
        str += ` <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td><img src="${product.img}" alt="" width="220" height="250"></td>
                <td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModalEdit">Edit</button></td>
                <td><button type="button" class="btn btn-danger">Delete</button></td>
             </tr>
    `
    }
    document.getElementById("show").innerHTML = str;
}

function add() {
    let id = document.getElementById("id").value
    let name = document.getElementById("name").value
    let price = document.getElementById("price").value
    let img = document.getElementById("img").value
    let newProduct = {id, name, price, img}
    products.push(newProduct)
    show(products);
}
show(products);