function getAllClassroom() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/classrooms",
        success: function (data) {
            showClassroom(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getAllClassroom();
function showClassroom(arr){
    let str = "";
        str += `<option selected>Select class</option>`
    for (const c of arr) {
        str += `<option value="${c.id}">${c.name}</option>`
    }
    document.getElementById("class").innerHTML = str;
}
function add(){
    let name = $("#name").val();
    // let dateOfBirth = $("#dob").val();
    let dateOfBirth = document.getElementById("dob").value;
    let address = $("#address").val();
    let phoneNumber = $("#phone").val();
    let email = $("#email").val();
    let classroom = {"id": $("#class").val()};
    let student = {name, dateOfBirth, address, phoneNumber, email, classroom}

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
        },
        url: "http://localhost:8080/api/addStudent",
        data: JSON.stringify(student),
        success: function (data) {
            window.location.href = "http://localhost:63343/Student_management/FE/Student_management/student.html";
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}