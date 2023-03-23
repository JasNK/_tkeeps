/*--------------------------------------------------------------------------------*/
// Show Managers
async function loadTable() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/tkeeps/api/accomodatie/retrieve");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                // trHTML += "<tr>";
                trHTML += "<td>" + object["id"] + "</td>";
                trHTML += "<td>" + object["beschrijving"] + "</td>";
                trHTML += "<td>" + object["ruimteCode"] + "</td>";
                trHTML += "<td>" + object["ruimteType"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-primary" onclick="showUserEditBox(' +
                    object["id"] +
                    ')">Edit</button>';
                trHTML +=
                    '<button type="button" class="btn btn-danger btn-outline-danger" onclick="userDelete(' +
                    object["id"] +
                    ')">Delete</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("mytable").innerHTML = trHTML;
        }
    };
    // xhttp.abort();
}

loadTable();

/*--------------------------------------------------------------------------------*/
// Create Manager
function showUserCreateBox() {
    Swal.fire({
        title: "Create manager",
        html:
            '<input id="id" type="hidden">' +
            '<input id="beschrijving" class="swal2-input" placeholder="beschrijving">' +
            '<input id="ruimteCode" class="swal2-input" placeholder="ruimte code">' +
            '<input id="ruimteType" class="swal2-input" placeholder="ruimte type">' +
            '<input id="prijs" class="swal2-input" placeholder="prijs">' +
            '<input id="cat_id" class="swal2-input" placeholder="1">' +
            '<input id="loc_id" class="swal2-input" placeholder="1">'
        ,
        focusConfirm: false,
        preConfirm: () => {
            userCreate();
        },
    });
}

async function userCreate(){
    console.log("test");
    const beschrijving = document.getElementById("beschrijving").value;
    const ruimteCode = document.getElementById("ruimteCode").value;
    const ruimteType = document.getElementById("ruimteType").value;
    const prijs = document.getElementById("prijs").value;
    const cat_id = document.getElementById("cat_id").value;
    const loc_id = document.getElementById("loc_id").value;
    // do something with myJson
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/tkeeps/api/accomodatie/add");
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(
        JSON.stringify({
            beschrijving: beschrijving,
            ruimteCode: ruimteCode,
            ruimteType: ruimteType,
            prijs: prijs,
            cat_id: cat_id,
            loc_id: loc_id,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire("Accomodatie created");
            loadTable();
        }
    };
    // xhttp.abort();
}

/*--------------------------------------------------------------------------------*/
// Update Manager
async function showUserEditBox(id) {
    console.log(id);

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/tkeeps/api/accomodatie/find");
    xhttp.setRequestHeader("Content-type", "application/json");
    var parameters = JSON.stringify({
        id: id,
    });
    xhttp.send(parameters);
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            console.log (objects);
            // const manager = objects["manager"];
            // console.log(manager);
            Swal.fire({
                title: "Edit User",
                html:
                    '<input id="id" readonly value=' +
                    objects["id"] +
                    ">" +
                    '<input id="beschrijving" class="swal2-input" placeholder="naam" value="' +
                    objects["beschrijving"] +
                    '">' +
                    '<input id="ruimteCode" class="swal2-input" placeholder="gebDatum" value="' +
                    objects["ruimteCode"] +
                    '">' +
                    '<input id="ruimteType" class="swal2-input" placeholder="beschrijving" value="' +
                    objects["ruimteType"] +
                    '">' +
                    '<input id="prijs" class="swal2-input" placeholder="beschrijving" value="' +
                    objects["prijs"] +
                    '">' +
                    '<input id="cat_id" class="swal2-input" placeholder="beschrijving" value="' +
                    objects["catacc.id"] +
                    '">' +
                    '<input id="loc_id" class="swal2-input" placeholder="beschrijving" value="' +
                    objects["loc_id"] +
                    '">' ,
                focusConfirm: false,
                preConfirm: () => {
                    userEdit();
                },
            });
        }
    };
    // xhttp.abort();
}

function userEdit() {
    const id = document.getElementById("id").value;
    const naam = document.getElementById("naam").value;
    const gebDatum = document.getElementById("gebDatum").value;
    const beschrijving = document.getElementById("beschrijving").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PATCH", "http://localhost:8080/tkeeps/api/accomodatie/update");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            beschrijving: beschrijving,
            ruimteCode: ruimteCode,
            prijs: prijs,
            cat_id: cat_id,
            loc_id: loc_id,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Accomodatie edited");
            loadTable();
        }
    };
    // xhttp.abort();
}

/*--------------------------------------------------------------------------------*/
// Delete Manager
function userDelete(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/tkeeps/api/accomodatie/remove");
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(
        JSON.stringify({
            id: id,
        })
    );
    console.log("Manager deleted");
    // Swal.fire("Manager deleted");
    // xhttp.abort();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Accomodatie deleted");
            loadTable();
        }
    };
}