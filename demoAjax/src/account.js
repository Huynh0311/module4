let token = localStorage.getItem('token');

function getAll() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            "Authorization": "Bearer " + token
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

function show(arr) {
    let str = "";
    for (const a of arr) {
        str += ` <tr>
                <td>${a.id}</td>
                <td>${a.username}</td>
                <td>${a.password}</td>
                <td>`
        for (const r of a.roles) {
            if (a.roles.indexOf(r) ===( a.roles.length - 1)) str +=`${r.name}`;
            else str +=`${r.name}, `;
        }
        str += `</td>
                <td><button type="button" class="btn btn-warning" data-toggle="modal" onclick="showEdit(${a.id})" data-target="#ModalEdit">Edit</button></td>
                <td><button type="button" class="btn btn-danger" data-toggle="modal" onclick="getId(${a.id})" data-target="#ModalDelete">Delete</button></td>
             </tr> `;
    }
    document.getElementById("show").innerHTML = str;
}

function add() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let idRole = document.getElementById("idRole").value;
    let account = {username, password, role: {id: idRole}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer " + token
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

function showEdit(idA) {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            "Authorization": "Bearer " + token
        },
        url: "http://localhost:8080/accounts/edit/" + idA,
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

function edit() {
    let id = document.getElementById("idE").value;
    let username = document.getElementById("usernameE").value;
    let password = document.getElementById("passwordE").value;
    let idRole = document.getElementById("roleE").value;
    let account = {id, username, password, role: {id: idRole}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer " + token
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

let deleteId;

function getId(idA) {
    deleteId = idA;
}

function deleteA() {
    $.ajax({
        type: "GET",
        headers: {
            "Authorization": "Bearer " + token
        },
        url: "http://localhost:8080/accounts/delete/" + deleteId,
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}

function search() {
    let name = document.getElementById("nameSearch").value;
    $.ajax({
        type: "GET",
        headers: {
            "Accept": "application/json",
            "Authorization": "Bearer " + token
        },
        url: "http://localhost:8080/accounts/search?username=" + name,
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
    // var settings = {
    //     "url": "http://localhost:8080/accounts/search/" + name,
    //     "method": "GET",
    //     "headers": {
    //         "Content-Type": "application/json"
    //     },
    // };
    //
    // $.ajax(settings).done(function (response) {
    //     show(response);
    // })
    // $.ajax(settings).error(function (err) {
    //     console.log(err)
    //     // lỗi
    // })
    // ;
}



