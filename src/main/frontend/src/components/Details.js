import React, {useEffect, useState} from 'react';
import axios from "axios";
import {useParams} from "react-router-dom";
import {
    Box,
    Card,
    CardContent,
    CardMedia,
    Container,
    FormControl,
    FormControlLabel,
    FormLabel,
    Radio,
    RadioGroup,
    Typography
} from "@mui/material";



function Details() {
    // const products = GetProducts();
    // console.log(products);

    let {id} = useParams();
    let url = "http://localhost:8081/api/products/" + id;
    let prodOptionsUrl = "http://localhost:8081/api/products/"+id+"/options";
    console.log(id);

    const [product, setProduct] = useState([]);
    const [productOptions, setProductOptions] = useState([]);
    const [selectedRadioButton, setSelectedRadioButton] = useState(product.defaultOption);

    function onSizeClick(e){
        setSelectedRadioButton(e.currentTarget.value);
    }


    const isRadioChecked = (value) =>{
       return  selectedRadioButton === value;
    }

    const fetchProductOptions = ()=>{
        axios.get(prodOptionsUrl)
            .then(res => {
                setProductOptions(res.data);
            })
            .catch(err => {
                console.log(err);
            });
    };


    const fetchProduct = () => {
        axios.get(url).then(response => {
            console.log("respone: ")
            console.log(response);
            setProduct(response.data);
        });
    }

    useEffect(() => {
        fetchProduct();
        fetchProductOptions();
    }, []);

    const image = "https://bungomadrinks.s3.af-south-1.amazonaws.com/images/scaled-images/" + product.productImage;



    const opt = product.productOptions;
    console.log("opt:", opt);

    const Options = () => {

       return productOptions.map((option, index) => {
           return (
            <FormControlLabel
                key={index}
                value={option.productOptionId}
                control={<Radio/>}
                label={option.optionVolume}
            />
           )
        });

    }

    return (
        <Container>
            <Card variant={'outlined'} sx={{
                margin: "10px",
                width: "max-content",
                borderRadius: "10px",
                padding: "5px",
                backgroundColor: "#ffffff",
                display: 'flex',
            }}>
                <CardMedia sx={{
                    borderRadius: "10px",
                    height: '400px', width: '400px'
                }} image={image}/>
                <Box sx={{
                    display: 'flex',
                    flexDirection: 'column',
                }}>
                    <CardContent sx={{
                        maxWidth: '700px',
                    }}>
                        <Typography component={"div"} variant={"h5"}>
                            {product.productName}
                        </Typography>
                        <Typography component={"div"} variant={"h5"}>
                            {product.productPrice}
                        </Typography>
                        <FormControl>
                            <FormLabel id="demo-row-radio-buttons-group-label">Size</FormLabel>
                            <RadioGroup
                                row
                                aria-labelledby="demo-row-radio-buttons-group-label"
                                name="row-radio-buttons-group"
                            >
                                <Options/>
                            </RadioGroup>
                        </FormControl>

                        <Typography component={"div"} variant={"subtitle1"}>
                            {product.productDescription}
                        </Typography>

                    </CardContent>
                </Box>
            </Card>
        </Container>
    );

}

export default Details;