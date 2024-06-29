const cartListEl = document.getElementById('cartList');
const totalEl = document.getElementById('total');
const checkoutEl = document.getElementById('checkout');

let products = [];

// Get cart items from local storage
const getProducts = () => {
	const temp = localStorage.getItem('cartArr');
	const cartArr = JSON.parse(temp);
	if (cartArr === null || cartArr === undefined) {
		alert('Could not get cart');
	} else {
		products = cartArr;
		displayCart();
		calculateCartTotal();
	}
};

// Display cart details
const displayCart = () => {
	cartListEl.innerHTML = `
        <tr>
            <th>Product</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Option</th>
        </tr>
    `;

	cartListEl.innerHTML += products.map(product => `
        <tr>
            <td><img src="${product.img}" alt="product-image" width="150" height="150"></td>
            <td><h4>${product.name}</h4></td>
            <td><h5>${product.price}</h5></td>
            <td>${product.qty}</td>
            <td><button id="${product._id}" class="removeBtn">Remove</button></td>
        </tr>
    `)
		.join('');

	// Enable remove item button
	$(".removeBtn").on('click', deleteFromCart);
};

// Delete item from cart
function deleteFromCart() {
	currId = this.id;
	// Update the cartArr
	for (const i in products) {
		if (products[i]._id === currId) {
			if (products[i].qty > 1) {
				products[i].qty -= 1;
			} else {
				products.splice(i, 1);
			}
		}
	}
	updateInLocalStorage();
	getProducts();
}

// Checkout function
function checkout() {
	var cartItems = localStorage.getItem('cartArr');
	var tempArr = JSON.parse(cartItems);
	if (tempArr.length == 0) {
		alert("Please add items into the cart.")
	} else {
		window.location.href = "./payment.html";
	}
}

//Update cart in local storage
function updateInLocalStorage() {
	localStorage.setItem('cartArr', JSON.stringify(products));
}

// Calculate cart total
function calculateCartTotal() {
	let cartTotal = 0;
	for (const product of products) {
		let currTotal = product.qty * product.price;
		cartTotal += currTotal;
	}
	updateCartTotal(cartTotal);
}

// Updates cart total in DOM and local storage
function updateCartTotal(cartTotal) {
	totalEl.innerHTML = ` TOTAL : ₹ ${cartTotal}`;
	localStorage.setItem('cartTotal', cartTotal);
}

checkoutEl.addEventListener('click', checkout);
getProducts();