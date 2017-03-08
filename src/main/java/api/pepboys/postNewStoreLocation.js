var data = JSON.stringify({
    "storeKeys": [
        "07923"
    ]
});

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
    if (this.readyState === 4) {
        console.log(this.responseText);
    }
});

xhr.open("POST", "https://mstage.stage.pepboys.com/api/store/select");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("accept", "application/json, text/javascript, */*; q=0.01");
xhr.setRequestHeader("referer", "https://mstage.stage.pepboys.com/eserve/appointment/?_mwexperienceid=75b123b0-6444-4893-9825-1303473bc59f");
xhr.setRequestHeader("x-requested-with", "XMLHttpRequest");
xhr.setRequestHeader("dnt", "1");
xhr.setRequestHeader("cache-control", "no-cache");
xhr.setRequestHeader("postman-token", "e0be90ad-7771-6456-2d9b-5e632e05d446");

xhr.send(data);