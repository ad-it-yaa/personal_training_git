import React, { useState } from 'react'
import './EMICalculator.css'
 
export default function EMICalculator() {
  const [principal, setPrincipal] = useState(0);
  const [interest, setInterest] = useState(5);
  const [tenure, setTenure] = useState(0);
  const [emiArray, setEMIArray] = useState([]);

  const calculateEMI = () => {
    const r = interest / (12 * 100);
    const t = tenure * 12;
    let emi = (principal * r * (1 + r) ** t) / (((1 + r) ** t) - 1);
    emi = emi.toFixed();
    let emiArray = [];
    let outstanding = principal;
    if(outstanding<10000 || t<1)
    {
      alert("Enter valid amt or tenure")
    }
    else
    {
    for (let i = 0; i < t; i++) {
      let interestAmount = outstanding * r;
      let principalAmount = emi - interestAmount;
      outstanding -= principalAmount;
      if (i == t - 1) {
        
        principalAmount=principalAmount+outstanding;
        interestAmount=interestAmount-outstanding;
        outstanding=0;
      }
      emiArray.push({
        month: i + 1,
        emi: emi,
        interest: interestAmount.toFixed(2),
        principal: principalAmount.toFixed(2),
        outstanding: outstanding.toFixed(2)
      });
    }
    setEMIArray(emiArray);
  }
  };

  return (
    <div>
      <div className='emi_container'>
        <br/>
      <div>
      <label className='emi_label'>Principal:</label>
      <input
        type="number"
        value={principal}
        onChange={e => setPrincipal(e.target.value)}
      /></div>
      <br />
      <div><label className='emi_label'>Interest:</label>
      <input
        type="number"
        value={interest}
        onChange={e => setInterest(e.target.value)}
      /></div>
      <br />
      <div>
      <label className='emi_label'>Tenure (in years):</label>
      <input
        type="number"
        value={tenure}
        onChange={e => setTenure(e.target.value)}
      />
      </div>
      <br />
      <button onClick={calculateEMI}>Calculate EMI</button>
      </div>
      <br />
      <table align='center' border='2px'>
        <thead>
          <tr>
            <th>Month</th>
            <th>EMI</th>
            <th>Interest</th>
            <th>Principal</th>
            <th>Outstanding</th>
          </tr>
        </thead>
        <tbody>
          {emiArray.map((item, index) => (
            <tr key={index}>
              <td>{item.month}</td>
              <td>{item.emi}</td>
              <td>{item.interest}</td>
              <td>{item.principal}</td>
              <td>{item.outstanding}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <br/>
    </div>
  );
}



