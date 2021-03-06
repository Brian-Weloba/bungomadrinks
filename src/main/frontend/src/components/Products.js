import React, { useEffect, useState } from "react";
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
  Typography,
} from "@mui/material";
import { Close, ReadMore, Visibility } from "@mui/icons-material";
import { Link, useParams } from "react-router-dom";
import DialogActions from "@mui/material/DialogActions";
import "./Products.css";

const readMore = {
  backgroundColor: "#a71e22",
  borderRadius: "0%",
  width: "100%",
  margin: "0px",
  fontSize: "1rem",
  textDecoration: "none",
};

const card = {
  borderRadius: "10px",
  margin: "10px",
  // boxShadow: '0px 0px 0px 0px rgba(0,0,0,0.2), 0px 0px 0px 0px rgba(0,0,0,0.14), 0px 0px 0px 0px rgba(0,0,0,0.12)',
  border: "1px solid #ebebea",
  backgroundColor: "#ffffff",
  display: "flex",
  flexDirection: "column",
  justifyContent: "center",
  maxWidth: "250px",
  minWidth: "200px",
};

function onCardEnter(e) {
  e.target.style.animationDuration = "5s";
  e.target.style.filter = "blur(5px) grayscale(80%)";
  const card = e.target.parentNode.parentNode;
  const button = card.querySelector(".button");
  button.style.display = "block";
}

function onCardExit(e) {
  e.target.style.filter = "blur(0px) grayscale(0%)";
  const card = e.target.parentNode.parentNode;
  const button = card.querySelector(".button");
  button.style.display = "none";
}

const carddiv = {
  minWidth: 100,
  maxWidth: 250,
  overflow: "hidden",
  justifyContent: "center",
  alignItems: "center",
  display: "flex",
};

const img = {
  width: "100%",
  minWidth: 100,
  minHeight: 100,
  maxHeight: 250,
  maxWidth: 250,
};

const icon = {
  color: "#a71e22",
  fontSize: "20pt",
  position: "absolute",
  cursor: "pointer",
  display: "none",
};

export const GetProducts = () => {
  const [products, setProducts] = useState([]);

  const fetchProducts = () => {
    axios.get("https://bernyz.co.ke/api/products").then((response) => {
      // console.log(response);
      setProducts(response.data);
    });
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return products;
};

const Home = () => {
  let { name } = useParams();
  const [open, setOpen] = useState(false);
  const [imageUrl, setImageUrl] = useState("");
  const [productId, setProductId] = useState("");
  const ProductsGrid = () => {
    function handleOpen(img, id) {
      setOpen(true);
      setImageUrl(img);
      setProductId(id);
    }

    return GetProducts(name).map((product, index) => {
      const image = process.env.PUBLIC_URL + "/assets/" + product.productImage;
      const defaultOption = product.productOptions;

      // const prodOptions = defaultOption.map(defaultOption);

      const opt = defaultOption.find(
        (option) => option.productOptionId === product.defaultOption
      );

      const getOptionPrice = () => {
        if (opt === undefined) {
          return "1500".replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
        } else {
          return opt.productOptionPrice
            .toString()
            .replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
        }
      };

      const getOptionVolume = () => {
        if (opt === undefined) {
          return " ";
        } else {
          return opt.optionVolume;
        }
      };

      const optionPrice = getOptionPrice();
      const optionVolume = getOptionVolume();

      // const defOption = defaultOption();
      // console.log("viyrewgbiuvh")
      // console.log(optionPrice);

      return (
        <Grid item key={index}>
          <Card
            className="cards"
            // sx={{width: 250, minWidth: 100, maxWidth: 250, height: "max-content" }}
            // variant="outlined"
            raised={true}
            style={card}
          >
            <CardMedia
              onMouseEnter={onCardEnter}
              onMouseLeave={onCardExit}
              className="media"
              maxWidth="100"
              style={carddiv}
            >
              <img style={img} src={image} alt="product" />
              <IconButton
                onClick={() => handleOpen(image, product.productId)}
                className="button"
                style={icon}
              >
                <Visibility fontSize="large" />
              </IconButton>{" "}
            </CardMedia>{" "}
            <CardHeader
              style={{
                paddingTop: "5px",

                alignContent: "start",
                alignItems: "baseline",
              }}
              disableTypography={true}
              title={
                <h6 className="cardHeader">
                  {" "}
                  {product.productName} - {optionVolume}{" "}
                </h6>
              }
              subheader={
                <h6
                  style={{
                    fontSize: "20px",
                    marginTop: "0px",
                    marginBottom: "0px",
                    color: "#a71e22",
                  }}
                >
                  {" "}
                  KES {optionPrice}{" "}
                </h6>
              }
            />{" "}
            <CardContent style={{ textAlign: "center" }}>
              <Link
                to={`product/${product.productId}`}
                style={{
                  textDecoration: "none",
                }}
              >
                <Button variant="contained" style={readMore}>
                  Read More <ReadMore />
                </Button>{" "}
              </Link>{" "}
            </CardContent>{" "}
          </Card>{" "}
        </Grid>
      );
    });
  };

  // function CustomPagination() {
  //     const apiRef = useGridApiContext();
  //     const page = useGridSelector(apiRef, gridPageSelector);
  //     const pageCount = useGridSelector(apiRef, gridPageCountSelector);
  //
  //     return (
  //         <Pagination
  //             color="primary"
  //             count={pageCount}
  //             page={page + 1}
  //             onChange={(event, value) => apiRef.current.setPage(value - 1)}
  //         />
  //     );
  // }

  const Products = () => {
    function handleClose() {
      setOpen(false);
    }

    function handleClick(event) {
      event.preventDefault();
      console.info("You clicked a breadcrumb.");
    }

    return (
      <Box
        className={"products"}
        style={{
          // backgroundColor: '#ff9d00',
          // backgroundImage: `url(${bg})`,
          // background-image: linear-gradient(to bottom, #211f2a, #4b4a53, #7a7980, #adacb0, #e2e2e2);
          // backgroundImage: "linear-gradient(to bottom, #211f2a, #4b4a53, #7a7980, #adacb0, #e2e2e2)",
          // backgroundAttachment: 'scroll',
          // backgroundSize: 'cover',
          width: "100vw",
          //   paddingLeft: "20px",
          //   paddingRight: "20px",
          // justifyContent: 'center',
          textAlign: "center",
          display: "inline-block",
          alignItems: "center",
          paddingTop: "50px",
          minHeight: "70vh",

          marginTop: "100px",
        }}
      >
        <Grid
          style={{
            width: "100%",
            display: "flex",
            flexWrap: "wrap",
            justifyContent: "center",
            alignItems: "flex-start",
            alignContent: "flex-start",
            alignSelf: "flex-start",
            paddingTop: "20px",
            paddingBottom: "50px",
          }}
          container
        >
          <ProductsGrid />
        </Grid>{" "}
        <Dialog open={open} onClose={handleClose} keepMounted>
          <DialogTitle
            style={{
              display: "flex",
              justifyContent: "end",
            }}
          >
            <IconButton onClick={handleClose}>
              <Close style={{}} fontSize={"large"} />{" "}
            </IconButton>{" "}
          </DialogTitle>{" "}
          <DialogContent
            style={{
              overflow: "hidden",
            }}
          >
            <img
              style={{
                objectFit: "contain",
                height: "100%",
                width: "100%",
                maxWidth: "600px",
                maxHeight: "500px",
              }}
              src={imageUrl}
              alt="product"
            ></img>{" "}
          </DialogContent>{" "}
          <DialogActions>
            <Link
              to={`product/${productId}`}
              style={{
                textDecoration: "none",
              }}
            >
              <Button variant="contained" style={readMore}>
                Read More <ReadMore />
              </Button>{" "}
            </Link>{" "}
          </DialogActions>{" "}
        </Dialog>{" "}
      </Box>
    );
  };

  return <Products />;
};

export default Home;
