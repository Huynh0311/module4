function getAll(){
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/accounts",
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getAll();
function show(arr){
    let str = "";
    for (const a of arr) {
        str += ` <tr>
                <td>${a.id}</td>
                <td>${a.username}</td>
                <td>${a.password}</td>
                <td>${a.role.name}</td>
                <td><button type="button" class="btn btn-warning" data-toggle="modal" onclick="showEdit(${a.id})" data-target="#ModalEdit">Edit</button></td>
                <td><button type="button" class="btn btn-danger" onclick="deleteA(${a.id})">Delete</button></td>
             </tr>
    `
    }
    document.getElementById("show").innerHTML = str;
}
function add(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let idRole = document.getElementById("idRole").value;
    let account = {username,password,role: {id:idRole}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
        },
        url: "http://localhost:8080/accounts",
        data: JSON.stringify(account),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
function showEdit(idA){
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/accounts/edit/"+idA,
        success: function (data) {
            document.getElementById("idE").value = data.id;
            document.getElementById("usernameE").value = data.username;
            document.getElementById("passwordE").value = data.password;
            document.getElementById("roleE").value = data.role.id;
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
function edit(){
    let id = document.getElementById("idE").value;
    let username = document.getElementById("usernameE").value;
    let password = document.getElementById("passwordE").value;
    let idRole = document.getElementById("roleE").value;
    let account = {id, username, password,role:{id: idRole}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
        },
        url: "http://localhost:8080/accounts",
        data: JSON.stringify(account),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
function deleteA(idA){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/accounts/delete/"+idA,
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
function search(){
    let name = document.getElementById("nameSearch").value;
    // $.ajax({
    //     type: "GET",
    //     headers: {
    //         "Content-Type": "application/json",
    //     },
    //     url: "http://localhost:8080/accounts/" + name,
    //     success: function (data) {
    //         show(data);
    //     },
    //     error: function (err) {
    //         console.log(err)
    //         // lỗi
    //     }
    // });
    var settings = {
        "url": "http://localhost:8080/accounts/search/"+name,
        "method": "GET",
        "headers": {
            "Content-Type": "application/json"
        },
    };

    $.ajax(settings).done(function (response) {
        show(response);
    });
}

