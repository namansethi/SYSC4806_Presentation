$(document).ready(function () {

    getString = getUrlVars()


    idNum = parseInt(getString["id"])


    if (!isNaN(idNum)) {
        displayAddressBookId(idNum)
    } else {
        displayAddressBooks()
    }


    // Read a page's GET URL variables and return them as an associative array.
    //Got from stack Overflow https://stackoverflow.com/questions/4656843/get-querystring-from-url-using-jquery
    function getUrlVars() {
        var vars = [], hash;
        var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
        for (var i = 0; i < hashes.length; i++) {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }
        return vars;
    }

    function displayAddressBooks() {
        $.ajax({
            url: "AddressBook/JSON"
        }).then(function (data) {


            var content = "<table border='1'>";
            $('.greeting-id').append(data.id);

            content += "<tr> <th>id</th><th>Number of Buddies</th></tr>";

            for (var buddy in data) {
                content += "<tr>";
                content += "<td>" + data[buddy].id + "</td>";
                content += "<td>" + data[buddy].numBuddies + "</td>";
                content += "<td><a href=?id=" + data[buddy].id + ">View</a></td>";
                content += "</tr>";
            }

            content += "</table>";

            $('.addressBooks').append(content);

            $('.newAddressBook').css("display", "inline");
            $('.newBuddyForm').css("display", "none");


        });
    }

    function displayAddressBookId(id) {
        $.ajax({
            url: "BuddiesForAddressBook/JSON?id=" + id
        }).then(function (data) {

            var content = "<table border='1'>";
            $('.greeting-id').append(data.id);

            content += "<tr> <th>id</th><th>Name</th><th>Address</th><th>Phone Number</th><th>Age</th>";

            for (var buddy in data.buddies) {
                content += "<tr>";
                content += "<td>" + data.buddies[buddy].id + "</td>";
                content += "<td>" + data.buddies[buddy].name + "</td>";

                content += "<td>" + data.buddies[buddy].address + "</td>";
                content += "<td>" + data.buddies[buddy].phoneNumber + "</td>";
                content += "<td>" + data.buddies[buddy].age + "</td>";
                content += "</tr>";
            }

            content += "</table>";

            $('.buddies').append(content);

            $('.buddies').append("<a href='/'>Back To List Of All AddressBook</a>");

            $('.newAddressBook').css("display", "none");
            $('.newBuddyForm').css("display", "inline");


        });
    }


    $("#makeNewAddressBook").click(function (){
        $.post("/AddressBook/new", {}, function(){});
        window.location.reload()
    });



    $("#AddBuddyForm").submit(function (event) {
        var formData = {
            name: $("#name").val(),
            address: $("#address").val(),
            phoneNumber: $("#phoneNumber").val(),
            age: $("#age").val()
        };


        $.ajax({
            type: "POST",
            url: "/BuddiesForAddressBook/" + idNum,
            contentType: 'application/json',
            data: JSON.stringify(formData),
            dataType: "json",
            encode: true,
        }).done(function (data) {
            console.log(data);
        });

        event.preventDefault();
        window.location.reload()
    });



});