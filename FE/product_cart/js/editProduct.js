function getAllCategory() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/categories",
        success: function (data) {
            showCategory(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getAllCategory();
function showCategory(arr){
    let str = "";
    for (const c of arr) {
        str += `<option value="${c.id}">${c.name}</option>`
    }
    document.getElementById("category").innerHTML = str;
}
function showEdit(){
    let productEdit = JSON.parse(localStorage.getItem("productEdit"));
    document.getElementById("id").value = productEdit.id;
    document.getElementById("name").value = productEdit.name;
    document.getElementById("quantity").value = productEdit.quantity;
    document.getElementById("category").value = productEdit.category.id;
}
showEdit();
function edit() {
    let id = $("#id").val();
    let name = $("#name").val();
    let quantity = $("#quantity").val();
    let category = {"id": $("#category").val()};
    let product = {id, name, quantity, category}

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
        },
        url: "http://localhost:8080/api/saveProduct",
        data: JSON.stringify(product),
        success: function (data) {
            localStorage.removeItem("productEdit");
            window.location.href = "../html/index.html";
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}