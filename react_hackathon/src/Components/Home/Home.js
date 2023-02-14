import React from 'react'
import './Home.css'
export default function Home() {
  return (
    <div>
<main>
    <div className="main_container card">
        <div className="para0 card-body">
            
                <div className="main_content card">
                    <h1 className="heading_font color" data-aos="slide-up"><b>Q3 Results</b></h1>
                    <h3 data-aos="flip-down">Our Performance in Q3 2022</h3>
                    <img className="graph" src="https://www.kindpng.com/picc/m/572-5724554_business-solutions-graph-icon-png-download-purple-graph.png" data-aos="zoom-out-right"/>
             
                <div className="main_image"></div>
            </div>
        </div>
        <div className="para1 flex ">
            <h3 className='color' data-aos="slide-up">Thrive together</h3>
            <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/new-images-2022/single-article/image.dim.360.Natwest_erp_camden_0051_445x275.jpg" data-aos="slide-up" width="500px"/>
            <p className="p" data-aos="slide-up">By building ever deeper relationships with our customers, by taking action on the issues
                they care about and by supporting them more effectively at key stages of their lives, we can help
                our customers to thrive.</p>
        </div>
        <div className="para1 flex card">
            <h3 data-aos="slide-up">Our partnership with Marcus Rashford</h3>

            <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/image.dim.480.marcus-rashford-445x275.png" data-aos="slide-up" width="500px"/>
            <p className="p" data-aos="slide-up">We are partnering with Marcus Rashford MBE to co-create a programme to help young people to
                thrive.</p>
        </div>
        <div className="para1 flex ">
            <h3 className='color' data-aos="slide-up">CareerSense</h3>
            <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/image.dim.480.our-brands.jpeg" data-aos="slide-up" width="500px"/>
            <p className="p" data-aos="slide-up"> CareerSense is our employability education programme aimed at improving employability
                prospects for young people aged 13-24 in the UK.

                We're proud to be helping champion the potential and economic resilience of young people, and look
                forward to growing this programme in partnership with schools across the UK.</p>
        </div>
        <div className="para1 flex ">
            <h3 id="aboutus" data-aos="slide-up">Forward thinking… back in time</h3>
            <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/image.dim.480.our_history_page.jpg" data-aos="slide-up" width="500px"/>
            <p className="p">Our history in Britain goes back for hundreds of years. As we look to the future, we build
                on strong foundations to meet new challenges. Take a walk down memory lane with us and enjoy the
                events that make us proud to be NatWest Group today.</p>
        </div>
            
        <div id="contactus" className="contact flex card">
            <br/>
            <h2 className="contact_font" data-aos="slide-up">Contact us:</h2>
            <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/image.dim.360.who-we-are.jpeg" data-aos="slide-up" width="500px"/>
            <span id="font">Our Head Office:</span>
            <div id="font">
                 Kosmo One, 35R6+XQX, Ambattur Rd,<br/>
                Chennai, India,TN.<br/>
                
            </div>
            <span id="font">Phone Number: +91 1234567890</span>
        </div>
    </div>
</main>
<br/>
</div>
  )
}
