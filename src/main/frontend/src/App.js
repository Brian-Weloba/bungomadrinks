import './App.css';
import React, {useEffect, useState} from "react";
import axios from "axios";
import {
    alpha,
    AppBar,
    Card,
    CardContent,
    CardHeader,
    CardMedia,
    Container,
    createTheme,
    CssBaseline,
    Grid,
    IconButton,
    InputBase,
    Link,
    Toolbar,
    Typography,
} from "@mui/material";
import {styled, ThemeProvider} from "@mui/styles";
import SearchIcon from '@mui/icons-material/Search';
import {VisibilityTwoTone} from "@mui/icons-material";

const navbar = {
    backgroundColor: '#3a3d42',
};

const categories = {
    animationDuration: '3s',
};

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
            main: '#C96047',
        },
    },
});

const navElement = {
    color: '#ffffff',
    fontSize: '12pt',
    fontWeight: 'bold',
    textDecoration: 'none',
    paddingRight: '10px',
    cursor: 'pointer',
};


const card = {
    borderRadius: '0px',
    boxShadow: '0px 0px 0px 0px rgba(0,0,0,0.2), 0px 0px 0px 0px rgba(0,0,0,0.14), 0px 0px 0px 0px rgba(0,0,0,0.12)',
    border: '1px solid #C96047',
    backgroundColor: '#f4f4f4',
};

const img = {
    maxWidth: 250,
    minWidth: 200
}

const carddiv = {
    justifyContent: 'center',
    alignItems: 'center',
}

const icon = {
    position: 'absolute',
    left: '100px',

}

const Search = styled('div')(({theme}) => ({
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: alpha(theme.palette.primary.main, 0.15),
    '&:hover': {
        backgroundColor: alpha(theme.palette.secondary.main, 0.25),
    },
    marginLeft: 0,
    width: '100%',
    [theme.breakpoints.up('sm')]: {
        marginLeft: 1,
        width: 'auto',
    },
}));

const SearchIconWrapper = styled('div')(({theme}) => ({
    padding: theme.spacing(0, 2),
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
}));

const StyledInputBase = styled(InputBase)(({theme}) => ({
    color: 'inherit',
    '& .MuiInputBase-input': {
        padding: theme.spacing(1, 1, 1, 0),
        // vertical padding + font size from searchIcon
        paddingLeft: `calc(1em + ${theme.spacing(4)})`,
        transition: theme.transitions.create('width'),
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            width: '12ch',
            '&:focus': {
                width: '20ch',
            },
        },
    },
}));

function onLinkEnter(e) {
    e.target.style.color = '#C96047';
    e.target.style.animationDuration = '5s';
}

function onLinkLeave(e) {
    e.target.style.color = '#ffffff';
}

const Navbar = () => {


    return (
        <AppBar position="static" style={navbar}>
            <CssBaseline/>
            <Toolbar>
                <Typography variant="h4" className="logo">
                    Berny'z
                </Typography>
                <Search>
                    <SearchIconWrapper>
                        <SearchIcon/>
                    </SearchIconWrapper>
                    <StyledInputBase
                        placeholder="Search…"
                        inputProps={{'aria-label': 'search'}}
                    />
                </Search>
            </Toolbar>
            <Toolbar>
                <div style={categories}>
                    <Link onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/" style={navElement}>
                        Whiskey
                    </Link>
                    <Link onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/"
                          style={navElement}
                    >
                        Gin
                    </Link>
                    <Link onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/"
                          style={navElement}
                    >
                        Rum
                    </Link>
                    <Link onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/"
                          style={navElement}
                    >
                        Brandy
                    </Link>
                    <Link onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/"
                          style={navElement}
                    >
                        Vodka
                    </Link>
                    <Link onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/"
                          style={navElement}
                    >
                        Wines
                    </Link>
                    <Link onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/"
                          style={navElement}
                    >
                        Cans
                    </Link>
                </div>
            </Toolbar>
        </AppBar>
    )
        ;
}

const Categories = () => {
    const [categories, setCategories] = useState([]);

    const fetchCategories = () => {
        axios.get('http://localhost:8081/products/categories').then(response => {
            setCategories(response.data);
        });
    };

    useEffect(() => {
        fetchCategories();
    }, []);

    const list = [];
    for (let i = 0; i < categories.length; i++) {
        //if category name doesn't exist in list, do not add it
        if (!list.includes(categories[i].caqtegoryName)) {
            list.push(categories[i].caqtegoryName);
        }
    }

    return list;
}

const Products = () => {
    const [products, setProducts] = useState([]);

    const fetchProducts = () => {
        axios.get("http://localhost:8081/api/products").then(response => {
            console.log(response);
            setProducts(response.data);
        });
    }

    useEffect(() => {
        fetchProducts();
    }, []);


// return products.map((product,index) => {
//   return (
//     <div key={index}>
//       <h3>{product.name}</h3>
//     </div>
//   )
// })

    return products.map((product, index) => {
        const description = product.productShortDescription;
        const image = "https://bungomadrinks.s3.af-south-1.amazonaws.com/images/scaled-images/" + product.productImage;
        return (
            <ThemeProvider theme={theme}>
                <Grid item key={index}>
                    <Card sx={{maxWidth: 250, minWidth: 200}}
                          style={card}>
                        <CardMedia className="media"
                                   width="100"
                        >
                            <div style={carddiv}>
                                <img style={img} src={image} alt="product"/>
                                <IconButton style={icon}
                                            variant="contained"
                                            color={'secondary'}>
                                    <VisibilityTwoTone/>
                                </IconButton>
                            </div>
                        </CardMedia>
                        <CardHeader
                            title={product.productName}
                        />
                        <CardContent>
                            <Typography variant="body2" color="textPrimary" component="h1">
                                {product.productType}
                            </Typography>
                            {/*<Typography variant="body2" color="textSecondary" component="p">*/}
                            {/*    {description.slice(0, 50)}...*/}
                            {/*</Typography>*/}

                        </CardContent>
                    </Card>
                </Grid>
            </ThemeProvider>
        )
    });
}

function App() {
    return (
        <ThemeProvider theme={theme}>
            <div>
                <Navbar/>
                <Container
                    sx={{p: 8}}
                >
                    <div style={{marginTop: 80}}>
                        <Grid
                            justifyContent="start"
                            alignItems="flex-start"
                            container>
                            <Products/>
                        </Grid>
                    </div>
                </Container>
            </div>
        </ThemeProvider>

    );
}

export default App;
