import {AppBar, Box, CssBaseline, IconButton, InputBase, Menu, MenuItem, Toolbar} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import React from "react";
import '../App.css';
import {styled} from "@mui/styles";
import {Link as RouterLink} from "react-router-dom";
import MenuIcon from '@mui/icons-material/Menu';

const navbar = {
    backgroundColor: '#211F2A',
    // position: 'sticky',
    // top: 0,
    width: '100%',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
};

const navbarNull = {
    height: '0',
    animationDuration: '2s',
    display: 'none',
}

const navbarScroll = {
    backgroundColor: '#211F2A',
    display: 'flex',
    justifyContent: 'space-between',

}


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

const menuElement = {
    color: '#211F2A',
    fontSize: '12pt',
    fontWeight: 'bold',
    paddingRight: '10px',
    paddingLeft: '10px',
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

function onMenuLinkLeave(e) {
    e.target.style.color = '#211F2A';
}


const Navbar = () => {
    const [anchorElNav, setAnchorElNav] = React.useState(null);
    const [navBarScroll, setNavBarScroll] = React.useState(false);
    // const listener = document.addEventListener('scroll', () => {
    //     if (window.scrollY > 160) {
    //         setNavBarScroll(true);
    //     } else {
    //         setNavBarScroll(false);
    //     }
    // });

    const handleScroll = () => {
        if (window.scrollY > 160) {
            setNavBarScroll(true);
        } else {
            setNavBarScroll(false);
        }
    };

    window.addEventListener('scroll', handleScroll);


    const img = {
        height: '80px',
    }

    const imgsc = {
        height: '50px',
    }

    const handleOpenNavMenu = (e) => {
        setAnchorElNav(e.currentTarget);
    }

    const handleCloseNavMenu = () => {
        setAnchorElNav(null);
    }

    return (
        <Box>
            <AppBar>
                <CssBaseline/>
                <Toolbar
                    maxWidth="xl"
                    style={ navbar } className="Initial-Nav"
                >
                    <Box
                        style={{
                            width: '100vw',
                            paddingTop: '10px',
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'space-between',
                            paddingBottom: '10px',
                        }}>
                        <Box sx={{mr: 2, display: {xs: 'none', md: 'flex'}}}>
                            <RouterLink
                                noWrap
                                component={'div'}

                                to={"/"}>
                                <img src={process.env.PUBLIC_URL + '/logo.png'} style={!navBarScroll ? img: imgsc}
                                     alt="berny'z logo"/>
                            </RouterLink>
                        </Box>

                        <Box sx={{flexGrow: 1, display: {xs: 'flex', md: 'none'}}}
                        >
                            <IconButton
                                size='large'
                                aria-label="open drawer"
                                aria-controls="nav-menu"
                                aria-haspopup="true"
                                onClick={handleOpenNavMenu}
                                color="inherit"
                            >
                                <MenuIcon/>
                            </IconButton>
                            <Menu
                                maxWidth="80vw"
                                id="menu-appbar"
                                anchorEl={anchorElNav}
                                anchorOrigin={{
                                    vertical: 'bottom',
                                    horizontal: 'left',
                                }}
                                keepMounted
                                transformOrigin={{
                                    vertical: 'top',
                                    horizontal: 'left',
                                }}
                                open={Boolean(anchorElNav)}
                                onClose={handleCloseNavMenu}
                                sx={{
                                    display: {xs: 'block', md: 'none'},
                                }}
                            >
                                <MenuItem>
                                    <Box>
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
                                    </Box>
                                </MenuItem>

                                <MenuItem>
                                    <RouterLink to={"category/whisky"} underline={'none'}
                                                onMouseEnter={onLinkEnter}
                                                onMouseLeave={onMenuLinkLeave}
                                                onClick={handleCloseNavMenu}
                                                style={menuElement}
                                                textAlign={'center'}
                                    >
                                        Whisky
                                    </RouterLink>
                                </MenuItem>
                                <MenuItem>
                                    <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                                onMouseLeave={onMenuLinkLeave}
                                                to="category/gin"
                                                onClick={handleCloseNavMenu}
                                                style={menuElement}
                                    >
                                        Gin
                                    </RouterLink>
                                </MenuItem>
                                <MenuItem>
                                    <RouterLink
                                        underline={'hover'}
                                        onMouseEnter={onLinkEnter} onMouseLeave={onMenuLinkLeave} to={"category/rum"}
                                        onClick={handleCloseNavMenu}
                                        style={menuElement}
                                    >
                                        Rum
                                    </RouterLink>
                                </MenuItem>
                                <MenuItem>
                                    <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                                onMouseLeave={onMenuLinkLeave}
                                                onClick={handleCloseNavMenu}
                                                to="category/brandy"
                                                style={menuElement}
                                    >
                                        Brandy
                                    </RouterLink>
                                </MenuItem>
                                <MenuItem>
                                    <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                                onMouseLeave={onMenuLinkLeave}
                                                onClick={handleCloseNavMenu}
                                                to="category/vodka"
                                                style={menuElement}
                                    >
                                        Vodka
                                    </RouterLink>
                                </MenuItem>
                                <MenuItem>
                                    <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                                onMouseLeave={onMenuLinkLeave}
                                                to="category/wine"
                                                onClick={handleCloseNavMenu}
                                                style={menuElement}
                                    >
                                        Wines
                                    </RouterLink>
                                </MenuItem>
                                <MenuItem>
                                    <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                                onMouseLeave={onMenuLinkLeave}
                                                to="category/canned"
                                                onClick={handleCloseNavMenu}
                                                style={menuElement}
                                    >
                                        Cans
                                    </RouterLink>
                                </MenuItem>
                            </Menu>
                        </Box>
                        <Box sx={{flexGrow: 1, display: {xs: 'flex', md: 'none'}}}
                        >
                            <RouterLink
                                noWrap
                                component={'div'}
                                to={"/"}>
                                <img src={process.env.PUBLIC_URL + '/logo.png'} style={!navBarScroll ? img: imgsc}
                                     alt="berny'z logo"/>
                            </RouterLink>
                        </Box>
                        <Box
                            style={{

                                paddingTop: '5px', justifyContent: 'space-between',
                            }}
                            sx={{mr: 2, display: {xs: 'none', md: 'flex'}}}
                        >
                            <div style={categories}>
                                <RouterLink to={"category/whisky"} underline={'none'} onMouseEnter={onLinkEnter}
                                            onMouseLeave={onLinkLeave}
                                            style={navElement}>
                                    Whisky
                                </RouterLink>
                                <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                            onMouseLeave={onLinkLeave}
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
                                <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                            onMouseLeave={onLinkLeave}
                                            to="category/brandy"
                                            style={navElement}
                                >
                                    Brandy
                                </RouterLink>
                                <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                            onMouseLeave={onLinkLeave}
                                            to="category/vodka"
                                            style={navElement}
                                >
                                    Vodka
                                </RouterLink>
                                <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                            onMouseLeave={onLinkLeave}
                                            to="category/wine"
                                            style={navElement}
                                >
                                    Wines
                                </RouterLink>
                                <RouterLink underline={'hover'} onMouseEnter={onLinkEnter}
                                            onMouseLeave={onLinkLeave}
                                            to="category/canned"
                                            style={navElement}
                                >
                                    Cans
                                </RouterLink>
                            </div>
                        </Box>
                        <Box
                            sx={{mr: 2, display: {xs: 'none', md: 'flex'}}}
                        >
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
                        </Box>
                    </Box>
                </Toolbar>
            </AppBar>
</Box>
)
    ;
}

export default Navbar;