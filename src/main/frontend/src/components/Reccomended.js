// import React, {useEffect, useState} from "react";
// import axios from "axios";
// import {Button, Card, CardContent, CardHeader, CardMedia, Grid, IconButton, Typography} from "@mui/material";
// import {ReadMore, Visibility} from "@mui/icons-material";
// import {Link} from "react-router-dom";
//
// const readMore = {
//     backgroundColor: '#ec702a',
//     borderRadius: '0%',
//     textDecoration: 'none',
// };
//
//
// const card = {
//     borderRadius: '0px',
//     boxShadow: '0px 0px 0px 0px rgba(0,0,0,0.2), 0px 0px 0px 0px rgba(0,0,0,0.14), 0px 0px 0px 0px rgba(0,0,0,0.12)',
//     border: '1px solid #ebebea',
//     backgroundColor: '#ffffff',
//     display: 'flex',
//     flexDirection: 'column',
//     justifyContent: 'center',
// };
//
// function onCardEnter(e) {
//     e.target.style.animationDuration = '5s';
//     e.target.style.filter = 'blur(5px) grayscale(80%)';
//     const card = e.target.parentNode.parentNode;
//     const button = card.querySelector('.button');
//     button.style.display = 'block';
// }
//
// function onCardExit(e) {
//     e.target.style.filter = 'blur(0px) grayscale(0%)';
//     const card = e.target.parentNode.parentNode;
//     const button = card.querySelector('.button');
//     button.style.display = 'none';
//
// }
//
// const carddiv = {
//     width: 250,
//     overflow: 'hidden',
//     justifyContent: 'center',
//     alignItems: 'center',
//     display: 'flex',
// }
//
// const img = {
//     width: 250,
// }
//
// const icon = {
//     color: '#ec702a',
//     fontSize: '20pt',
//     position: 'absolute',
//     cursor: 'pointer',
//     display: 'none',
//
// }
//
// const cardHeader = {
//     color: '#3a3d42',
//     height: '70px',
// }
//
// export const GetProducts = () => {
//     const [products, setProducts] = useState([]);
//
//     const fetchProducts = () => {
//         axios.get("/209.97.144.225:8081/api/products").then(response => {
//             console.log(response);
//             setProducts(response.data);
//         });
//     }
//
//     useEffect(() => {
//         fetchProducts();
//     }, []);
//
//     return products;
// };
//
// const Products = () => {
//
//
//     return GetProducts().map((product, index) => {
//         const image = process.env.PUBLIC_URL+"/assets/" + product.productImage;
//         const defaultOption = product.productOptions;
//
//         // const prodOptions = defaultOption.map(defaultOption);
//
//         const opt = defaultOption.find(option => option.productOptionId === product.defaultOption);
//
//         const getOptionPrice = () => {
//             if (opt === undefined) {
//                 return "1500".replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
//
//             } else {
//                 return opt.productOptionPrice.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
//             }
//         }
//
//         const getOptionVolume = () => {
//             if (opt === undefined) {
//                 return " ";
//             } else {
//                 return opt.optionVolume;
//             }
//         }
//
//         const optionPrice = getOptionPrice();
//         const optionVolume = getOptionVolume();
//
//         // const defOption = defaultOption();
//         console.log("viyrewgbiuvh")
//         console.log(optionPrice);
//
//         return (
//             <Grid container row>
//                 <Grid item key={index}>
//                     <Card sx={{width: 250, height: 'max-content'}}
//                           variant="outlined"
//                           style={card}>
//                         <CardMedia onMouseEnter={onCardEnter} onMouseLeave={onCardExit} className="media"
//                                    width="100"
//                                    style={carddiv}
//                         >
//                             <img style={img} src={image} alt="product"/>
//                             <IconButton className='button' style={icon}>
//                                 <Visibility
//                                     fontSize="large"
//                                 />
//                             </IconButton>
//                         </CardMedia>
//                         <CardHeader
//                             style={{
//                                 paddingTop: '5px',
//
//                                 alignContent: 'start',
//                                 alignItems: 'baseline',
//
//                             }}
//                             disableTypography={true}
//                             title={
//                                 <Typography variant="h6" style={cardHeader}>
//                                     {product.productName} {optionVolume}
//                                 </Typography>
//                             }
//
//                             subheader={
//                                 <Typography variant="subtitle1">
//                                     KES {optionPrice}
//                                 </Typography>
//                             }
//                         />
//                         <CardContent
//                             style={{textAlign: 'center'}}
//                         >
//
//                             <Link to={`product/${product.productId}`}>
//                                 <Button variant="contained" style={readMore}>
//                                     Read More <ReadMore/>
//                                 </Button>
//                             </Link>
//
//                         </CardContent>
//                     </Card>
//                 </Grid>
//             </Grid>
//
//         )
//     });
// }
//
//
// export default Products;