import '../App.css';
import React from "react";
import {createTheme,} from "@mui/material";
import {ThemeProvider} from "@mui/styles";
import Footer from "./Footer";
import Navbar from "./Navbar";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Home from "./Home";
import Details from "./Details";
import Products from "./Products";

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
        <Router>
            <ThemeProvider theme={theme}>
                <Navbar/>
                <Routes>
                    <Route exact path="/" element={<Products/>}/>
                    <Route path={"product/:id"} element={<Details/>}/>
                </Routes>
                <Footer/>
            </ThemeProvider>
        </Router>

    );
}


export default App;
