let carrito = [];

function agregarCarrito(nombre, precio){

    carrito.push({
        nombre,
        precio
    });

    actualizarContador();
    renderizarCarrito();
}

document.addEventListener("click", event => {
    const button = event.target.closest("[data-product-name][data-product-price]");

    if(!button){
        return;
    }

    agregarCarrito(button.dataset.productName, Number(button.dataset.productPrice));
});

function actualizarContador(){

    document.getElementById("contador-carrito").innerText = carrito.length;
}

function abrirCarrito(){

    document.getElementById("cart-panel")
        .classList.add("active");
}

function cerrarCarrito(){

    document.getElementById("cart-panel")
        .classList.remove("active");
}

function renderizarCarrito(){

    let contenedor = document.getElementById("cart-items");

    contenedor.innerHTML = "";

    let total = 0;

    carrito.forEach(producto => {

        total += producto.precio;

        contenedor.innerHTML += `
        
            <div class="cart-item">
                <h4>${producto.nombre}</h4>
                <p>S/${producto.precio}</p>
            </div>

        `;
    });

    document.getElementById("total")
        .innerText = `Total: S/${total}`;
}

function enviarWhatsApp(){

    if(carrito.length === 0){

        alert("Tu carrito está vacío");
        return;
    }

    let mensaje = "Hola, quiero realizar este pedido:%0A%0A";

    let total = 0;

    carrito.forEach(producto => {

        mensaje += `- ${producto.nombre} | S/${producto.precio}%0A`;

        total += producto.precio;
    });

    mensaje += `%0ATotal: S/${total}`;

    let numero = "975184139";

    let url = `https://wa.me/${numero}?text=${mensaje}`;

    window.open(url, "_blank");
}

const banners = [
    "/img/banner.jpg",
    "/img/banner1.jpg",
    "/img/banner2.jpg"
];

let bannerActual = 0;

function cambiarBanner(){

    const hero = document.getElementById("hero");

    if(!hero){
        return;
    }

    hero.classList.add("fade");

    setTimeout(() => {

        bannerActual++;

        if(bannerActual >= banners.length){
            bannerActual = 0;
        }

        hero.style.backgroundImage =
        `
        linear-gradient(rgba(255,255,255,0.50),
        rgba(255,255,255,0.50)),
        url('${banners[bannerActual]}')
        `;

        hero.classList.remove("fade");

    }, 500);
}

if(document.getElementById("hero")){
    setInterval(cambiarBanner, 4000);
}

/* SCROLL ANIMATION */

function revelar(){

    const reveals = document.querySelectorAll(".reveal");

    reveals.forEach(reveal => {

        const windowHeight = window.innerHeight;

        const revealTop = reveal.getBoundingClientRect().top;

        const revealPoint = 150;

        if(revealTop < windowHeight - revealPoint){

            reveal.classList.add("active");

        }
    });
}

window.addEventListener("scroll", revelar);

revelar();