var data = "itemId=<ITEM_ID>";

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
    if (this.readyState === 4) {
        console.log(this.responseText);
    }
});

xhr.open("POST", "<URL>cart/ajax/remove");
xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
xhr.setRequestHeader("accept", "*/*");
xhr.setRequestHeader("referer", "<URL>cart?iCID=header-mobile_header_cart_image");
xhr.setRequestHeader("x-requested-with", "XMLHttpRequest");

xhr.send(data);