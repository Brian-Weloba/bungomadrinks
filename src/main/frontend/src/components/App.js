import '../App.css';
import React from "react";
import {createTheme,} from "@mui/material";
import {ThemeProvider} from "@mui/styles";
import Footer from "./Footer";
import Navbar from "./Navbar";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Details from "./Details";
import Products from "./Products";
import ProductsByCategory from "./ProductsByCategory";

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
    const NotFound = () => {
        return (
            <div className={'page'}
                 style={
                     {
                         height: '80vh',
                         display: 'flex',
                         justifyContent: 'center',
                         alignItems: 'center',
                     }
                 }>
                <h1>404</h1>
                <h2>Page not found</h2>
            </div>
        );
    };

return (
    <Router>
        <ThemeProvider theme={theme}>
            <Navbar/>
            <Routes>
                <Route exact path="/" element={<Products/>}/>
                <Route path="category/:name" element={<ProductsByCategory/>}/>
                <Route path="category/:name/product/:id" element={<Details/>}/>
                <Route path={"product/:id"} element={<Details/>}/>
                <Route component={NotFound}/>
            </Routes>
            <Footer/>
        </ThemeProvider>
    </Router>

);
}


export default App;
