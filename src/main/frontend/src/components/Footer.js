import {BottomNavigation, Box, Divider, Grid, List, ListItemButton, ListItemText, Typography} from "@mui/material";
import {Facebook, Instagram, WhatsApp} from "@mui/icons-material";
import React from "react";


function onLinkEnter(e) {
    e.target.style.color = '#ec702a';
    e.target.style.animationDuration = '5s';
}

function onLinkLeave(e) {
    e.target.style.color = '#ffffff';
}

const box = {
    paddingLeft: '16px',
    width: '33.33%',
    display: 'flex',
    flexDirection: 'column',
}


const Copyright = () => {


    return (
        <BottomNavigation
            style={{
                alignText: 'center',
                backgroundColor: '#3a3d42',
                display: 'flex',
                justifyContent: 'center',
                padding: '10px',
                height: 'max-content',
                color: '#ffffff',
            }}>
            <Typography variant={'p'}
            >
                © 2022 Berny'z Liquor Store All Rights Reserved.
            </Typography>

        </BottomNavigation>
    )
}

const BottomNav = () => {


    return (
        <BottomNavigation
            style={{
                backgroundColor: '#3a3d42',
                display: 'flex',
                justifyContent: 'space-between',
                padding: '10px',
                height: 'max-content',
                color: '#ffffff',
            }}
        >
            <Box style={box}>
                <h3>SOCIAL</h3>
                <Grid container>
                    <Grid item>
                        <List>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <Facebook/>
                                <ListItemText
                                    style={{
                                        paddingLeft: '5px',
                                    }}
                                    primary="Facebook"/>
                            </ListItemButton>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <Instagram/>
                                <ListItemText
                                    style={{
                                        paddingLeft: '5px',
                                    }}
                                    primary="Instagram"/>
                            </ListItemButton>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <WhatsApp/>
                                <ListItemText
                                    style={{
                                        paddingLeft: '5px',
                                    }}
                                    primary="WhatsApp"/>
                            </ListItemButton>
                        </List>
                    </Grid>
                </Grid>
            </Box>
            <Divider orientation="vertical" variant="middle" flexItem/>
            <Box style={box}>
                <h3>CONTACT US</h3>
                <Grid container>
                    <Grid item>
                        <List>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <ListItemText primary="Email"/>
                            </ListItemButton>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <ListItemText primary="Phone"/>
                            </ListItemButton>
                        </List>
                    </Grid>
                </Grid>
            </Box>
            <Divider orientation="vertical" variant="middle" flexItem/>
            <Box style={box}>
                <h3>INFORMATION</h3>
                <Grid container>
                    <Grid item>
                        <List>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <ListItemText primary="About Us"/>
                            </ListItemButton>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <ListItemText primary="Privacy Policy"/>
                            </ListItemButton>
                            <ListItemButton
                                onMouseEnter={onLinkEnter}
                                onMouseLeave={onLinkLeave}
                            >
                                <ListItemText primary="Terms & Conditions"/>
                            </ListItemButton>
                        </List>

                    </Grid>
                </Grid>
            </Box>

        </BottomNavigation>

    )
};

function Footer() {
    return (
        <div>
            <BottomNav/>
            <Copyright/>
        </div>
    )
}

export default Footer;