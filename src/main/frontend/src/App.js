import './App.css';
import React from "react";
import {Container, createTheme, Grid,} from "@mui/material";
import {ThemeProvider} from "@mui/styles";
import Footer from "./components/Footer";
import Products from "./components/Products";
import Navbar from "./components/Navbar";
import Details from "./components/Details";

const theme = createTheme({
    shape: {
        borderRadius: 4,
    },
    palette: {
        type: 'light',
        primary: {
            main: '#3a3d42',
        },
        secondary: {
            main: '#ec702a',
        },
    },
});

function App() {
    return (
        <ThemeProvider theme={theme}>
            <Navbar/>
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
                        marginTop: '50px',
                        justifyContent: 'center',
                    }}
                    container
                    justify={'center'}
                >
                    <Products/>
                </Grid>
            </Container>
            <Footer/>
        </ThemeProvider>

    );
}

export default App;
