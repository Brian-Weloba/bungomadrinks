import {AppBar, CssBaseline, InputBase, Link, Toolbar} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import React from "react";
import {styled} from "@mui/styles";
import {Link as RouterLink} from "react-router-dom";

const navbar = {
    backgroundColor: '#3a3d42',
};


const categories = {
    animationDuration: '3s',
};


const navElement = {
    color: '#ffffff',
    fontSize: '12pt',
    fontWeight: 'bold',
    paddingRight: '10px',
    cursor: 'pointer',
};

const Search = styled('div')(({theme}) => ({
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: '#ffffff',
    '&:hover': {
        backgroundColor: '#ffffff',
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
    color: theme.palette.secondary.main,
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
}));

const StyledInputBase = styled(InputBase)(({theme}) => ({
    color: '#3a3d42',
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
    e.target.style.color = '#ec702a';
    e.target.style.animationDuration = '5s';
}

function onLinkLeave(e) {
    e.target.style.color = '#ffffff';
}


const Navbar = () => {

    return (
        <AppBar position="static" style={navbar}>
            <CssBaseline/>
            <Toolbar
                style={{
                    paddingTop: '10px',
                    display: 'flex',
                    justifyContent: 'space-between',
                }}
            >
                <RouterLink to={"/"}>
                    <img src={process.env.PUBLIC_URL + '/logo-white.png'} height={80}/>
                </RouterLink>
                <Search
                    style={{
                        right: '10px',
                    }}
                >
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
                    <Link
                        underline={'hover'}
                        onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to="/"
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

export default Navbar;