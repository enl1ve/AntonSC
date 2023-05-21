<#import "templ/templ.ftl" as p>
<@p.pages>

    <h1>Product - ${product.description}</h1>

    <p>${product.id}</p>
    <p>${product.description}</p>
    <p>${product.image}</p>
    <p>${product.name}</p>
    <p>${product.price}</p>
    <p>${product.categories.name}</p>

</@p.pages>