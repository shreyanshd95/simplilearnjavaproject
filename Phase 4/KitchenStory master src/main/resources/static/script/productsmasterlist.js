const productsEl = document.getElementById('productsmaster');

let productsArr = [];

// Loads product data 
const loadProducts = () => {
	var inputData;
	$.ajax({
		url: '/fetchdata',
		method: "GET",
		success(res) {
			inputData = JSON.parse(res);
			localStorage.setItem("inputData", JSON.stringify(inputData));
			var lsData = localStorage.getItem("inputData");
			productsArr = JSON.parse(lsData);
			displayProductsDOM(JSON.parse(lsData));
		},
		error(err) {
			alert('Could not fetch products !!', err);
		}
	});
};

// Renders products list on DOM
function displayProductsDOM(products) {
	productsEl.innerHTML = products.map(product => `
        <div class="product">
            <div class="product-info">
                <img src="${product.product_image_md}" alt="product-image" width="150" height="150">
                <h4>${product.product_name}</h4>
                <h5>Product ID: ${product._id}</h5>
                <h5>Price: ₹ ${product.product_price}</h5>
            </div>
        </div>
    `)
		.join('');

	// Add to cart button clicked
	$(".addBtn").on('click', addToCart);
}


loadProducts();