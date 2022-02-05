import React, {useEffect, useState} from "react";
import axios from "axios";
import {
    Box,
    Button,
    Card,
    CardContent,
    CardHeader,
    CardMedia,
    Dialog,
    DialogContent,
    DialogTitle,
    Grid,
    IconButton,
    Typography
} from "@mui/material";
import {Close, ReadMore, Visibility} from "@mui/icons-material";
import {Link, useParams} from "react-router-dom";
import DialogActions from '@mui/material/DialogActions';

const readMore = {
    backgroundColor: '#a71e22',
    borderRadius: '0%',
    textDecoration: 'none',
};


const card = {
    borderRadius: '10px',
    margin: '10px',
    // boxShadow: '0px 0px 0px 0px rgba(0,0,0,0.2), 0px 0px 0px 0px rgba(0,0,0,0.14), 0px 0px 0px 0px rgba(0,0,0,0.12)',
    border: '1px solid #ebebea',
    backgroundColor: '#ffffff',
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
};

function onCardEnter(e) {
    e.target.style.animationDuration = '5s';
    e.target.style.filter = 'blur(5px) grayscale(80%)';
    const card = e.target.parentNode.parentNode;
    const button = card.querySelector('.button');
    button.style.display = 'block';
}

function onCardExit(e) {
    e.target.style.filter = 'blur(0px) grayscale(0%)';
    const card = e.target.parentNode.parentNode;
    const button = card.querySelector('.button');
    button.style.display = 'none';

}

const carddiv = {
    width: 250,
    overflow: 'hidden',
    justifyContent: 'center',
    alignItems: 'center',
    display: 'flex',
}

const img = {
    width: 250,
}

const icon = {
    color: '#a71e22',
    fontSize: '20pt',
    position: 'absolute',
    cursor: 'pointer',
    display: 'none',

}

const cardHeader = {
    color: '#211f2a',
    height: '70px',
}

function GetProducts(name) {
    const [products, setProducts] = useState([]);

    const fetchProducts = () => {
        axios.get(`/209.97.144.225:8081/api/products/categories/get?name=${name}`).then(response => {
            // console.log(response);
            setProducts(response.data);
        });
    }

    useEffect(() => {
        fetchProducts();
    }, []);

    return products;
};

const ProductsByCategory = () => {
    const [open, setOpen] = useState(false);
    const [imageUrl, setImageUrl] = useState('');
    const [productId, setProductId] = useState('');

    let {name} = useParams();

    const ProductsGrid = () => {


        function handleOpen(img, id) {
            setOpen(true);
            setImageUrl(img);
            setProductId(id);
        }


        const FullscreenImage = (image) => {
            return (
                <Box>
                    <img src={image} alt=""/>
                </Box>
            )
        }

        return GetProducts(name).map((product, index) => {
            const image = process.env.PUBLIC_URL+"/assets/" + product.productImage;
            const defaultOption = product.productOptions;

            // const prodOptions = defaultOption.map(defaultOption);

            const opt = defaultOption.find(option => option.productOptionId === product.defaultOption);

            const getOptionPrice = () => {
                if (opt === undefined) {
                    return "1500".replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");

                } else {
                    return opt.productOptionPrice.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
                }
            }

            const getOptionVolume = () => {
                if (opt === undefined) {
                    return " ";
                } else {
                    return opt.optionVolume;
                }
            }

            const optionPrice = getOptionPrice();
            const optionVolume = getOptionVolume();

            // const defOption = defaultOption();
            // console.log("viyrewgbiuvh")
            // console.log(optionPrice);

            return (
                <Grid item key={index}>
                    <Card sx={{width: 250, height: 'max-content'}}
                          variant="outlined"
                          style={card}>
                        <CardMedia onMouseEnter={onCardEnter}
                                   onMouseLeave={onCardExit}
                                   className="media"
                                   width="100"
                                   style={carddiv}
                        >
                            <img style={img} src={image} alt="product"/>
                            <IconButton onClick={() => handleOpen(image, product.productId)} className='button'
                                        style={icon}>
                                <Visibility
                                    fontSize="large"
                                />
                            </IconButton>
                        </CardMedia>
                        <CardHeader
                            style={{
                                paddingTop: '5px',

                                alignContent: 'start',
                                alignItems: 'baseline',

                            }}
                            disableTypography={true}
                            title={
                                <Typography variant="h6" style={cardHeader}>
                                    {product.productName} - {optionVolume}
                                </Typography>
                            }

                            subheader={
                                <Typography variant="subtitle1">
                                    KES {optionPrice}
                                </Typography>
                            }
                        />
                        <CardContent
                            style={{textAlign: 'center'}}
                        >

                            <Link to={`product/${product.productId}`}
                                  style={{
                                      textDecoration: 'none',
                                  }}>
                                <Button variant="contained" style={readMore}>
                                    Read More <ReadMore/>
                                </Button>
                            </Link>

                        </CardContent>
                    </Card>
                </Grid>
            )


        });
    }

    const Products = () => {

        function handleClose() {
            setOpen(false);
        }

        return (
            <Box className={'products'}
                 style={{
                     // backgroundColor: '#fafafa',
                     width: '100vw',
                     paddingLeft: '20px',
                     paddingRight: '20px',
                     // justifyContent: 'center',
                     textAlign: 'center',
                     display: 'inline-block',
                     alignItems: 'center',
                     paddingTop: '50px',
                     marginTop: '100px',
                     minHeight: '70vh',
                 }}
            >
                <Grid
                    style={{
                        width: '100%',
                        display: 'flex',
                        flexWrap: 'wrap',
                        justifyContent: 'center',
                        alignItems: 'flex-start',
                        alignContent: 'flex-start',
                        alignSelf: 'flex-start',
                        paddingTop: '20px',
                        paddingBottom: '50px',
                    }}
                    container
                >
                    <ProductsGrid/>
                </Grid>
                <Dialog
                    open={open}
                    onClose={handleClose}
                    keepMounted

                >
                    <DialogTitle style={{
                        display: 'flex',
                        justifyContent: 'end',
                    }}>
                        <IconButton onClick={handleClose}>
                            <Close style={{}} fontSize={'large'}/>
                        </IconButton>
                    </DialogTitle>
                    <DialogContent
                        style={{
                            overflow: 'hidden',
                        }}

                    >
                        <img style={{
                            objectFit: 'contain',
                            height: "100%",
                            width: "100%",
                            maxWidth: '600px',
                            maxHeight: '500px',

                        }} src={imageUrl} alt="product">

                        </img>
                    </DialogContent>
                    <DialogActions>
                        <Link to={`product/${productId}`}
                              style={{
                                  textDecoration: 'none',
                              }}>
                            <Button variant="contained" style={readMore}>
                                Read More <ReadMore/>
                            </Button>
                        </Link>
                    </DialogActions>
                </Dialog>
            </Box>
        )
    }

    return (
        <Products/>
    )
}


export default ProductsByCategory;