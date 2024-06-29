const productsEl = document.getElementById('products');
const cartBtnEl = document.getElementById('cartBtn');

let cartArr;
let productsArr = [];

// Loads previous cart array
function getCartArr() {
	const temp = localStorage.getItem('cartArr');
	const temp2 = JSON.parse(temp);
	if (temp2 === null || temp2 === undefined) {
		cartArr = [];
		localStorage.setItem('cartArr', JSON.stringify(cartArr));
	} else {
		cartArr = temp2;
	}
}

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
                <h5>Price: ₹ ${product.product_price}</h5>
                <button id="${product._id}" class="addBtn">+ Add to cart</button>
            </div>
        </div>
    `)
		.join('');

	// Add to cart button clicked
	$(".addBtn").on('click', addToCart);
}

// Checks if item is already present in the cart
function isItemInCart(currId) {
	for (const product of cartArr) {
		if (currId === product._id) {
			product['qty'] += 1;
			return true;
		}
	}
	return false;
}

// Add to cart function
function addToCart(e) {
	const currId = this.id;
	let item = {};

	// Check if item is already in cart
	if (!isItemInCart(currId)) {
		for (const product of productsArr) {
			if (product._id === currId) {
				item['name'] = product.product_name;
				item['price'] = product.product_price;
				item['img'] = product.product_image_sm;
				item['_id'] = product._id;
				item['qty'] = 1;
				cartArr.push(item);
			}
		}
	}
	alert('Item added to cart');
}


// Save user cart to local storage
function saveCartToLocal() {
	localStorage.setItem('cartArr', JSON.stringify(cartArr));
}

//Display cart
function displayCart() {
	saveCartToLocal();
	window.location.href = "./cart.html";
}

cartBtnEl.addEventListener('click', displayCart);

loadProducts();
getCartArr();