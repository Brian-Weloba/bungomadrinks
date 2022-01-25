import {AppBar, Box, CssBaseline, InputBase, Toolbar} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import React from "react";
import {styled} from "@mui/styles";
import {Link as RouterLink} from "react-router-dom";

const navbar = {
    backgroundColor: '#211F2A',

};


const categories = {
    animationDuration: '3s', textDecoration: 'none',
};


const navElement = {
    color: '#ffffff',
    fontSize: '12pt',
    fontWeight: 'bold',
    paddingRight: '10px',
    cursor: 'pointer',
    textDecoration: 'none',
};

const Search = styled('div')(({theme}) => ({
    position: 'relative', borderRadius: theme.shape.borderRadius, backgroundColor: '#ffffff', '&:hover': {
        backgroundColor: '#ffffff',
    }, marginLeft: 0, width: '100%', [theme.breakpoints.up('sm')]: {
        marginLeft: 1, width: 'auto',
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
    color: '#3a3d42', '& .MuiInputBase-input': {
        padding: theme.spacing(1, 1, 1, 0), // vertical padding + font size from searchIcon
        paddingLeft: `calc(1em + ${theme.spacing(4)})`,
        transition: theme.transitions.create('width'),
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            width: '12ch', '&:focus': {
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
            <Box style={{
                boxShadow: "rgba(0, 0, 0, 0.3) 1px 3px 10px 3px",
            }}>
                <Toolbar
                    style={{
                        paddingTop: '10px', display: 'flex', justifyContent: 'space-between',
                    }}
                >
                    <RouterLink to={"/"}>
                        <img src={process.env.PUBLIC_URL + '/logo.png'} height={80} alt={"berny's home"}/>
                    </RouterLink>

                </Toolbar>
                <Toolbar
                    style={{

                        paddingTop: '5px', display: 'flex', justifyContent: 'space-between',
                    }}
                >
                    <div style={categories}>
                        <RouterLink to={"category/whisky"} underline={'none'} onMouseEnter={onLinkEnter}
                                    onMouseLeave={onLinkLeave}
                                    style={navElement}>
                            Whisky
                        </RouterLink>
                        <RouterLink underline={'hover'} onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave}
                                    to="category/gin"
                                    style={navElement}
                        >
                            Gin
                        </RouterLink>
                        <RouterLink
                            underline={'hover'}
                            onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave} to={"category/rum"}
                            style={navElement}
                        >
                            Rum
                        </RouterLink>
                        <RouterLink underline={'hover'} onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave}
                                    to="category/brandy"
                                    style={navElement}
                        >
                            Brandy
                        </RouterLink>
                        <RouterLink underline={'hover'} onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave}
                                    to="category/vodka"
                                    style={navElement}
                        >
                            Vodka
                        </RouterLink>
                        <RouterLink underline={'hover'} onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave}
                                    to="category/wines"
                                    style={navElement}
                        >
                            Wines
                        </RouterLink>
                        <RouterLink underline={'hover'} onMouseEnter={onLinkEnter} onMouseLeave={onLinkLeave}
                                    to="category/cans"
                                    style={navElement}
                        >
                            Cans
                        </RouterLink>
                    </div>
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
            </Box>
        </AppBar>);
}

export default Navbar;