function waitPageLoading() {
    setTimeout(function() {
        const loadingPage = document.getElementById("loading-page");
        const [container] = document.getElementsByClassName("container");
        const header = document.getElementById("main-header").firstElementChild;

        loadingPage.style.display = "none";
        header.style.display = "flex";
        container.style.display = "grid";
    }, 2000);
}

waitPageLoading();

const post_quote = function() {
    const response = fetch('https://mocki.io/v1/d3df09d8-3ba7-4f45-af35-4a2b0cac005f', {
        method: "GET",
        headers: {
            'Content-type': 'application/json'
        },
    })
    response.then((response) => response.json()).then((value) => {
        const post = document.getElementById("post-quote");

        for (let key of value) {
            let str = `<div class="post-data" id="post-${key.OrderID}">
            <p>
Order Id: ${key.OrderID}<br/>
Order Date:${key.OrderDate}<br/>
Shipping Cost: ${key.ShippingCost}<br/>
Total Cost:${key.TotalCost}<br/></p></div>`
            let pro = str;
            str += `<div id="post-interactions">
<div id="interactions-btns">
    <button id="button-${key.OrderID}">
            Approval
        </button>
</div>
</div>`;
            let ele = document.createElement('article');
            ele.id = "post";
            ele.innerHTML = str;
            post.appendChild(ele);
            document.getElementById(`post-${key.OrderID}`).addEventListener("click", () => {
                var nw = window.open("", "_blank", 'height=650, width=650');
                nw.document.write(pro);
                nw.document.close();
                nw.print();
            });

            document.getElementById(`button-${key.OrderID}`).addEventListener("click", (evt) => {
                evt.stopImmediatePropagation();
            });
        }


    });
}

const post_order = function() {
    const response = fetch('https://mocki.io/v1/0e908e4f-8446-40eb-8acd-10b6e63306cb', {
        method: "GET",
        headers: {
            'Content-type': 'application/json'
        },
    })
    response.then((response) => response.json()).then((value) => {
        const post = document.getElementById("post-order");

        for (let key of value) {
            let str = `<div class="post-data" id="post-${key.OrderID}">
            <p>
Order Id: ${key.OrderID}<br/>
Order Date:${key.OrderDate}<br/>
Shipping Cost: ${key.ShippingCost}<br/>
Total Cost:${key.TotalCost}<br/></p></div>`
            let pro = str;
            str += `<div id="post-interactions">
<div id="interactions-btns">
    <button id="button-${key.OrderID}">
            Invoice
        </button>
</div>
</div>`;
            let ele = document.createElement('article');
            ele.id = "post";
            ele.innerHTML = str;
            post.appendChild(ele);

            document.getElementById(`button-${key.OrderID}`).addEventListener("click", () => {
                var nw = window.open("", "_blank", 'height=650, width=650');
                nw.document.write(pro);
                nw.document.close();
                nw.print();
            });
        }


    });
}

const fun = function() {
    post_order();
    post_quote();
    document.getElementById("post-order-btn").addEventListener("click", () => {
        document.getElementById("post-order-btn").style.backgroundColor = "rgb(255, 73, 85)";
        document.getElementById("post-order-btn").style.color = "white";
        document.getElementById("post-quote-btn").style.backgroundColor = "white";
        document.getElementById("post-quote-btn").style.color = "rgb(255, 73, 85)";
        document.getElementById("post-quote").style.display = "none";
        document.getElementById("post-order").style.display = "block";
    });
    document.getElementById("post-quote-btn").addEventListener("click", () => {
        document.getElementById("post-quote-btn").style.backgroundColor = "rgb(255, 73, 85)";
        document.getElementById("post-quote-btn").style.color = "white";
        document.getElementById("post-order-btn").style.backgroundColor = "white";
        document.getElementById("post-order-btn").style.color = "rgb(255, 73, 85)";
        document.getElementById("post-order").style.display = "none";
        document.getElementById("post-quote").style.display = "block";
    });
}

fun();