let csrfHead = "X-XSRF-TOKEN";
let csrf = $.cookie("XSRF-TOKEN");

$.ajaxSetup({
    beforeSend: function(xhr, settings){
        xhr.setRequestHeader(csrfHead, csrf);
    }
})

