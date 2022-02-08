import {
  BottomNavigation,
  Box,
  Divider,
  Grid,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
  Typography,
} from "@mui/material";
import { Facebook, Instagram, WhatsApp } from "@mui/icons-material";
import React from "react";
import { Link } from "react-router-dom";

function onLinkEnter(e) {
  //   e.target.style.color = "#ec702a";
  e.target.style.color = "#ffffff";
  e.target.style.animationDuration = "5s";
}

function onLinkLeave(e) {
  e.target.style.color = "#ffffff";
}

const box = {
  paddingLeft: "16px",
  width: "33.33%",
  display: "flex",
  flexDirection: "column",
};

const box2 = {
    paddingLeft: "16px",
    width: "100%",
    display: "flex",
    flexDirection: "column",
  };

const Copyright = () => {
  return (
    <BottomNavigation
      style={{
        backgroundColor: "#211f2a",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        justifyItems: "center",
        padding: "10px",
        height: "max-content",
        color: "#f4f4f4",
        alignItems: "center",
      }}
    >
      <Typography variant="p">
        © 2022 Berny'z Liquor Store All Rights Reserved.
      </Typography>
      <Typography variant="p">{/*Developed By: Brian Weloba*/}</Typography>
    </BottomNavigation>
  );
};

const BottomNav = () => {
  return (
    <Box>
      <Box
        style={{
          marginRight: "0",
        }}
        sx={{ mr: 2, display: { xs: "none", md: "flex" } }}
      >
        <BottomNavigation
          style={{
            backgroundColor: "#211f2a",
            display: "flex",
            justifyContent: "space-between",
            padding: "10px",
            height: "max-content",
            color: "#ffffff",
            width: "100vw",
          }}
        >
          <Box style={box}>
            <Typography variant="h6">SOCIAL</Typography>
            <Grid container>
              <Grid item>
                <ListItemButton
                  component="a"
                  href="https://wa.me/254711346421"
                  onMouseEnter={onLinkEnter}
                  onMouseLeave={onLinkLeave}
                >
                  <WhatsApp />
                  <ListItemText
                    style={{
                      paddingLeft: "5px",
                    }}
                    primary="WhatsApp"
                  />
                </ListItemButton>
                <List>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <Facebook />
                    <ListItemText
                      style={{
                        paddingLeft: "5px",
                      }}
                      primary="Facebook"
                    />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <Instagram />
                    <ListItemText
                      style={{
                        paddingLeft: "5px",
                      }}
                      primary="Instagram"
                    />
                  </ListItemButton>
                </List>
              </Grid>
            </Grid>
          </Box>
          <Divider
            color={"#675b4f"}
            orientation="vertical"
            variant="middle"
            flexItem
          />
          <Box style={box}>
            <Typography variant="h6">CONTACT US</Typography>
            <Grid container>
              <Grid item>
                <List>
                  <ListItemButton
                    component="a"
                    href="tel:+254711346421"
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Phone" />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Email" />
                  </ListItemButton>
                </List>
              </Grid>
            </Grid>
          </Box>
          <Divider
            color={"#675b4f"}
            orientation="vertical"
            variant="middle"
            flexItem
          />
          <Box style={box}>
            <Typography variant="h6">INFORMATION</Typography>
            <Grid container>
              <Grid item>
                <List>
                  <ListItem>
                    <Typography variant="p">Payment: On Delivery</Typography>
                  </ListItem>
                  <ListItem>
                    <Typography variant="p">
                      Delivery Time: 90 MINUTES MON-SUN 8:30AM – 6:15PM
                    </Typography>
                  </ListItem>
                  <ListItem>
                    <Typography variant="p">Call: +254711346421</Typography>
                  </ListItem>
                  <ListItem>
                    <Typography variant="p">Buy Goods:9378773</Typography>
                  </ListItem>
                  {/* <ListItem>
                    <Typography variant="p">
                      Currently Delivering To:
                    </Typography>
                  </ListItem> */}
                  {/* <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="About Us" />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Privacy Policy" />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Terms & Conditions" />
                  </ListItemButton> */}
                </List>
              </Grid>
            </Grid>
          </Box>
        </BottomNavigation>
      </Box>
      <Box
        style={{
          margin: "0",
        }}
        sx={{ flexGrow: 1, display: { xs: "flex", md: "none" } }}
      >
        <BottomNavigation
          style={{
            backgroundColor: "#211f2a",
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-between",
            padding: "10px",
            height: "max-content",
            width: "100%",
            color: "#ffffff",
            margin: "0",
          }}
        >
          <Box style={box2}>
            <Typography variant="h6">SOCIAL</Typography>
            <Grid container>
              <Grid item>
                <List>
                  <ListItemButton
                    component="a"
                    href="https://wa.me/254711346421"
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <WhatsApp />
                    <ListItemText
                      style={{
                        paddingLeft: "5px",
                      }}
                      primary="WhatsApp"
                    />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <Facebook />
                    <ListItemText
                      style={{
                        paddingLeft: "5px",
                      }}
                      primary="Facebook"
                    />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <Instagram />
                    <ListItemText
                      style={{
                        paddingLeft: "5px",
                      }}
                      primary="Instagram"
                    />
                  </ListItemButton>
                </List>
              </Grid>
            </Grid>
          </Box>
          <Divider
            style={{
              height: "2px",
              margin: "10px",
            }}
            color={"#675b4f"}
            orientation="horizontal"
            variant="middle"
            flexItem
          />
          <Box style={box2}>
            <Typography variant="h6">CONTACT US</Typography>
            <Grid container>
              <Grid item>
                <List>
                  <ListItemButton
                    component="a"
                    href="tel:+254711346421"
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Phone" />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Email" />
                  </ListItemButton>
                </List>
              </Grid>
            </Grid>
          </Box>
          <Divider
            style={{
              height: "2px",
              margin: "10px",
            }}
            color={"#675b4f"}
            orientation="horizontal"
            variant="middle"
            flexItem
          />
          <Box style={box2}>
            <Typography variant="h6">INFORMATION</Typography>
            <Grid container>
              <Grid item>
                <List>
                <ListItem>
                    <Typography variant="p">Payment: On Delivery</Typography>
                  </ListItem>
                  <ListItem>
                    <Typography variant="p">
                      Delivery Time: 90 MINUTES MON-SUN 8:30AM – 6:15PM
                    </Typography>
                  </ListItem>
                  <ListItem>
                    <Typography variant="p">
                        Call: +254711346421</Typography>
                  </ListItem>
                  <ListItem>
                    <Typography variant="p">
                        Buy Goods: 9378773</Typography>
                  </ListItem>
                  {/* <ListItem>
                    <Typography variant="p">
                      Currently Delivering To:
                    </Typography>
                  </ListItem> */}
                  {/* <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="About Us" />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Privacy Policy" />
                  </ListItemButton>
                  <ListItemButton
                    disabled
                    onMouseEnter={onLinkEnter}
                    onMouseLeave={onLinkLeave}
                  >
                    <ListItemText primary="Terms & Conditions" />
                  </ListItemButton> */}
                </List>
              </Grid>
            </Grid>
          </Box>
        </BottomNavigation>
      </Box>
    </Box>
  );
};

function Footer() {
  return (
    <div>
      <BottomNav />
      <Copyright />
    </div>
  );
}

export default Footer;
