$(document).ready(function () {
    var mainElement = document.getElementById('contactPage');

    loadContacts(); // load and display any contacts in storage

    $(mainElement).find("a.deleteAll").click(
        function (evt) {
            evt.preventDefault();
            localStorage.clear();
            $(mainElement).find('table tbody').remove();
        }
    );

    $(mainElement).on("click", "a.delete",
        function (evt) {
            evt.preventDefault();
            deleteContact(evt);
        }
    );

    $(mainElement).find('form input[type="submit"]').click(
         function (evt) {
             evt.preventDefault(); // defeats default submit
             saveContact(); // save the form data 
         });

    function loadContacts() {
        var contactsStored = localStorage.getItem('contacts');
        if (contactsStored) { // check if we have any data
            contacts = JSON.parse(contactsStored); // convert data into an array of objects
            $.each(contacts, function (index, contact) {

                var row = $('<tr>'); // create an empty row object
                var html = '<td>' + contact.firstname + '</td>' +
                           '<td>' + contact.address + '</td>' +
                           '<td>' + contact.email + '</td>' +
                           '<td><a class="delete" href="#">delete</a></td>';

                //<tr contactID=""> addind a custom HTML attribute to the row, with a value of the ID
                row.data().contactId = contact.id;

                row.append(html); // attach html of td's to blank row
                $(mainElement).find('table tbody').append(row);
            });
        }
    }

    function serializeForm() {
        var inputFields = $(mainElement).find('form :input');
        var result = {};
        $.each(inputFields, function (index, value) {
            if ($(value).attr('name')) {
                result[$(value).attr('name')] = $(value).val();
            }
        });
        return result;
    }

    function store(contact) {
        // get string data for the whole array from storage
        var contactsStored = localStorage.getItem('contacts');
        var contacts = []; // create empty array
        if (contactsStored) { // if we have any data in storage
            contacts = JSON.parse(contactsStored); // load contacts array with that data
        }
        contacts.push(contact); // add new contact (push) to end of array
        // overwrite any existing 'contacts' key with new stringified array
        localStorage.setItem('contacts', JSON.stringify(contacts));
    }


    function saveContact() {
        var contact = serializeForm(); // get form data into an object

        contact.id = $.now(); // use clock as a unique key

        var row = $('<tr>');
        var html = '<td>' + contact.firstname + '</td>' +
                   '<td>' + contact.address + '</td>' +
                   '<td>' + contact.email + '</td>' +
                   '<td><a class="delete" href="#">delete</a></td>';

        row.data().contactId = contact.id;
        row.append(html);

        store(contact); // save record in local storage

        $(mainElement).find('table tbody').append(row);
        $(mainElement).find('form :input[name]').val('');
    }

    function deleteContact(evt) {
        //var link = evt.target
        // gbet the ID from the parent row of the selected link
        var contactId = $(evt.target).parents('tr').data().contactId;
        // get current data asa array from local storage
        var contacts = JSON.parse(localStorage.getItem('contacts'));

        // use JQuery to filter out the contacts with required ID to delete
        // for each element in contacts array, run function
        // if true, keep the element in selection, otherwise not
        // effectly deletes the item with id = ContactID
        var newContacts = contacts.filter(function (c) {
            return c.id != contactId;
        });
        // overwrite storage with new array
        localStorage.setItem('contacts', JSON.stringify(newContacts));

        // remove the parent row of the selected link
        $(evt.target).parents('tr').remove();
    }


});
