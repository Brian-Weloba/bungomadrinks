import {Container, Grid} from "@mui/material";
import Products from "./Products";
import React from "react";

const Home = () => {
    return (
        <Container
            style={{
                width: '100%',
                paddingLeft: '10px',
                paddingRight: '10px',
                marginLeft: 'auto',
                marginRight: 'auto',
            }}
        >
            <Grid
                style={{
                    height: "max-content",
                    marginTop: '50px',
                    justifyContent: 'center',
                    alignItems: 'stretch',
                }}
                container
                justify={'center'}
            >
                <Products/>
            </Grid>
        </Container>
    )
};

export default Home;