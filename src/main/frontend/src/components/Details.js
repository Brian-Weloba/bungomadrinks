// import React, {useEffect, useState} from 'react';
// import axios from "axios";
//
// function Details(id){
//     const fetchProducts = () => {
//         axios.get("http://localhost:8081/api/product/"+id).then(response => {
//             console.log(response);
//             return response.data;
//         });
//     }
//
//     const product = fetchProducts();
//
//     return (
//         <div>
//             <h1>{product.productName}</h1>
//             <p>{product.productShortDescription}</p>
//         </div>
//     );
//
// }
//
// export default Details;