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

const fun = function() {
    const response = fetch('https://mocki.io/v1/3daa852c-7643-44b5-b8dd-1cff8d7167b0', {
        method: "GET",
        headers: {
            'Content-type': 'application/json'
        },
    })
    response.then((response) => response.json()).then((value) => {
        const post = document.getElementById("main-section");

        for (let key of value) {
            let pro = "";
            let p = "";
            let totalOrder = 0;
            for (let Product of key.Product) {
                pro += "<br>&nbsp;Product Id: " + Product.ProductId;
                pro += "  Product Name: " + Product.ProductName;
                pro += "  Product Price" + Product.ProductPrice;
                pro += "  Product Level" + Product.ProductLevel;
                totalOrder += Number(Product.ProductPrice);
            }
            let str = `<div id="post-author">
        <div>
            <strong>${key.CustomerId}</strong>
        </div>
        <div>
            <span>${key.OrderDate}</span>
        </div>
        </div>
        <div id="post-data">
            <p>
Unique Order Id: ${key.UniqueOrderId}<br/>
Customer Address:${key.CustomerAddress}<br/>
Product List : ${pro} <br/>
Total Order:${totalOrder}<br/>
Status:<span id="status-${key.UniqueOrderId}">${key.Status}</span><br/>

            </p></div>`;
            p = str;
            str += `
    <div id="post-interactions">
        <div id="interactions-btns">
            <button id="btn-${key.UniqueOrderId}">
                    Approval
                </button>
                <button id="${key.UniqueOrderId}" >
                    Invoice
                </button>
        </div>
    </div>`;
            let ele = document.createElement('article');
            ele.id = "post";
            ele.innerHTML = str;
            post.appendChild(ele);
            document.getElementById(`${key.UniqueOrderId}`).addEventListener("click", () => {
                var nw = window.open("", "_blank", 'height=650, width=650');
                nw.document.write(p);
                nw.document.close();
                nw.print();
            });

            if (key.Status == "Pending" || key.Status == "Expired")
                document.getElementById(`${key.UniqueOrderId}`).disabled = true;

            document.getElementById(`btn-${key.UniqueOrderId}`).addEventListener("click", () => {
                if (key.Status == "Pending") {
                    document.getElementById(`status-${key.UniqueOrderId}`).innerHTML = "Approved";
                    document.getElementById(`${key.UniqueOrderId}`).disabled = false;
                }

            });
        }


    });
}

fun();
waitPageLoading();