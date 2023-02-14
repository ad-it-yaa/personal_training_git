import {
  Button,
  Card,
  CardActions,
  CardContent,
  Step,
  StepLabel,
  Stepper,
  Typography,
} from "@mui/material";
import { Box } from "@mui/system";
import axios from "axios";
import React, { useEffect, useState } from "react";
import "./Admin_Content.css";

export default function Admin_Content() {
  const [loan, setLoan] = useState([]);
  const [stepcounter, setStepcounter] = useState();
  const [loanstatus, setLoanstatus] = useState();
  const steps = [
    "Applied",
    "Background Checks",
    "Underwriting",
    "Offer",
    "Approved",
  ];
  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await axios.get("http://localhost:8085/nwml/api/loan/get");
        setLoan(
          res.data
            .filter((item) => item.status === "Applied")
            .sort((a, b) => b.creditscore - a.creditscore)
        );
        loan.sort((a, b) => a.loanid - b.loanid);
      } catch (err) {
        console.log(err);
      }
      const stepvalidator = async () => {
        if (loan[0].approved === true) {
          await setStepcounter(5);
          setLoanstatus("Approved");
        } else if (loan[0].offer === true) {
          await setStepcounter(4);
          setLoanstatus("Offer");
        } else if (loan[0].underwriting === true) {
          setLoanstatus("Underwriting");
        } else if (loan[0].valuation === true) {
          await setStepcounter(2);
          setLoanstatus("Background Checks");
        } else {
          await setStepcounter(0);
          setLoanstatus("Applied");
        }
      };
      await stepvalidator();
    };
    fetchData();
  }, []);
  console.log(loan);
  return (
    <div className="admin_content">
      <br />
      <div className="admin_loan_container">
        <div className="admin_loan">
          {loan.map((obj, index) => {
            if (obj.status == "Applied") {
              // loanFound = true;
              let creditScore = "";
              if (obj.creditscore < 550) {
                creditScore = "Very High Risk";
              } else if (loan.creditscore > 551 && loan.creditscore < 600) {
                creditScore = "High Risk";
              } else if (loan.creditscore > 601 && loan.creditscore < 700) {
                creditScore = "Medium Risk";
              } else if (loan.creditscore > 701 && loan.creditscore < 799) {
                creditScore = "Low Risk";
              } else if (loan.creditscore > 800) {
                creditScore = "Very Low Risk";
              }
              index = obj.loanid;

              return (
                <div>
                  <Card sx={{ maxWidth: 800 }}>
                    <CardContent>
                      <Typography gutterBottom variant="h5" component="div">
                        Loan Ref - NWMLO00{obj.loanid}
                      </Typography>
                      <Typography variant="body2" color="text.secondary">
                        Applied on: {obj.applytime}
                      </Typography>
                      <br />
                      <Typography
                        variant="body2"
                        color="text.secondary"
                        style={{ color: "blue" }}
                      >
                        Risk Analysis: {creditScore}
                      </Typography>
                      <Typography variant="body2" color="text.primary">
                        Customer ID: {obj.custid}
                      </Typography>
                      <Typography variant="body2" color="text.primary">
                        Property Estimate: £{obj.propertyrate}
                      </Typography>

                      <Typography variant="body2" color="text.primary">
                        Request Amount: £{obj.loanamt}
                      </Typography>
                      <Typography variant="body2" color="text.primary">
                        Request Tenure: {obj.loantenure} Years
                      </Typography>
                      <Typography variant="body2" color="text.primary">
                        Current Status: {loanstatus}
                      </Typography>
                    </CardContent>
                    <Box sx={{ width: "100%" }}>
                      <Stepper activeStep={stepcounter} alternativeLabel>
                        {steps.map((label) => (
                          <Step key={label}>
                            <StepLabel>{label}</StepLabel>
                          </Step>
                        ))}
                      </Stepper>
                    </Box>

                    <CardActions>
                      <Button size="small" onClick={() => console.log(index)}>
                        Update Status
                      </Button>
                
                      {/* <Button size="small" onClick={() => onClickCancel(index)}>
                      Cancel
                    </Button> */}
                    </CardActions>
                  </Card>
                </div>
              );
            }
          })}{" "}
        </div>
      </div>
    </div>
  );
}
