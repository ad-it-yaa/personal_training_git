import React from 'react'
import './Card.css'
export default function Card() {
    let token = sessionStorage.getItem('name');
    let card = sessionStorage.getItem('card')
    return (
        <div>
            <div className='card_container'>
                <div className='card_body'>
                    <div className='nat_card_logo'>
                        <div className='card_logo_main'>
                            <img src="https://seeklogo.com/images/N/nat-west-1969-to-2016-logo-A61F210017-seeklogo.com.png" width={50} /></div></div>
                    <div className='chip_container'>
                        <div className='chip'>
                            <div className='line1'>

                                <div className='line2'></div>

                                <div className='line2'></div>
                            </div>
                            <div className='line1'>
                                <div className='line2'></div>
                            </div>
                            <div className='line1'>
                                <div className='line2'></div>
                            </div>
                            <div className='line1'>
                                <div className='line2'></div>
                            </div>
                            <div className='line1'>
                                <div className='line2'></div>
                            </div>
                            <div className='line1'>
                                <div className='line2'></div>
                            </div>
                            <div className='line1'>
                                <div className='line2'></div>
                            </div>
                        </div>
                    </div>
                    <div className='cardnumber'>XXXX XXXX XXXX {card}</div>
                    <div className='card_validity'>
                        <p>Exp. <span>12/22</span></p>
                    </div>
                    <div className='cardholder_name'>
                        <p>{token}</p>
                    <img src='https://www.pngall.com/wp-content/uploads/2017/05/Visa-Logo-Free-Download-PNG.png' width={70} className='visa_logo'/>
                    </div>

                </div> </div>

        </div>

    )
}
