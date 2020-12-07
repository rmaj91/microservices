sendMessage = () => {
        $.ajax('http://localhost:8080/send?message=' + $('#valueInput').val() + '&description=' + $('#description').val(),
            {
                type: 'POST',
                success: (data, status) => {
                    console.log('MESSAGE SEND!');
                }
            });
}

receiveMessage = (data, status) => {
    $.ajax('http://localhost:8081/events',
        {
            success: function (data, status) {
                $('#eventBody').empty();
                console.log(data)
                for(row of data) {
                console.log(row)
                    $('#eventBody').append(`<tr><td>${row.someId}</td><td>${row.additionalData}</td><td>${row.description}</td></tr>`);
                }
            }
        });
}

$(document).ready(function() {
    $('#sendButton').on('click', sendMessage);
    $('#receiveButton').on('click', receiveMessage);
})