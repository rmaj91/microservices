sendMessage = () => {
        $.ajax('http://localhost:8080/send',
            {
                type: 'POST', success: (data, status) => {
                    console.log('MESSAGE SEND!');
                }
            })
}

$(document).ready(function() {
    $('#sendButton').on('click', sendMessage);
}
)