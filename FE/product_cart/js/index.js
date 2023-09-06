function getAll() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/products",
        success: function (data) {
            show(data);
        },
        error: function (err) {
            getAll();
            console.log(err)
            // lỗi
        }
    });
}

getAll();

function show(arr) {
    let str = "";
    for (const p of arr) {
        str += `<tr>
        <th scope="row">${p.id}</th>
        <td>${p.name}</td>
        <td>${p.quantity}</td>
        <td>${p.category.name}</td>`
        if (p.quantity <= 0) {
            str += `<td>Hết hàng</td>`
        } else {
            str += `<td>Còn hàng</td>`
        }

        str += `<td>`
        if (p.quantity <= 0) {
            str += `<button class="btn btn-info" onclick="" hidden="hidden">ADD TO CART</button>`
        } else {
            str += `<button class="btn btn-info" onclick="addToCart(${p.id})" >ADD TO CART</button>`
        }
        str += `</td>
                <td>
                    <button class="btn btn-warning" onclick="showEdit(${p.id})">EDIT</button>
                </td>
                <td>
                    <button class="btn btn-danger" data-toggle="modal" onclick="getId(${p.id})" data-target="#ModalDelete">DELETE</button>
                </td>
                </tr>`;
    }
    document.getElementById("show").innerHTML = str;
}

function addToCart(idP) {
    let cartList = localStorage.getItem("cartList");
    if (cartList == null) {
        let idProductCart = idP;
        let quantityCard = 1;
        let productCard = {idProductCart, quantityCard}
        let listToCartNew = [];
        listToCartNew.push(productCard);
        localStorage.setItem("cartList", listToCartNew);
    } else {

    }
}

let deleteId;

function getId(idP) {
    deleteId = idP;
}

function deleteA() {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/deleteStudent/" + deleteId,
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}

function showEdit(idS) {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/showEdit/" + idS,
        success: function (data) {
            localStorage.setItem("productEdit", JSON.stringify(data));
            window.location.href = "editProduct.html";
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}

function search() {
    let nameSearch = $("#nameSearch").val();
    $.ajax({
        type: "GET",
        headers: {
            "Accept": "application/json",
        },
        url: "http://localhost:8080/api/searchByName/" + nameSearch,
        success: function (data) {
            if (data.length) show(data);
            else $("#show").html('Notfound');
        },
        error: function (err) {
            getAll();
            console.log(err)
            // lỗi
        }
    });
}

$("#nameSearch").keyup(function (event) {
    if (event.keyCode == '13') {
        search();
    }
});
