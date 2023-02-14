import {
  Box,
  Button,
  Card,
  CardActions,
  CardContent,
  CardMedia,
  Step,
  StepLabel,
  Stepper,
  Typography,
} from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Status.css";
import { confirmAlert } from "react-confirm-alert";
import "react-confirm-alert/src/react-confirm-alert.css";
export default function Status() {
  let navigate = useNavigate();
  const [loan, setLoan] = useState([]);
  const [temp, setTemp] = useState([]);
  const [custid, setCustID] = useState([]);
  const [error, setError] = useState();
  const [stepcounter, setStepcounter] = useState();
  const [validation, setValidation] = useState([]);
  let token = sessionStorage.getItem("token");
  let id = sessionStorage.getItem("id");
  let loanFound = false;
  let timestamp = Date();
  const cancellimit = loan.filter((loan) => loan.status === "cancel");
  const steps = [
    "Applied",
    "Background Checks",
    "Underwriting",
    "Offer",
    "Approved",
  ];

  const onClickCancel = async (index) => {
    confirmAlert({
      customUI: ({ onClose }) => {
        return (
          <div className="custom-ui">
            <h1>Are you sure?</h1>
            <p>You want to cancel this request?</p>
            <button onClick={onClose}>No</button>
            <button
              onClick={() => {
                execution();
                onClose();
              }}
            >
              Yes
            </button>
          </div>
        );
      },
    });
    const execution = () => {
      try {
      const config = {
      headers: {
      Authorization: `Bearer ${token}`
      }
      };
      const response = axios.put(
      `http://localhost:8080/api/loan/update/${index}`,
      {
      updatetime: timestamp,
      status: "cancel"
      },
      config
      );
      setValidation(true); 
      window.location.reload(false);
      } catch (error) {
        setValidation(false); 
      console.error(error);
      
      }
      };
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await axios.get("http://localhost:8080/api/loan/get", {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setLoan(res.data.filter((item) => item.custid === parseInt(id)));
        let appliedstatus = res.data.filter(
          (loan) => loan.status === "Applied"
        );
        setValidation(true); 
   
        const stepvalidator = async () => {
          if (appliedstatus[0].approved === true) {
            await setStepcounter(5);
          } else if (appliedstatus[0].offer === true) {
            await setStepcounter(4);
          } else if (appliedstatus[0].underwriting === true) {
            await setStepcounter(3);
          } else if (appliedstatus[0].valuation === true) {
            await setStepcounter(2);
          } else {
            await setStepcounter(0);
          }
        };
        await stepvalidator();
      } catch (err) {

        setValidation(false);
      }
    };
    fetchData();
  }, [validation,loan]);
if(validation==true)
{  return (
  <div>
    {/* <div className='loan_header'>
      {
          loan.map(obj=>
              <div className='loan_head'>Loan ID - {obj.id}</div>
              )
      }    
      </div> */}
    <div className="loan_header">
      {loan.map((obj, index) => {
        if (obj.status == "Applied") {
          loanFound = true;
          index = obj.loanid;
          return (
            <div>
              <br />
              <br />
              <Card sx={{ minWidth: 500 }}>
                <CardContent>
                  <Typography gutterBottom variant="h5" component="div">
                    Loan Ref - NWMLO00{obj.loanid}
                  </Typography>
                  <Typography
                    variant="body2"
                    color="text.secondary"
                    style={{ color: "blue" }}
                  >
                    Status: In-Progress
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Loan amount of £{obj.loanamt}
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
                  {/* <Button size="small" onClick={() => console.log(index)}> */}
                    {/* Check Status */}
                  {/* </Button> */}
                  <Button size="small" onClick={() => onClickCancel(index)}>
                    Cancel
                  </Button>
                </CardActions>
              </Card>
              <br />
              <br />
              <br />
            </div>
          );
        }
      })}
      {loan.map((obj, index) => {
        if (obj.status == "cancel") {
          loanFound = true;
          return (
            <div className="danger">
              <br />
              <br />
              <Card sx={{ maxWidth: 800 }}>
                <CardContent>
                  <Typography
                    gutterBottom
                    variant="h5"
                    component="div"
                    style={{ color: "red" }}
                  >
                    Loan Ref - NWMLO00{obj.loanid}
                  </Typography>
                  <Typography
                    variant="body2"
                    color="text.secondary"
                    style={{ color: "red" }}
                  >
                    Status: Cancelled
                  </Typography>
                  <Typography variant="body2">
                    Loan amount of £{obj.loanamt}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Applied on: {obj.applytime}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Cancelled on: {obj.updatetime}
                  </Typography>
                </CardContent>
                <CardActions>
                  {/* <Button size="small" onClick={()=>console.log(index)}>Check Status</Button> */}
                  {/* <Button size="small" onClick={()=>onClickCancel(index)}>Cancel</Button> */}
                </CardActions>
              </Card>
              <br />
              <br />
              <br />
            </div>
          );
        }
      })}

      {!loanFound && (
        <div className="loan_head">There are no request currently</div>
      )}
    </div>
  </div>
)}
else
{
  navigate("/login");

}
}
{
  /* <CardMedia
                      component="img"
                      alt="green iguana"
                      height="140"
                      image="/static/images/cards/contemplative-reptile.jpg"
                    /> */
}
