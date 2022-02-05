import React, {useEffect, useState} from 'react';
import axios from "axios";
import {useParams} from "react-router-dom";
import {
    Box,
    Card,
    CardContent,
    CardMedia,
    FormControl,
    FormControlLabel,
    FormLabel,
    Radio,
    RadioGroup,
    Typography
} from "@mui/material";
import './Products.css';


function Details() {


    let {id} = useParams()
    let url = "/209.97.144.225:8081/api/products/" + id;
    let prodOptionsUrl = "/209.97.144.225:8081/api/products/" + id + "/options";

    // let defaultOption = {};
    // let price = 0;
    // let selectedOption = 0;
    // let selectedRadioButton = 0;

    // console.log("url: " + url);
    // console.log("prodOptionsUrl: " + prodOptionsUrl);
    // console.log("id: " + id);


    const [product, setProduct] = useState({});
    const [productOptions, setProductOptions] = useState([]);
    const [defaultOption, setDefaultOption] = useState({});
    const [price, setPrice] = useState(0);
    const [selectedOption, setSelectedOption] = useState(0);
    const [selectedRadioButton, setSelectedRadioButton] = useState(0);

    const fetchDetails = () => {


        axios.get(prodOptionsUrl)
            .then(res => {
                // console.log("productOptions Res: ", res.data);
                setProductOptions(res.data);
                // console.log("product ip:", product);
            });

        axios.get(url).then(response => {
            // console.log("product res: ", response.data);
            setProduct(response.data);
            const prod = response.data;
            // console.log("response.data: ", response.data);
            // console.log("product == ", prod);
            const defaultOptionObject = prod.productOptions
            // console.log("defaultOptionObject: ", defaultOptionObject);
            // console.log("dOO", typeof defaultOptionObject[0].productOptionId);
            const defOpt = defaultOptionObject.find(option => option.productOptionId === prod.defaultOption);
            setDefaultOption(defOpt);
            // console.log("defaultOption: ", defOpt);
            setPrice(defOpt.productOptionPrice);
            setSelectedOption(defOpt.productOptionId);
            // console.log("price: ", price);
            // console.log("selectedOption: ", selectedOption);
            setSelectedRadioButton(defOpt.productOptionId);

        });

    }


    useEffect(() => {
        fetchDetails();
    }, []);


// console.log("useEffect product: ", product);
// console.log("prod: ", product);
// console.log("prodOptions: ", productOptions);


    const image = process.env.PUBLIC_URL+"/assets/" + product.productImage;

    function handleChange(e) {
        // console.log("e: ", typeof e.target.value);
        setSelectedRadioButton(e.target.value);
        // console.log("productOptions: ", productOptions);

        let optionPrice = productOptions.find(option => option.productOptionId === Number(e.target.value)).productOptionPrice;
        setPrice(optionPrice);

    }

// const defOpt = product.productOptions.find(option => option.productOptionId === Number(product.defaultOption));
// console.log("defOpt: ", defOpt);
// const defPrice = productOptions.find(option => option.productOptionId === Number(defaultOpt.productOptionId)).productOptionPrice;

    const Options = () => {
        // fetchPrice(product);
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
    const bg = process.env.PUBLIC_URL + '/rainbow-vortex.svg';

    return (
        <Box className={'products'}
            style={{
                // backgroundImage: `url(${bg})`,
                // backgroundSize: 'cover',
                // backgroundAttachment: 'scroll',
                justifyContent: 'center',
                display: 'flex',
                paddingTop: '50px',
                paddingBottom: '50px',
                marginTop: '100px',
                minHeight: '70vh',

            }}
        >
            <Card
                raised
                sx={{
                    backgroundColor: '#f4f4f4',
                    width: "max-content",
                    borderRadius: "10px",
                    padding: "5px",
                    backgroundAttachment: '',
                    backgroundSize: 'cover',
                    display: 'flex',
                }}>
                <CardMedia

                    sx={{
                        // border: '3px solid #a71e22',
                        borderRadius: "10px",
                        height: '400px', width: '400px',

                    }}

                    image={image}/>
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
                            KES {price.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,")}                        </Typography>
                        <FormControl>
                            <FormLabel id="demo-row-radio-buttons-group-label">Size</FormLabel>
                            <RadioGroup
                                row
                                aria-labelledby="demo-row-radio-buttons-group-label"
                                name="row-radio-buttons-group"
                                onChange={handleChange}
                                value={selectedRadioButton}
                                defaultValue={selectedRadioButton}
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
        </Box>
    );

}

export default Details;