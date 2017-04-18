var data = JSON.stringify({
    "storeKeys": [
        "00828"
    ]
});

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
    if (this.readyState === 4) {
        console.log(this.responseText);
    }
});

xhr.open("POST", "<URL>api/store/select");
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("accept", "application/json, text/javascript, */*; q=0.01");
xhr.setRequestHeader("referer", "<URL>eserve/appointment/?_mwexperienceid=75b123b0-6444-4893-9825-1303473bc59f");
xhr.setRequestHeader("x-requested-with", "XMLHttpRequest");
xhr.setRequestHeader("dnt", "1");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);