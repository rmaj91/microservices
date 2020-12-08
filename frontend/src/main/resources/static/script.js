const senderURL = 'http://localhost:8000/api/sender';
const receiverURL = 'http://localhost:8000/api/receiver';

sendMessage = () => {
    $.ajax(senderURL + '/send?message=' + $('#message').val() + '&description=' + $('#description').val(),
        {
            type: 'POST',
            success: (data, status) => {
                console.log('MESSAGE SEND!');
            },
            contentType: "application/json",
            data: {}
        });
}

receiveMessage = (data, status) => {
    $.ajax(receiverURL + '/events',
        {
            success: function (data, status) {
                $('#eventBody').empty();
                console.log(data)
                for(row of data) {
                    $('#eventBody').append(`<tr>
                                                <td>${row.id}</td>
                                                <td>${row.message}</td>
                                                <td>${row.description}</td>
                                                <td>${row.created}</td>
                                            </tr>`);
                }
            }
        });
}

$(document).ready(function() {
    $('#sendButton').on('click', sendMessage);
    $('#receiveButton').on('click', receiveMessage);
})