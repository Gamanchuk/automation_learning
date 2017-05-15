var data = JSON.stringify({
    "storeKeys": [
        "<KEY>"
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
xhr.setRequestHeader("x-requested-with", "XMLHttpRequest");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);