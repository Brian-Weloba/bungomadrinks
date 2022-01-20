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
    let {id} = useParams()
    let url = "http://localhost:8081/api/products/" + id;
    let prodOptionsUrl = "http://localhost:8081/api/products/" + id + "/options";

    console.log("url: " + url);
    console.log("prodOptionsUrl: " + prodOptionsUrl);
    console.log("id: " + id);


    const [product, setProduct] = useState({});
    const [productOptions, setProductOptions] = useState([]);
    const [defaultOpt, setdefaultOpt] = useState({});
    const [price, setPrice] = useState(0);


    const fetchDetails = async () => {
        await axios.get(prodOptionsUrl)
            .then(res => {
                setProductOptions(res.data);
            });


        console.log("productOptions: " + productOptions);

        await axios.get(url).then(response => {
            setProduct(response.data);
        });

        console.log("product: ", product);

        let defaultOptUrl = "http://localhost:8081/api/products/" + id + "/options/" + product.defaultOption;

        console.log("defaultOptUrl: " + defaultOptUrl);

        await axios.get(defaultOptUrl).then(response => {
            let defaultOptionObject = response.data;
            console.log("defaultObject: ", defaultOptionObject);
            setdefaultOpt(defaultOptionObject);
            const optionPrice = defaultOptionObject.productOptionPrice;
            setPrice(optionPrice);
        });

        console.log("defaultOpt: ", defaultOpt);
        console.log("price: ", price);
    };

    useEffect(() => {
        console.log("useEffect");
        fetchDetails();
    }, []);

    const [selectedRadioButton, setSelectedRadioButton] = useState(0);

    const image = "https://bungomadrinks.s3.af-south-1.amazonaws.com/images/scaled-images/" + product.productImage;

    function handleChange(e) {
        console.log("e: ", typeof e.target.value);
        setSelectedRadioButton(e.target.value);
        console.log("productOptions: ", productOptions);

        let optionPrice = productOptions.find(option => option.productOptionId === Number(e.target.value)).productOptionPrice;
        setPrice(optionPrice);

    }

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
                            KES {price}
                        </Typography>
                        <FormControl>
                            <FormLabel id="demo-row-radio-buttons-group-label">Size</FormLabel>
                            <RadioGroup
                                row
                                aria-labelledby="demo-row-radio-buttons-group-label"
                                name="row-radio-buttons-group"
                                onChange={handleChange}
                                value={selectedRadioButton}
                                defaultValue={defaultOpt.defaultOptionId}
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
            {/*<Reccomended/>*/}
        </Container>
    );

}

export default Details;